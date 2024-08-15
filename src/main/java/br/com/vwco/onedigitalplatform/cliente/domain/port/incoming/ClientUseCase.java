package br.com.vwco.onedigitalplatform.cliente.domain.port.incoming;

import org.springframework.http.ResponseEntity;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.CreatePlanRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public interface ClientUseCase {

	ResponseEntity<Object> crateUser(RegisterUserRequest registerUserRequest);
	
	ResponseEntity<Object> getAll();
	
	ResponseEntity<Object> activateAccount(@Valid String token);
	
	ResponseEntity<Object> registerPlan(@Valid @RequestBody CreatePlanRequest createPlanRequest);

}
