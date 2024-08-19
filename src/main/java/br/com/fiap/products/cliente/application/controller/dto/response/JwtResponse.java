package br.com.fiap.products.cliente.application.controller.dto.response;

import java.util.List;
import java.util.UUID;

public class JwtResponse {

	private String accessToken;
	private String refreshToken;
	private Long id;
	private String firstName;
	private String surName;
	private String email;
	private List<String> roles;

	public JwtResponse() {
		super();
	}

	public JwtResponse(String accessToken, String refreshToken, Long id, String firstName, String surName, String email,
			List<String> roles) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
