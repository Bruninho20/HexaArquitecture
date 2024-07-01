package br.com.vwco.onedigitalplatform.nomedoservico.application.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.HelloWordController;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response.HelloWordResponse;
import br.com.vwco.onedigitalplatform.nomedoservico.domain.port.incoming.HelloWordUseCase;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/onedigital")
@Validated
public class HelloWordControllerAdapter implements HelloWordController {
	
	private static final String PARAMETERIZATION_DELETE_SUCCESS = "Parametrizações sensibilizadas com sucesso.";
	
	@Autowired
	private HelloWordUseCase useCase;
	
	@Override
	public ResponseEntity<List<HelloWordResponse>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.useCase.getAll());
	}

	@Override
	public ResponseEntity<HelloWordResponse> save(@Valid @RequestBody HelloWordRequest helloWordRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.useCase.save(helloWordRequest));
	}

	@Override
	public ResponseEntity<String> deleteById(Integer id) {
		this.useCase.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(PARAMETERIZATION_DELETE_SUCCESS);
	}
	
	@Override
	public ResponseEntity<HelloWordResponse> update(@Valid @RequestBody HelloWordUpdateRequest helloWordUpdateRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.useCase.update(helloWordUpdateRequest));
	}

	@Override
	public ResponseEntity<HelloWordResponse> getById(Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.useCase.getById(id));
	}

}
