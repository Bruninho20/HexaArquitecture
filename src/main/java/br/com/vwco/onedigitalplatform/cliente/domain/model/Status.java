package br.com.vwco.onedigitalplatform.cliente.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

	@Id
	@GeneratedValue
	@Column(name = "status_id", updatable = false, nullable = false)
	private Integer id;

	private String status;

	public Status() {
		super();
	}

	public Status(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
