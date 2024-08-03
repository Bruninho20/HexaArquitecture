package br.com.vwco.onedigitalplatform.cliente.application.controller.dto.response;

public class MessageResponse {

	private String message;

	public MessageResponse() {
		super();
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
