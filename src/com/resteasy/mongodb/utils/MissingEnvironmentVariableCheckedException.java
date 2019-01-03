package com.resteasy.mongodb.utils;

public class MissingEnvironmentVariableCheckedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MissingEnvironmentVariableCheckedException(String errMessage, Throwable err) {
		super(errMessage,err);
	}

}
