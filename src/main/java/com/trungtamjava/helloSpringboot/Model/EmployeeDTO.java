package com.trungtamjava.helloSpringboot.Model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmployeeDTO {
	private int id;
	private String name;
	private int age;
	private String username;
	private String password;
	private String role;
	private String avatar;
	
	private MultipartFile file;
	private List<String> phones;
}
