package br.com.fiap.products.cliente.application.controller.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;

public class SignInRequest {

	public SignInRequest() {
	}

	private String email;

	private String password;

	@Schema(description = "Token do dispositivo", defaultValue = "ddee5ca9-0b67-4511",required = false)
	private String deviceToken;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

}
