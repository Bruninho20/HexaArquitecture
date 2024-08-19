package br.com.fiap.products.cliente.domain.port.outgoing;

import org.springframework.http.ResponseEntity;

import br.com.fiap.products.cliente.application.controller.dto.request.RegisterUserRequest;

public interface ClientPort {
	
	ResponseEntity<Object> crateUser(RegisterUserRequest registerUserRequest);

}
