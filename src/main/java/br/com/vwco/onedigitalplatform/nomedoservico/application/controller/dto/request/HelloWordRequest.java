package br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public class HelloWordRequest {
	
	@NotBlank
	private String description;

	@NotBlank
	private String createdBy;

	@NotBlank
	private String isActive;
	
	@NotBlank
	private String updatedBy;
	
	public HelloWordRequest() {
		super();
	}

	public HelloWordRequest(@NotBlank String description, @NotBlank String createdBy, @NotBlank String isActive,
			@NotBlank String updatedBy) {
		super();
		this.description = description;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.updatedBy = updatedBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
		return "HelloWordRequest [description=" + description + ", createdBy=" + createdBy + ", isActive=" + isActive
				+ ", updatedBy=" + updatedBy + "]";
	}
	
}
