package br.com.vwco.onedigitalplatform.cliente.domain.model;

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

	@Column(length = 20, nullable = false, name = "subscription_type")
	private String subscriptionType;

	public SubscriptionType(Integer id, String subscriptionType) {
		super();
		this.id = id;
		this.subscriptionType = subscriptionType;
	}

	public SubscriptionType() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

}