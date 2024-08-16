package br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response;

public class ClientResponse {

	private Long productId;
	private String productName;
	private String price;
	private String description;
	private String category;
	private Integer subscriptionTypeId;
	private Long userId;

	public ClientResponse() {
		super();
	}

	public ClientResponse(Long productId, String productName, String price, String description, String category,
			Integer subscriptionTypeId, Long userId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.category = category;
		this.subscriptionTypeId = subscriptionTypeId;
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getSubscriptionTypeId() {
		return subscriptionTypeId;
	}

	public void setSubscriptionTypeId(Integer subscriptionTypeId) {
		this.subscriptionTypeId = subscriptionTypeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
