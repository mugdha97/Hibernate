package com.bridgelabz.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.employee.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Employee> get() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<Employee> query =currentSession.createQuery("from Employee",Employee.class);
        List<Employee> employees = query.getResultList(); // execute query and get result list      
        return employees;  // return the results	
	}

	@Override
	public Employee get(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employeeObj=currentSession.get(Employee.class, id);
		return employeeObj;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Employee employeeObj=currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
		
	}

}
