package br.com.fiap.products.cliente.domain.port.incoming;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.fiap.products.cliente.application.controller.dto.request.CreatePlanRequest;
import br.com.fiap.products.cliente.application.controller.dto.request.RegisterUserRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public interface ClientUseCase {

	ResponseEntity<Object> crateUser(RegisterUserRequest registerUserRequest);

	ResponseEntity<Object> getAll();

	ResponseEntity<Object> activateAccount(@Valid String token);

	ResponseEntity<Object> registerPlan(@Valid @RequestBody CreatePlanRequest createPlanRequest);

	ResponseEntity<Object> getById(@PathVariable Long id);

	ResponseEntity<Object> getByPospaid(@PathVariable Long userId);

	ResponseEntity<Object> getByPrepaid(@PathVariable Long userId);

	ResponseEntity<Object> getByInternet(@PathVariable Long userId);

	ResponseEntity<Object> getByValueAdd(@PathVariable Long userId);
	
	ResponseEntity<Object> getClients();

}
