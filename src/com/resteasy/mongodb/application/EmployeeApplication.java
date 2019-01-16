package com.resteasy.mongodb.application;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.resteasy.mongodb.service.EmployeeServiceImpl;
import com.resteasy.mongodb.service.HTTPServletSampleService;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/rest")
public class EmployeeApplication extends Application{

	private Set<Object> singletons = new HashSet<Object>();


	public EmployeeApplication() {
		
		singletons.add(HTTPServletSampleService.class);
		singletons.add(EmployeeServiceImpl.class);
		
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("RestEasy-MongoDB");
		beanConfig.setDescription("Test, Swagger and Swagger UI");
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/swagger-test/api");
        beanConfig.setResourcePackage("com.resteasy.mongodb.service");
        beanConfig.setScan(true);
		beanConfig.setPrettyPrint(true);
	}

	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}

}
