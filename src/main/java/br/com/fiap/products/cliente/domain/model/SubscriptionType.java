package br.com.fiap.products.cliente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscription_type")
public class SubscriptionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscription_type_id", updatable = false, nullable = false)
	private Integer id;

	@Column(length = 20, nullable = false, name = "description")
	private String description;

	public SubscriptionType() {
		super();
	}

	public SubscriptionType(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
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

}