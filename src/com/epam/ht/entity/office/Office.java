package com.epam.ht.entity.office;

import java.io.Serializable;
import java.util.Set;

import com.epam.ht.entity.address.Address;
import com.epam.ht.entity.company.Company;
import com.epam.ht.entity.employee.Employee;

public class Office implements Serializable {
	private static final long serialVersionUID = 1130756185750654144L;

	private long officeId;
	private Company company;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	private Set<Employee> employees;
	
	private int numberOfEmployees;
	
	public Office() {
	}
	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
