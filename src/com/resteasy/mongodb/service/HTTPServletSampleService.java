package com.resteasy.mongodb.service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.resteasy.mongodb.domain.HTTPRequestParams;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Path("v1/httpparams")
@Produces("application/json")
@Api(value = "HTTP Data", description = "Operation about HTTPServlet object")
public class HTTPServletSampleService {
	
	@GET
	@Path("/params")
	@ApiOperation(value = "Get All the request pramaters from HTTPServletRequest object", notes = "Get All HttpParams from Client", response = HTTPRequestParams.class)
	@ApiResponse(code = 200 , message = "HTTPRequest Parameters")
	public Response getHTTPParams(@Context HttpServletRequest request) {
		
		HTTPRequestParams params = new HTTPRequestParams();
		
		params.setAuthroizationType(request.getAuthType());
		params.setMethodName(request.getMethod());
		params.setPathInfo(request.getPathInfo());
		params.setPathTranslated(request.getPathTranslated());
		params.setRequestURL(request.getRequestURI());
		
		return Response.status(200).entity(params).build();
	}

}
