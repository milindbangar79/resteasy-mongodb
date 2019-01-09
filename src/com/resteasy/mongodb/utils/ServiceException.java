package com.resteasy.mongodb.utils;

public class MissingEnvironmentVariableCheckedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MissingEnvironmentVariableCheckedException() {
		super();
	}

	public MissingEnvironmentVariableCheckedException(String errMessage, Throwable cause) {
		super(errMessage, cause);
	}

	public MissingEnvironmentVariableCheckedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingEnvironmentVariableCheckedException(String message) {
		super(message);
	}

	public MissingEnvironmentVariableCheckedException(Throwable cause) {
		super(cause);
	}

}
