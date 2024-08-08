package br.com.vwco.onedigitalplatform.cliente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "category_enum", length = 20, nullable = false)
	private String categoryEnum;

	public Category() {
	}

	public Category(String categoryEnum) {
		this.categoryEnum = categoryEnum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryEnum() {
		return categoryEnum;
	}

	public void setCategoryEnum(String categoryEnum) {
		this.categoryEnum = categoryEnum;
	}
}
