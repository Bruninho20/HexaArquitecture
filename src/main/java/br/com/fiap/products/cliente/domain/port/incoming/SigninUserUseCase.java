package br.com.fiap.products.cliente.domain.port.incoming;

import org.springframework.http.ResponseEntity;

import br.com.fiap.products.cliente.application.controller.auth.request.SignInRequest;

public interface SigninUserUseCase {
	
	ResponseEntity<Object> authenticateUser(SignInRequest loginRequest);

	ResponseEntity<Object> refreshUserToken(String refreshToken);

}
