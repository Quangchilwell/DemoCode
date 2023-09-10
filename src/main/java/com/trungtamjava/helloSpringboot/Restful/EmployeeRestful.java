package com.trungtamjava.helloSpringboot.Restful;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.helloSpringboot.Model.EmployeeDTO;
import com.trungtamjava.helloSpringboot.Service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeRestful {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("emp-list")
	public List<EmployeeDTO> getAll(EmployeeDTO employeeDTO) {
		List<EmployeeDTO> dtos = employeeService.getAllEmployees();
		return dtos;
	}

	@GetMapping("/info-emp/{id}")
	public EmployeeDTO infoEmp(EmployeeDTO employeeDTO, @PathVariable(name = "id") int id) {
		employeeDTO = employeeService.getEmployeeByID(id);
		return employeeDTO;
	}

	@PostMapping(path = "/add-emp")
	public void addEmp(@ModelAttribute EmployeeDTO employeeDTO) { 
		System.out.println(employeeDTO.getFile().getOriginalFilename());
//		MultipartFile file = employeeDTO.getFile();
//		try {
//			String nameImage = LocalTime.now().toString().replaceAll("[-+.^:,]", "") + "-" + file.getOriginalFilename();
//			File newFile = new File("C:/Users/my laptop/Desktop/TestUploadReact/"+ nameImage);
//			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
//			fileOutputStream.write(file.getBytes());
//			fileOutputStream.close();
//			
//			employeeDTO.setAvatar(nameImage);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		employeeService.addEmployee(employeeDTO);
//		return employeeDTO;
	}

	@PutMapping("update-emp/{id}")
	public void updateEmp(@RequestBody EmployeeDTO employeeDTO, @PathVariable(name = "id") int id) {
		employeeService.updateEmployee(employeeDTO);
	}

	@DeleteMapping("delete-emp/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		employeeService.deleteEmployee(id);
	}
}
