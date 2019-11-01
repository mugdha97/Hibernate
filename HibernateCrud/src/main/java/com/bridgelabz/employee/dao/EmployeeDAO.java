package com.bridgelabz.employee.dao;

import java.util.List;

import com.bridgelabz.employee.model.Employee;

public interface EmployeeDAO {
	
			List<Employee>get();
			Employee get(int id);
			void save(Employee employee);
			void delete(int id);
}
