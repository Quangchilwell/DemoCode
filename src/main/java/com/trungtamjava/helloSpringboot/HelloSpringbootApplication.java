package com.trungtamjava.helloSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.trungtamjava")

//Cau hinh Hibernate
@EntityScan(basePackages = {"com.trungtamjava.helloSpringboot.Entity"})

public class HelloSpringbootApplication{
	
	public static void main(String[] args){
		SpringApplication.run(HelloSpringbootApplication.class, args);
	}
	
	

}
