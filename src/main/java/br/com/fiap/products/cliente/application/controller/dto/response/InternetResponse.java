package br.com.fiap.products.cliente.application.controller.dto.response;

import java.util.List;

public class InternetResponse {

	private String id;
	private String status;
	private String productName;
	private List<String> identifiers;
	private String productType;
	private String startDate;
	private List<Description> descriptions;

	public InternetResponse() {
		super();
	}

	public InternetResponse(String id, String status, String productName, List<String> identifiers, String productType,
			String startDate, List<Description> descriptions) {
		super();
		this.id = id;
		this.status = status;
		this.productName = productName;
		this.identifiers = identifiers;
		this.productType = productType;
		this.startDate = startDate;
		this.descriptions = descriptions;
	}

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

	public List<Description> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}

	public static class Description {
		private String text;
		

		public Description() {
			super();
		}

		public Description(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	}

}
