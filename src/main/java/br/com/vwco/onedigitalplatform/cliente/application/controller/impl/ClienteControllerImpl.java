package br.com.vwco.onedigitalplatform.cliente.application.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vwco.onedigitalplatform.cliente.application.controller.ClienteController;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.CreatePlanRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;
import br.com.vwco.onedigitalplatform.cliente.domain.port.incoming.ClientUseCase;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cliente")
public class ClienteControllerImpl implements ClienteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteControllerImpl.class);

	@Autowired
	private ClientUseCase clientWordUseCase;

	@Override
	@PostMapping("/user")
	public ResponseEntity<Object> crateUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
		LOGGER.info("Chamou a implementação");
		return clientWordUseCase.crateUser(registerUserRequest);
	}

	@Override
	@GetMapping("/products")
	public ResponseEntity<List<Object>> getAll() {
		LOGGER.info("GET ALL PRODUCTS");
		return null;
	}

	@Override
	@GetMapping("/clients")
	public ResponseEntity<Object> getClients() {
		LOGGER.info("GET ALL CLIENTS");
		return clientWordUseCase.getAll();
	}

	@Override
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
		return null;
	}

	@Override
	@GetMapping("/activate/{token}")
	public ResponseEntity<Object> activateAccount(@Valid String token) {
		LOGGER.info("ACTIVATE TOKEN");
		return clientWordUseCase.activateAccount(token);
	}

	@Override
	@PostMapping("/product")
	public ResponseEntity<Object> registerPlan(@Valid @RequestBody CreatePlanRequest createPlanRequest) {
		LOGGER.info("REGISTER PLAN IMPL");
		return clientWordUseCase.registerPlan(createPlanRequest);
	}

	
	
}
