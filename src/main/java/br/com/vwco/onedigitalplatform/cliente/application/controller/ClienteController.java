package br.com.vwco.onedigitalplatform.cliente.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request.RegisterUserRequest;
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
public interface ClienteController {

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity", tags = { "Products" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/products")
	public ResponseEntity<List<Object>> getAll();

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity", tags = { "Clients" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/clients")
	public ResponseEntity<List<Object>> getClients();

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity for id", tags = { "Products by id" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/user/{user_id}")
	public ResponseEntity<Object> getById(
			@Parameter(description = "Identifies Hello Word - 1 positions", example = "1") @PathVariable(name = "id") Integer id);

	@Operation(summary = "Cliente - Vivo.", description = "Returns a Entity User", tags = { "Client" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping(path = "/user")
	public ResponseEntity<Object> crateUser(@Valid @RequestBody RegisterUserRequest registerUserRequest);

}
