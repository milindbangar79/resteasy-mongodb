package com.resteasy.mongodb.utils;

public enum DbEnvironmentVariables {
	MONGODB_DB_HOST("MONGODB_DB_HOST"),MONGODB_DB_PORT("MONGODB_DB_PORT"),APP_NAME("APP_NAME");
	
	private String envVariable;
	
	private DbEnvironmentVariables(String envVariable) {
		this.envVariable = envVariable;
		
	}

	public String getEnvVariable() {
		return envVariable;
	}
	
	

}
