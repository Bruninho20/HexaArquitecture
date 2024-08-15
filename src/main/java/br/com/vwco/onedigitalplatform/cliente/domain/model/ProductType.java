package br.com.vwco.onedigitalplatform.cliente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class ProductType {


	private Integer id;


	private String productType;

	public ProductType() {
		super();
	}

	public ProductType(Integer id, String productType) {
		super();
		this.id = id;
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
