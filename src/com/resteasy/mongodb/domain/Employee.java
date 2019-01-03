package com.resteasy.mongodb.domain;

import java.io.Serializable;
import java.util.List;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Property;

public class Employee extends BaseEntity implements Serializable{
	
private static final long serialVersionUID = 1L;

	
	private String empName;
	private String empID;
	@Property("wage")
	private Double salary;
	@Embedded
	private Address address;
	private List<Account> accounts;

	public Employee() {
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	

}
