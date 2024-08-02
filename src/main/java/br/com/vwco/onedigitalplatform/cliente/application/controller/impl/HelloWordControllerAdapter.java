package br.com.vwco.onedigitalplatform.cliente.application.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vwco.onedigitalplatform.cliente.application.controller.ClienteController;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.cliente.domain.port.incoming.HelloWordUseCase;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cliente")
@Validated
public class HelloWordControllerAdapter implements ClienteController {
	
	private static final String PARAMETERIZATION_DELETE_SUCCESS = "Parametrizações sensibilizadas com sucesso.";
	
	@Autowired
	private HelloWordUseCase useCase;
	
	@Override
	public ResponseEntity<List<HelloWordResponse>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.useCase.getAll());
	}
	@Override
	public ResponseEntity<HelloWordResponse> getById(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.useCase.getById(id));
	}
	@Override
	public ResponseEntity<List<HelloWordResponse>> getClients() {
		// TODO Auto-generated method stub
		return null;
	}

}
