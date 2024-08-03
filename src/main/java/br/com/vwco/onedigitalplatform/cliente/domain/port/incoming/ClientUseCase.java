package br.com.vwco.onedigitalplatform.cliente.domain.port.incoming;

import org.springframework.http.ResponseEntity;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;

public interface ClientUseCase {

	ResponseEntity<Object> crateUser(RegisterUserRequest registerUserRequest);

}
