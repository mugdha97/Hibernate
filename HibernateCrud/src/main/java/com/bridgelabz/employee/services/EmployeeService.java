package com.bridgelabz.employee.services;

import java.util.List;

import com.bridgelabz.employee.model.Employee;

public interface EmployeeService {
	
	List<Employee>get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
}
