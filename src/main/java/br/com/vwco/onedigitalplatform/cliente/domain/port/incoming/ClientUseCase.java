package br.com.vwco.onedigitalplatform.cliente.domain.port.incoming;

import org.springframework.http.ResponseEntity;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;
import jakarta.validation.Valid;

public interface ClientUseCase {

	ResponseEntity<Object> createUser(RegisterUserRequest registerUserRequest);
	
	ResponseEntity<Object> getAll();
	
	ResponseEntity<Object> activateAccount(@Valid String token);

}
