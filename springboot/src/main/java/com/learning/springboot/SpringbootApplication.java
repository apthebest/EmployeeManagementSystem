package com.learning.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.springboot.entity.EmployeeEntity;
import com.learning.springboot.sevice.EmployeeServiceImpl;

@SpringBootApplication
public class SpringbootApplication {
@Autowired

EmployeeServiceImpl empService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		
		
	}
	

}
