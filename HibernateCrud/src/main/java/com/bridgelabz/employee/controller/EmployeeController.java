package com.bridgelabz.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employee.model.Employee;
import com.bridgelabz.employee.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}
	
		@PostMapping("/employee")
		public Employee save(@RequestBody Employee employeeObj) {
		 employeeService.save(employeeObj);
		 return employeeObj;
		
	}
		@GetMapping("/employee/{id}")
		public Employee get(@PathVariable int id) {
			Employee employeeObj= employeeService.get(id);
			if(employeeObj==null)
			{
				throw new RuntimeException("employee with id "+id+" is not found");
			}
			else 
				return employeeObj;
			
		}
		
		@DeleteMapping("/employee/{id}")
		public String delete(@PathVariable int id) {
			employeeService.delete(id);
			return "Employee has been deleted with id ="+id;
			
		}
		
		@PutMapping("/employee")
		public Employee update(@RequestBody Employee employeeObj) {
			employeeService.save(employeeObj);
			return employeeObj;
			
		}
		
		
		
		
}
