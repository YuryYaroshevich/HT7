package com.epam.ht.db.dao;

import java.util.List;

import com.epam.ht.entity.employee.Employee;

public interface EmployeeDAO {
	List<Employee> getEmployees(int rowsNumber) throws Exception;
}
