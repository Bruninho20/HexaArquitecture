package br.com.fiap.products.cliente.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.fiap.products.cliente.application.controller.dto.request.CreatePlanRequest;
import br.com.fiap.products.cliente.application.controller.dto.request.RegisterUserRequest;
import br.com.fiap.products.cliente.application.controller.dto.response.ClientResponse;
import br.com.fiap.products.cliente.application.controller.dto.response.InternetResponse;
import br.com.fiap.products.cliente.application.controller.dto.response.MessageResponse;
import br.com.fiap.products.cliente.common.config.TimeStampUtils;
import br.com.fiap.products.cliente.common.constants.LogMessage;
import br.com.fiap.products.cliente.common.constants.MessageReturn;
import br.com.fiap.products.cliente.domain.mapper.ValueMapper;
import br.com.fiap.products.cliente.domain.model.Product;
import br.com.fiap.products.cliente.domain.model.User;
import br.com.fiap.products.cliente.domain.model.UserProduct;
import br.com.fiap.products.cliente.domain.port.incoming.ClientUseCase;
import br.com.fiap.products.cliente.domain.port.outgoing.ClientPort;
import br.com.fiap.products.cliente.infrastructure.repository.ProductPlanRepository;
import br.com.fiap.products.cliente.infrastructure.repository.UserJpaRepository;
import br.com.fiap.products.cliente.infrastructure.repository.UserProductRepository;
import br.com.fiap.products.cliente.infrastructure.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@Service
public class ClientService implements ClientUseCase, ClientPort {

	private final Logger logger = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Autowired
	private UserProductRepository userProductRepository;

	@Autowired
	private ProductPlanRepository productPlanRepository;

	@Autowired
	private ValueMapper valueMapper;

	@Override
	public ResponseEntity<Object> crateUser(RegisterUserRequest registerUserRequest) {
		logger.info("Service");
		User userModel = userJpaRepository.findUserByEmailIgnoreCase(registerUserRequest.getEmail());

		if (userModel != null) {
			logger.warn(LogMessage.EMAIL_ALREADY_TAKEN, registerUserRequest.getEmail());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email ja cadastrado !");
		}

		List<User> userModels = userJpaRepository.findUserByCpf(registerUserRequest.getCpf());

		if (!userModels.isEmpty()) {
			logger.warn("Cpf ja existe", registerUserRequest.getCpf());
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF ja cadastrado !");
		}

		User user = new User();

		user.setCreateDate(TimeStampUtils.getBrasilitaTimestamp().toLocalDateTime());
		user.setEmail(registerUserRequest.getEmail());
		user.setFirstName(registerUserRequest.getFirstName());
		user.setPassword(encoder.encode(registerUserRequest.getPassword()));
		user.setSurName(registerUserRequest.getSurName());
		user.setTelephone(registerUserRequest.getTelephone());
		user.setCpf(registerUserRequest.getCpf());
		user.setLastUpdatedDate(TimeStampUtils.getBrasilitaTimestamp().toLocalDateTime());
		user.setIsActivated(false);

		user = userJpaRepository.save(user);

		String token = jwtUtils.generateRefreshTokenJwt(registerUserRequest.getEmail());

		logger.info("Usuário registrado com sucesso !", registerUserRequest.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body(token);
	}

	public String getMessage(String code) {
		return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
	}

	@Override
	public ResponseEntity<Object> getAll() {
		List<User> pro = userJpaRepository.findAll();

		if (!pro.isEmpty()) {

			logger.info(LogMessage.USER_GET_ALL, pro.size());
			return ResponseEntity.status(HttpStatus.OK).body(pro);
		} else {
			logger.warn(LogMessage.USER_ANY_FOUND);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new MessageResponse(getMessage(MessageReturn.USER_ANY_FOUND)));
		}
	}

	@Override
	public ResponseEntity<Object> activateAccount(@Valid String token) {
		Boolean isValid = jwtUtils.validateJwtToken(token);

		if (Boolean.FALSE.equals(isValid)) {
			logger.warn(LogMessage.TOKEN_INVALID, token);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new MessageResponse(getMessage(MessageReturn.INVALID_TOKEN)));
		}

