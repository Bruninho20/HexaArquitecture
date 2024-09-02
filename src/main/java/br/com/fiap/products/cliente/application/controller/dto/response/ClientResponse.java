package br.com.fiap.products.cliente.application.controller.dto.response;

import java.util.List;

public class ClientResponse {

	private String id;
	private String status;
	private String productName;
	private List<String> identifiers;
	private String productType;
	private String startDate;
	private String subscriptionType;
	private List<Description> descriptions;
	private List<ClientResponse> subProducts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<String> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<String> identifiers) {
		this.identifiers = identifiers;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public List<ClientResponse> getSubProducts() {
		return subProducts;
	}

	public void setSubProducts(List<ClientResponse> subProducts) {
		this.subProducts = subProducts;
	}

	@Override
	public String toString() {
		return "ClientResponse [id=" + id + ", status=" + status + ", productName=" + productName + ", identifiers="
				+ identifiers + ", productType=" + productType + ", startDate=" + startDate + ", subscriptionType="
				+ subscriptionType + ", descriptions=" + descriptions + ", subProducts=" + subProducts + "]";
	}

	public static class Description {
		private String text;

		// Getters e Setters
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

}
