package br.com.vwco.onedigitalplatform.cliente.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users_data", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "user_id")
	private Long id;

	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Column(name = "sur_name")
	private String surName;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	private String cpf;

	@NotBlank
	private String telephone;

	@JsonIgnore
	@Size(max = 120)
	private String password;

	@JsonIgnore
	@Column(name = "create_date")
	private LocalDateTime createDate;

	@JsonIgnore
	@Column(name = "last_uptated_date")
	private LocalDateTime lastUpdatedDate;

	@Column(name = "is_activated")
	private Boolean isActivated;

	@Column(name = "active_subs_type")
	private List<String> activeSubsType;

	public User() {
		super();
	}

	public User(Long id, @NotBlank String firstName, @NotBlank String surName,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank String cpf, @NotBlank String telephone,
			@Size(max = 120) String password, LocalDateTime createDate, LocalDateTime lastUpdatedDate,
			Boolean isActivated, List<String> activeSubsType) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surName = surName;
		this.email = email;
		this.cpf = cpf;
		this.telephone = telephone;
		this.password = password;
		this.createDate = createDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.isActivated = isActivated;
		this.activeSubsType = activeSubsType;
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public List<String> getActiveSubsType() {
		return activeSubsType;
	}

	public void setActiveSubsType(List<String> activeSubsType) {
		this.activeSubsType = activeSubsType;
	}

}
