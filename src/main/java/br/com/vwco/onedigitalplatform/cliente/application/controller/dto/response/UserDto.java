package br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response;

import java.util.UUID;

public class UserDto {

	private String firstName;
	private String surName;
	private String email;
	private String cpf;
	private String telephone;
	private UUID id;

	public UserDto() {
		super();
	}

	public UserDto(String firstName, String surName, String email, String cpf, String telephone, UUID id) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.cpf = cpf;
		this.telephone = telephone;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
