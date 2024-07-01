package br.com.vwco.onedigitalplatform.nomedoservico.domain.model;

import java.util.Date;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Classe HelloWord Entity
 */
@Entity
@Table(name = "hello_word")
public class HelloWord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id; 
	
	@Column(name = "description", length = 40, nullable = true)
	private String description;
	
	@Column(name = "create", nullable = false)
	private Date create;
	
	@Column(name = "update", nullable = false)
	private Date update;
	
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@Column(name = "updatedBy", nullable = false)
	private String updatedBy;

	@Size(max = 1)
	@Column(name = "isActive", length = 1, nullable = false)
	@Pattern(regexp = "[S|N]")
	private String isActive;

	public HelloWord() {
		super();
	}

	public HelloWord(Integer id, String description, Date create, Date update, String createdBy, String updatedBy,
			@Size(max = 1) @Pattern(regexp = "[S|N]") String isActive) {
		super();
		this.id = id;
		this.description = description;
		this.create = create;
		this.update = update;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
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
		return "HelloWord [id=" + id + ", description=" + description + ", create=" + create + ", update=" + update
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", isActive=" + isActive + "]";
	}

}
