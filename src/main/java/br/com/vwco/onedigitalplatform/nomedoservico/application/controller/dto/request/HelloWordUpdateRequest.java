package br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HelloWordUpdateRequest {
	
	@NotNull
	private Integer id;
	
	@NotBlank
	private String description;

	@NotBlank
	private String isActive;
	
	@NotBlank
	private String updatedBy;
	
	public HelloWordUpdateRequest() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "HelloWordUpdateRequest [id=" + id + ", description=" + description + ", isActive=" + isActive
				+ ", updatedBy=" + updatedBy + "]";
	}
	
}
