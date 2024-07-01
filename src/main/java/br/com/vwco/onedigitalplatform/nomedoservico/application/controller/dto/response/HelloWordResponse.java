package br.com.vwco.onedigitalplatform.nomedoservico.application.controller.dto.response;

import java.util.Date;

public class HelloWordResponse {
	
	private Integer id;
	
	private String description;
	
	private Date create;

	private String createdBy;

	private String isActive;
	
	private Date update;
	
	private String updatedBy;
	
	public HelloWordResponse() {
		super();
	}

	public HelloWordResponse(Integer id, String description, Date create, String createdBy, String isActive,
			Date update, String updatedBy) {
		super();
		this.id = id;
		this.description = description;
		this.create = create;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.update = update;
		this.updatedBy = updatedBy;
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

	public Date getCreate() {
		return create;
	}

	public void setCreate(Date create) {
		this.create = create;
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
	
	
	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "HelloWordResponse [id=" + id + ", description=" + description + ", create=" + create + ", createdBy="
				+ createdBy + ", isActive=" + isActive + ", update=" + update + ", updatedBy=" + updatedBy + "]";
	}
}
