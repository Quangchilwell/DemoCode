package com.trungtamjava.helloSpringboot.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {
	
	@GetMapping("/upload")
	public void uploadFile(@RequestParam(name = "file") MultipartFile file) throws IOException {
		// Connvert to byte array
		try {
			byte [] bytes = Files.readAllBytes(Paths.get("C:\\Users\\my laptop\\Desktop\\avatarEmp\\ava.jpg"));
			String encodeImage = Base64.getEncoder().encodeToString(file.getBytes());
			System.out.println(encodeImage);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
