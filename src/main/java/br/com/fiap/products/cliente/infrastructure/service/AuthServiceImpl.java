package br.com.fiap.products.cliente.infrastructure.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.products.cliente.application.controller.auth.request.SignInRequest;
import br.com.fiap.products.cliente.application.controller.dto.response.JwtResponse;
import br.com.fiap.products.cliente.application.controller.dto.response.MessageResponse;
import br.com.fiap.products.cliente.common.constants.LogMessage;
import br.com.fiap.products.cliente.common.constants.MessageReturn;
import br.com.fiap.products.cliente.domain.model.User;
import br.com.fiap.products.cliente.domain.port.incoming.SigninUserUseCase;
import br.com.fiap.products.cliente.infrastructure.repository.UserJpaRepository;
import br.com.fiap.products.cliente.infrastructure.security.jwt.JwtUtils;
import jakarta.validation.Valid;

@Service
public class AuthServiceImpl implements SigninUserUseCase {

	private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	private final UserJpaRepository userJpaRepository;
	private UserDetailsServiceImpl userDetailsService;
	private final JwtUtils jwtUtils;
	private PasswordEncoder encoder;
	//private LoginAttemptUseCase loginAttemptUseCase;
	//private final SendMailUseCase sendMail;
	private MessageSource messageSource;

	public AuthServiceImpl(UserJpaRepository userJpaRepository, UserDetailsServiceImpl userDetailsService,
			JwtUtils jwtUtils, PasswordEncoder encoder,
			MessageSource messageSource) {
		this.userJpaRepository = userJpaRepository;
		this.userDetailsService = userDetailsService;
		this.jwtUtils = jwtUtils;
		this.encoder = encoder;
		this.messageSource = messageSource;
	}

	@Override
	public ResponseEntity<Object> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {
		String userEmail = signInRequest.getEmail();
		User userModel = userJpaRepository.findUserByEmailIgnoreCase(userEmail);
		
		String userMail = signInRequest.getEmail();

		logger.info(LogMessage.AUTH_REQUEST_USER, signInRequest.getEmail());
		
		if (userModel == null) {
			logger.warn(LogMessage.USER_NOT_FOUND, userEmail);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(getMessage(MessageReturn.INVALID_USER_OR_PASSWORD)));
		}

				
		if (!encoder.matches(signInRequest.getPassword(), userModel.getPassword())) {
			logger.info(LogMessage.INVALID_PASSWORD, signInRequest.getPassword());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse(getMessage(MessageReturn.INVALID_USER_OR_PASSWORD)));
		}

		try {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String accessJwt = jwtUtils.generateAccessTokenJwt(userEmail);
			String refreshJwt = jwtUtils.generateRefreshTokenJwt(userEmail);
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).toList();
			logger.info(LogMessage.AUTH_SUCCESS_USER, userEmail);
			User authenticatedUser = userModel;

			

	

			return ResponseEntity.status(HttpStatus.OK)
					.body(new JwtResponse(accessJwt, refreshJwt, authenticatedUser.getId(),
							authenticatedUser.getFirstName(), authenticatedUser.getSurName(),
							authenticatedUser.getEmail(), roles));
		} catch (Exception e) {
			System.out.println(e);
			logger.error(LogMessage.AUTH_NOT_AUTHENTICATED, userEmail, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse(getMessage(MessageReturn.AUTH_USER_NOT_AUTHENTICATED)));
		}
	}

	@Override
	public ResponseEntity<Object> refreshUserToken(String refreshToken) {
		
		logger.info(LogMessage.REFRESH_TOKEN_REQUEST, refreshToken);

		try {
			
			String userEmail = jwtUtils.getUserNameFromJwtToken(refreshToken);
			
			if (!jwtUtils.validateJwtToken(refreshToken)) {
				logger.warn(LogMessage.REFRESH_TOKEN_INVALID, refreshToken);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new MessageResponse(getMessage(MessageReturn.REFRESH_TOKEN_INVALID)));
			}

			UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
			User userFound = userJpaRepository.findUserByEmailIgnoreCase(userEmail);

			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);

			String accessJwt = jwtUtils.generateAccessTokenJwt(userEmail);
			String refreshJwt = jwtUtils.generateRefreshTokenJwt(userEmail);
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).toList();

			if (accessJwt != null) {
				logger.info(LogMessage.REFRESH_TOKEN_SUCCESS, userDetails.getUsername());

				return ResponseEntity.status(HttpStatus.OK)
						.body(new JwtResponse(accessJwt, refreshJwt, userFound.getId(), userFound.getFirstName(),
								userFound.getSurName(), userFound.getEmail(), roles));
			} else {
				logger.warn(LogMessage.REFRESH_TOKEN_INVALID, userDetails.getUsername());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new MessageResponse(getMessage(MessageReturn.REFRESH_TOKEN_INVALID)));
			}
		} catch (Exception e) {
			logger.error(LogMessage.REFRESH_TOKEN_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new MessageResponse(getMessage(MessageReturn.REFRESH_TOKEN_ERROR)));
		}
	}
	
	
	
	
	public String getMessage(String code) {
	    return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
	}

}