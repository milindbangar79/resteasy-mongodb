package com.resteasy.mongodb.utils;

import java.util.Map;

public class ValidateEnvironmentVariables {

	public static boolean isEnvironmentVariableValid(String envVariable)
			throws MissingEnvironmentVariableCheckedException {

		boolean isValid = false;

		try {
			Map<String, String> env = System.getenv();
			for (String envName : env.keySet()) {
				if (envName == envVariable) {
					return isValid = true;
				}
				
				if (null != System.getenv(envVariable)){
					return isValid = true;
				}

			}
		} catch (Exception err) {
			throw new MissingEnvironmentVariableCheckedException(
					"Environment Variable " + envVariable + " does not exist", err);

		}
		return isValid;
	}
}
