package com.semeureka.mvc.misc;

public class HttpException extends RuntimeException {
	private static final long serialVersionUID = -4893003226613907642L;
	private final int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public HttpException(int statusCode) {
		this.statusCode = statusCode;
	}

	public HttpException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public HttpException(int statusCode, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
	}
}
