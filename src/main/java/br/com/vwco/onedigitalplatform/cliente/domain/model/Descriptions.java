package br.com.vwco.onedigitalplatform.cliente.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "descriptions")
public class Descriptions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "description_id")
	private Integer id;

	private String text;

	private String url;

	@Column(length = 20)
	private String category;

	public Descriptions() {
		super();
	}

	public Descriptions(Integer id, String text, String url, String category) {
		super();
		this.id = id;
		this.text = text;
		this.url = url;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
