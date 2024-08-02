package br.com.vwco.onedigitalplatform.cliente.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "product_product_type",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "product_type_id")
    )
    private Set<ProductType> productType = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "product_descriptions",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "description_id")
    )
    private List<Descriptions> descriptions;

    private List<String> tags;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

	public Product() {
		super();
	}

	public Product(UUID id, String status, String productName, Set<ProductType> productType,
			List<Descriptions> descriptions, List<String> tags, User user) {
		super();
		this.id = id;
		this.status = status;
		this.productName = productName;
		this.productType = productType;
		this.descriptions = descriptions;
		this.tags = tags;
		this.user = user;
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

	public Set<ProductType> getProductType() {
		return productType;
	}

	public void setProductType(Set<ProductType> productType) {
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

}
