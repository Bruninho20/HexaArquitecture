package br.com.vwco.onedigitalplatform.cliente.application.controller.dto.request;

public class CreatePlanRequest {

	private Long idUser;

	private Long idProduct;

	public CreatePlanRequest() {
		super();
	}

	public CreatePlanRequest(Long idUser, Long idProduct) {
		super();
		this.idUser = idUser;
		this.idProduct = idProduct;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

}
