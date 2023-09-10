package com.trungtamjava.helloSpringboot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trungtamjava.helloSpringboot.Model.EmployeeDTO;
import com.trungtamjava.helloSpringboot.Service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/home")
	public String home(HttpServletRequest request)
	{
		return "home";
	}
	
	@GetMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam(name = "e", required = false) String error)
	{
		if(error != null) {
			request.setAttribute("error", error);
		}
		return "login";
	}
	
	
	@GetMapping("/employees")
	public String employee(HttpServletRequest request)
	{
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployees();
		request.setAttribute("employees", employeeDTOs);
//		request.setAttribute("userDetails", userDetails.getUsername());
		return "employees";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request, Model model)
	{
		model.addAttribute("employee", new EmployeeDTO());	
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request,
			@ModelAttribute(name = "employee") EmployeeDTO employeeDTO)
	{
		employeeService.addEmployee(employeeDTO);
		return "redirect:admin/employees";
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(HttpServletRequest request,
			@PathVariable(name = "id") int id,
			Model model)
	{
		EmployeeDTO employeeDTO = employeeService.getEmployeeByID(id);
		model.addAttribute("employee", employeeDTO);
		return "employee/updateEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(HttpServletRequest request,
			@ModelAttribute(name = "employee") EmployeeDTO employeeDTO)
	{
		employeeService.updateEmployee(employeeDTO);
		return "redirect:admin/employees";
	}
}
