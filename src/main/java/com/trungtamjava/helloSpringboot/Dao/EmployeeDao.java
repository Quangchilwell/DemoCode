package com.trungtamjava.helloSpringboot.Dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.helloSpringboot.Entity.Employee;

public interface EmployeeDao{
	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public Employee getEmployeeByID(int id);
	
	public Employee getEmployeeByUsername(String username);
	
}