		if (Boolean.TRUE.equals(jwtUtils.isAccessToken(token))) {
			logger.warn(LogMessage.TOKEN_INVALID, token);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new MessageResponse(getMessage(MessageReturn.INVALID_TOKEN)));
		}

		String userEmail = jwtUtils.getUserNameFromJwtToken(token);

		User userModel = userJpaRepository.findUserByEmailIgnoreCase(userEmail);

		if (userModel != null && !userModel.getIsActivated()) {
			userModel.setIsActivated(true);
			userJpaRepository.save(userModel);
			logger.info(LogMessage.USER_ACTIVATE_SUCCESS, userEmail);
			return ResponseEntity.status(HttpStatus.OK).body("Usuário ativado com sucesso {} ");
		} else {
			logger.warn(LogMessage.USER_ALREADY_ACTIVATED, userEmail);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário ja ativado !!");
		}
	}

	@Override
	public ResponseEntity<Object> registerPlan(@Valid CreatePlanRequest createPlanRequest) {
		logger.info("Service");

		Long userId = createPlanRequest.getIdUser();
		Long productId = createPlanRequest.getIdProduct();

		if (userId == null || productId == null) {
			return ResponseEntity.badRequest().body("User ID and Product ID must not be null");
		}

		User user = userJpaRepository.findById(userId).orElseThrow();
		Product product = productPlanRepository.findById(productId).orElseThrow();

		List<String> activeSubsTypes = user.getActiveSubsType();
		if (activeSubsTypes == null) {
			activeSubsTypes = new ArrayList<>();
		}
		String newSubscriptionDescription = product.getSubscriptionType().getDescription();
		if (!activeSubsTypes.contains(newSubscriptionDescription)) {
			activeSubsTypes.add(newSubscriptionDescription);
		}
		user.setActiveSubsType(activeSubsTypes);
		userJpaRepository.save(user);

		List<UserProduct> existingUserProducts = userProductRepository.findByStatus(productId, userId);

		if (existingUserProducts != null && !existingUserProducts.isEmpty()) {
			for (UserProduct existingUserProduct : existingUserProducts) {
				existingUserProduct.setStatus("SUSPEND");
				userProductRepository.save(existingUserProduct);
			}
		}

		UserProduct userProduct = new UserProduct();
		userProduct.setUser(user);
		userProduct.setProduct(product);
		userProduct.setStatus("ACTIVE");
		userProduct.setIdentifiers(Collections.emptyList());
		userProductRepository.save(userProduct);

		return ResponseEntity.status(HttpStatus.OK).body(userProduct);
	}

	@Override
	public ResponseEntity<Object> getById(Long userId) {
		logger.info("Getting products for user with ID: {}", userId);

		User user = userJpaRepository.findByUserId(userId.longValue());
		List<Object> responses = new ArrayList<>();

		if (user != null) {
			user.getActiveSubsType().stream().forEach(map -> {
				map = map.trim();
				switch (map) {
				case "value_add_service": {
					responses.add(getByValueAdd(userId).getBody());
					break;
				}
				case "pospaid": {
					responses.add(getByPospaid(userId));
					break;
				}
				case "prepaid": {
					responses.add(getByPrepaid(userId).getBody());
					break;
				}
				case "internet": {
					responses.add(getByInternet(userId).getBody());
					break;

				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + map);
				}
			});
		}

		return ResponseEntity.status(HttpStatus.OK).body(responses);
	}

	@Override
	public ResponseEntity<Object> getByPospaid(Long userId) {
		logger.info("Getting products for user with ID: {}", userId);
		
		Long pospaid = 2L;

		List<Object[]> userProducts = productPlanRepository.findByValueUser(userId, pospaid);

		if (userProducts.isEmpty()) {
			logger.warn("No products found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for user with ID: " + userId);
		}
		
		List<ClientResponse> productDTOs = valueMapper.mapToProductDTOList(userProducts);


		return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
	}

	@Override
	public ResponseEntity<Object> getByPrepaid(Long userId) {
		logger.info("Getting products for user with ID: {}", userId);

		Long prepaid = 1L;

		List<Object[]> userProducts = productPlanRepository.findByValueUser(userId, prepaid);

		if (userProducts.isEmpty()) {
			logger.warn("No products found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for user with ID: " + userId);
		}

		List<ClientResponse> productDTOs = valueMapper.mapToProductDTOList(userProducts);

		return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
	}

	@Override
	public ResponseEntity<Object> getByInternet(Long userId) {
		logger.info("Getting products for user with ID: {}", userId);

		Long internet = 3L;

		List<Object[]> userProducts = productPlanRepository.findByValueUser(userId, internet);

		if (userProducts.isEmpty()) {
			logger.warn("No products found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for user with ID: " + userId);
		}

		List<InternetResponse> productDTOs = valueMapper.mapToInternetDTOList(userProducts);

		return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
	}

	@Override
	public ResponseEntity<Object> getByValueAdd(Long userId) {
		logger.info("Getting products for user with ID: {}", userId);

		Long subscriptionTypeId = 4L;

		List<Object[]> userProducts = productPlanRepository.findByValueUser(userId, subscriptionTypeId);

		if (userProducts.isEmpty()) {
			logger.warn("No products found for user with ID: {}", userId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found for user with ID: " + userId);
		}

		List<ClientResponse> productDTOs = valueMapper.mapToProductDTOList(userProducts);

		return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
	}

}
