package br.com.vwco.onedigitalplatform.nomedoservico.common.exception;

public class BusinessExceptions extends RuntimeException {
	
	private static final long serialVersionUID = -2794991803341165855L;

	public BusinessExceptions() {
		super();
	}

	public BusinessExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessExceptions(String message) {
		super(message);
	}

	public BusinessExceptions(Throwable cause) {
		super(cause);
	}

}
