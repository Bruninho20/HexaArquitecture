package br.com.vwco.onedigitalplatform.cliente.domain.port.outgoing;

import org.springframework.http.ResponseEntity;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;

public interface ClientPort {
	
	ResponseEntity<Object> createUser(RegisterUserRequest registerUserRequest);

}
