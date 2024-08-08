package br.com.vwco.onedigitalplatform.cliente.domain.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "price")
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "price_id", nullable = false)
	private UUID id;

	private String description;

	private String type;

	@Column(name="recurring_period")
	private String recurringPeriod;

	private Double amout;

	public Price() {
		super();
	}
	
	

	public Price(UUID id, String description, String type, String recurringPeriod, Double amout) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
		this.recurringPeriod = recurringPeriod;
		this.amout = amout;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecurringPeriod() {
		return recurringPeriod;
	}

	public void setRecurringPeriod(String recurringPeriod) {
		this.recurringPeriod = recurringPeriod;
	}

	public Double getAmout() {
		return amout;
	}

	public void setAmout(Double amout) {
		this.amout = amout;
	}

	

}
