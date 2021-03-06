package com.resteasy.mongodb.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.resteasy.mongodb.db.DBConnector;
import com.resteasy.mongodb.domain.Address;
import com.resteasy.mongodb.domain.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Path("v1/emp")
@Produces("application/json")
@Api(value = "Employee Data", description = "Operation about Employee")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Inject
	private DBConnector conn;

	@Override
	@GET
	@Path("/employees/{id}")
	@ApiOperation(value = "Get All employees from the database", notes = "Get All the Employees Currently In The Database", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "All employees returned"),
			@ApiResponse(code = 404, message = "Employees not available"),@ApiResponse( code = 403 , message = "Operation Not allowed") })
	public List<Employee> getAllEmployees() {
		
		Employee emp = new Employee();
		emp.setEmpID("134898");
		emp.setSalary(120000.23);

		Address add = new Address();
		add.setNumber("9");
		add.setPostcode("EX12 8DU");
		add.setStreet("Craw Drive");
		add.setTown("Preston");
		emp.setAddress(add);

		conn.getDs().save(emp);
	
		return conn.getDs().createQuery(Employee.class).asList();
	}

}
