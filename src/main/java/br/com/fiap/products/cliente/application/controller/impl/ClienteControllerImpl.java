package br.com.fiap.products.cliente.application.controller.impl;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import br.com.fiap.products.cliente.application.controller.ClienteController;
import br.com.fiap.products.cliente.application.controller.dto.request.CreatePlanRequest;
import br.com.fiap.products.cliente.application.controller.dto.request.RegisterUserRequest;
import br.com.fiap.products.cliente.domain.port.incoming.ClientUseCase;
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
	public ResponseEntity<Object>getAll() {
		LOGGER.info("GET ALL PRODUCTS");
		return clientWordUseCase.getAll();
	}

	@Override
	@GetMapping("/clients")
	public ResponseEntity<Object> getClients() {
		LOGGER.info("GET ALL CLIENTS");
		return clientWordUseCase.getAll();
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

	@Override
	@GetMapping("/user")
	public ResponseEntity<Object> getById(@RequestParam Long id) {
		return clientWordUseCase.getById(id);
	}

	@Override
	@GetMapping("/pospaid")
	public ResponseEntity<Object> getByPospaid(@RequestParam Long userId){
		return clientWordUseCase.getByPospaid(userId);
	}

	@Override
	@GetMapping("/prepaid")
	public ResponseEntity<Object> getByPrepaid(@RequestParam Long userId) {
		return clientWordUseCase.getByPrepaid(userId);
	}

	@Override
	@GetMapping("/internet")
	public ResponseEntity<Object> getByInternet(@RequestParam Long userId) {
		return clientWordUseCase.getByInternet(userId);
	}

	@Override
	@GetMapping("/value")
	public ResponseEntity<Object> getByValueAdd(@RequestParam Long userId) {
		return clientWordUseCase.getByValueAdd(userId);
	}

}
