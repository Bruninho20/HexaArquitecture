package br.com.vwco.onedigitalplatform.cliente.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Classe Product Entity
 */
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "product_id", nullable = false)
	private UUID id;

	private String status;

	@Column(name = "product_name")
	private String productName;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id")
	private ProductType productType;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private List<Descriptions> descriptions;

	@ElementCollection
	@CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "tag")
	private List<String> tags;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id", referencedColumnName = "price_id")
	private Price price;

	public Product(UUID id, String status, String productName, ProductType productType, List<Descriptions> descriptions,
			List<String> tags, User user, Price price) {
		super();
		this.id = id;
		this.status = status;
		this.productName = productName;
		this.productType = productType;
		this.descriptions = descriptions;
		this.tags = tags;
		this.user = user;
		this.price = price;
	}

	public Product() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<Descriptions> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Descriptions> descriptions) {
		this.descriptions = descriptions;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
