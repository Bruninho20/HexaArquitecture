package br.com.vwco.onedigitalplatform.cliente.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.HelloWordUpdateRequest;
import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response.HelloWordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cliente")
public interface ClienteController {

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity Hello Word", tags = { "Products" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/products")
	public ResponseEntity<List<HelloWordResponse>> getAll();

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity Hello Word", tags = { "Clients" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/clients")
	public ResponseEntity<List<HelloWordResponse>> getClients();

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity for id Hello Word", tags = {
			"Products by id" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/user/{user_id}/products")
	public ResponseEntity<HelloWordResponse> getById(
			@Parameter(description = "Identifies Hello Word - 1 positions", example = "1") @PathVariable(name = "id") Integer id);

}
