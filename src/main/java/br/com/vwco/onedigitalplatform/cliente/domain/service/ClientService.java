package br.com.vwco.onedigitalplatform.cliente.domain.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.MessageResponse;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.UserDto;
import br.com.vwco.onedigitalplatform.cliente.common.config.TimeStampUtils;
import br.com.vwco.onedigitalplatform.cliente.common.constants.LogMessage;
import br.com.vwco.onedigitalplatform.cliente.common.constants.MessageReturn;
import br.com.vwco.onedigitalplatform.cliente.domain.mapper.UserMapper;
import br.com.vwco.onedigitalplatform.cliente.domain.model.User;
import br.com.vwco.onedigitalplatform.cliente.domain.port.incoming.ClientUseCase;
import br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing.ClientPort;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.repository.UserJpaRepository;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.security.jwt.JwtUtils;
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

	private final UserMapper userMapper = new UserMapper();

	@Override
	public ResponseEntity<Object> createUser(RegisterUserRequest registerUserRequest) {
		logger.info("Service");
		User userModel = userJpaRepository.findUserByEmailIgnoreCase(registerUserRequest.getEmail());

		if (userModel != null) {
			logger.warn(LogMessage.EMAIL_ALREADY_TAKEN, registerUserRequest.getEmail());
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Email ja cadastrado !");
		}

		List<User> userModels = userJpaRepository.findUserByCpf(registerUserRequest.getCpf());

		if (!userModels.isEmpty()) {
			logger.warn("Cpf ja existe", registerUserRequest.getCpf());
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("CPF ja cadastrado !");
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
		user.setId(UUID.randomUUID());
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
		List<User> users = userJpaRepository.findAll();

		if (!users.isEmpty()) {
			List<UserDto> userDtos = userMapper.toDtoList(users);
			logger.info(LogMessage.USER_GET_ALL, users.size());
			return ResponseEntity.status(HttpStatus.OK).body(userDtos);
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
			return ResponseEntity.status(HttpStatus.OK)
					.body("Usuário ativado com sucesso {} ");
		} else {
			logger.warn(LogMessage.USER_ALREADY_ACTIVATED, userEmail);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Usuário ja ativado !!");
		}
	}
}
