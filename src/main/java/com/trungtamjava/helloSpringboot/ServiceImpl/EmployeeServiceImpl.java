package com.trungtamjava.helloSpringboot.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.helloSpringboot.Dao.EmployeeDao;
import com.trungtamjava.helloSpringboot.Entity.Employee;
import com.trungtamjava.helloSpringboot.Entity.Phone;
import com.trungtamjava.helloSpringboot.Model.EmployeeDTO;
import com.trungtamjava.helloSpringboot.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	private void getInfo(Employee e, EmployeeDTO employeeDTO) {
		employeeDTO.setId(e.getId());
		employeeDTO.setName(e.getName());
		employeeDTO.setAge(e.getAge());
		employeeDTO.setUsername(e.getUsername());
		employeeDTO.setPassword(e.getPassword());
		employeeDTO.setRole(e.getRole());

		// Lay danh sach so dien thoai
		List<String> phoneList = new ArrayList<String>();
		for (Phone phone : e.getPhones()) {
			phoneList.add(phone.getPhone());
		}

		employeeDTO.setPhones(phoneList);
	}

	private void setInfo(Employee employee, EmployeeDTO employeeDTO)
	{
		employee.setName(employeeDTO.getName());
		employee.setAge(employeeDTO.getAge());
		employee.setUsername(employeeDTO.getUsername());
		employee.setPassword(employeeDTO.getPassword());
		employee.setRole(employeeDTO.getRole());
		employee.setAvatar(employeeDTO.getAvatar());
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {

		List<Employee> employees = employeeDao.getAllEmployees();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();

		for (Employee e : employees) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			getInfo(e, employeeDTO);
			employeeDTOs.add(employeeDTO);
		}

		return employeeDTOs;
	}

	@Override
	public void addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		setInfo(employee, employeeDTO);
		employeeDao.addEmployee(employee);

	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeDao.getEmployeeByID(employeeDTO.getId());
		if (employee != null) {
			setInfo(employee, employeeDTO);
			employeeDao.updateEmployee(employee);
		}

	}

	@Override
	public void deleteEmployee(int id) {
		Employee employee = employeeDao.getEmployeeByID(id);
		if (employee != null) {
			employeeDao.deleteEmployee(employee);
		}

	}

	@Override
	public EmployeeDTO getEmployeeByID(int id) {
		Employee e = employeeDao.getEmployeeByID(id);
		if (e != null) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			getInfo(e, employeeDTO);
			return employeeDTO;
		}
		return null;
	}

	@Override
	public EmployeeDTO getEmployeeByUsername(String username) {
		Employee e = employeeDao.getEmployeeByUsername(username);
		if (e != null) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			getInfo(e, employeeDTO);
			return employeeDTO;
		}
		return null;
	}

}
