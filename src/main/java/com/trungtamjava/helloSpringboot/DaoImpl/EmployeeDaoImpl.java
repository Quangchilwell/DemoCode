package com.trungtamjava.helloSpringboot.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.helloSpringboot.Dao.EmployeeDao;
import com.trungtamjava.helloSpringboot.Entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired // Giong nhu Autowire
	private EntityManager entityManager;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		String jql = "SELECT e FROM Employee e";
		
		return entityManager.createQuery(jql, Employee.class).getResultList();
	}

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		entityManager.remove(employee);
		
	}

	@Override
	public Employee getEmployeeByID(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		String jql = "SELECT e FROM Employee e WHERE e.username = ?1";
	
		return entityManager.createQuery(jql, Employee.class).setParameter(1, username).getSingleResult();
	}



}
