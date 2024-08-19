package br.com.fiap.products.cliente.application.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.products.cliente.application.controller.auth.request.SignInRequest;
import br.com.fiap.products.cliente.common.constants.LogMessage;
import br.com.fiap.products.cliente.infrastructure.service.AuthServiceImpl;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("access/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthControllerImpl implements AuthController {

	private final Logger logger = LoggerFactory.getLogger(AuthControllerImpl.class);
	private final AuthServiceImpl authServiceImpl;

	public AuthControllerImpl(AuthServiceImpl authServiceImpl) {
		this.authServiceImpl = authServiceImpl;
	}

	@Override
	@PostMapping("/signin")
	public ResponseEntity<Object> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {
		logger.info(LogMessage.AUTH_CONTROLLER_REACHED, signInRequest.getEmail());
		return authServiceImpl.authenticateUser(signInRequest);
	}

	@Override
	@GetMapping("/refresh/{refreshToken}")
	public ResponseEntity<Object> refreshUserToken(@PathVariable String refreshToken) {
		logger.info(LogMessage.AUTH_CONTROLLER_REACHED, refreshToken);
		return authServiceImpl.refreshUserToken(refreshToken);
	}
	
}
