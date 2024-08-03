package br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterUserRequest {

	@Size(min = 3, max = 30, message = "Nome deve conter entre 3 e 30 caracteres")
	@NotBlank(message = "Nome deve conter entre 3 e 30 caracteres")
	@Pattern(regexp = "^[A-Za-zÀ-ú ]*$", message = "Nome deve conter apenas letras")
	private String firstName;

	@Size(min = 3, max = 30, message = "Sobrenome deve conter entre 3 e 30 caracteres")
	@NotBlank(message = "Sobrenome não deve ser nulo")
	@Pattern(regexp = "^[A-Za-zÀ-ú ]*$", message = "Sobrenome deve conter apenas letras")
	private String surName;

	@Email(message = "Deve ser um email válido.")
	@Size(min = 3, max = 150, message = "E-mail deve conter entre 3 e 150 caracteres")
	@NotBlank(message = "E-mail não deve ser nulo")
	private String email;

	@Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
	@NotBlank(message = "CPF não deve ser nulo")
	@CPF(message = "Insira um CPF válido")
	private String cpf;

	@Size(min = 11, max = 11, message = "Telefone deve conter 11 dígitos")
	@NotBlank(message = "Telefone não deve ser nulo")
	@Pattern(regexp = "^\\d+$", message = "Telefone deve conter apenas dígitos")
	private String telephone;

	@Size(min = 8, max = 30, message = "Senha deve conter entre 8 e 30 caracteres")
	@NotBlank(message = "Senha não deve ser nula")
	@Pattern(regexp = "^(?=.*[A-ZÀ-ÖØ-Ý])[\\s\\S]*$", message = "Senha deve conter ao menos uma letra maiúscula")
	@Pattern(regexp = "^(?=.*[a-zà-öø-ý])[\\s\\S]*$", message = "Senha deve conter ao menos uma letra minuscula")
	@Pattern(regexp = "^(?=.*[0-9])[\\s\\S]*$", message = "Senha deve conter ao menos um número")
	@Pattern(regexp = "^(?=.*[!@#$%^&*()-+=])[\\s\\S]*$", message = "Senha deve conter ao menus um caractere especial")
	private String password;

	public RegisterUserRequest() {
		super();
	}

	public RegisterUserRequest(
			@Size(min = 3, max = 30, message = "Nome deve conter entre 3 e 30 caracteres") @NotBlank(message = "Nome deve conter entre 3 e 30 caracteres") @Pattern(regexp = "^[A-Za-zÀ-ú ]*$", message = "Nome deve conter apenas letras") String firstName,
			@Size(min = 3, max = 30, message = "Sobrenome deve conter entre 3 e 30 caracteres") @NotBlank(message = "Sobrenome não deve ser nulo") @Pattern(regexp = "^[A-Za-zÀ-ú ]*$", message = "Sobrenome deve conter apenas letras") String surName,
			@Email(message = "Deve ser um email válido.") @Size(min = 3, max = 150, message = "E-mail deve conter entre 3 e 150 caracteres") @NotBlank(message = "E-mail não deve ser nulo") String email,
			@Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos") @NotBlank(message = "CPF não deve ser nulo") @CPF(message = "Insira um CPF válido") String cpf,
			@Size(min = 11, max = 11, message = "Telefone deve conter 11 dígitos") @NotBlank(message = "Telefone não deve ser nulo") @Pattern(regexp = "^\\d+$", message = "Telefone deve conter apenas dígitos") String telephone,
			@Size(min = 8, max = 30, message = "Senha deve conter entre 8 e 30 caracteres") @NotBlank(message = "Senha não deve ser nula") @Pattern(regexp = "^(?=.*[A-ZÀ-ÖØ-Ý])[\\s\\S]*$", message = "Senha deve conter ao menos uma letra maiúscula") @Pattern(regexp = "^(?=.*[a-zà-öø-ý])[\\s\\S]*$", message = "Senha deve conter ao menos uma letra minuscula") @Pattern(regexp = "^(?=.*[0-9])[\\s\\S]*$", message = "Senha deve conter ao menos um número") @Pattern(regexp = "^(?=.*[!@#$%^&*()-+=])[\\s\\S]*$", message = "Senha deve conter ao menus um caractere especial") String password) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.cpf = cpf;
		this.telephone = telephone;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
