package com.resteasy.mongodb.service;

import java.util.List;

import javax.ws.rs.Path;

import com.resteasy.mongodb.domain.Employee;

@Path("/rest")
public interface EmployeeService {
	
	public List<Employee> getAllEmployees(); 
	

}
