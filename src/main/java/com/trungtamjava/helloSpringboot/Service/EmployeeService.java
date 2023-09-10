package com.trungtamjava.helloSpringboot.Service;

import java.util.List;

import com.trungtamjava.helloSpringboot.Model.EmployeeDTO;


public interface EmployeeService {
	public List<EmployeeDTO> getAllEmployees();
	
	public void addEmployee(EmployeeDTO employeeDTO);
	
	public void updateEmployee(EmployeeDTO employeeDTO);
	
	public void deleteEmployee(int id);
	
	public EmployeeDTO getEmployeeByID(int id);
	
	public EmployeeDTO getEmployeeByUsername(String username);
}
