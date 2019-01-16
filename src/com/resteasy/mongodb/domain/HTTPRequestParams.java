/**
 * 
 */
package com.resteasy.mongodb.domain;

import io.swagger.annotations.SwaggerDefinition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

/**
 * @author milind
 * @version 1.0
 *
 */
@Data
@Getter
@Setter
public class HTTPRequestParams {
	
	
	private String authroizationType;
	private String methodName;
	private String pathInfo;
	private String pathTranslated;
	private String queryString;
	private String principalName;
	private String requestURL;
	
	
	
}
