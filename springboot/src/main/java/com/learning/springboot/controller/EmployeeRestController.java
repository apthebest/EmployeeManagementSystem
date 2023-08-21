package com.learning.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.employeebean.EmployeeBean;
import com.learning.springboot.entity.EmployeeEntity;
import com.learning.springboot.sevice.EmployeeServiceImpl;

@RestController

public class EmployeeRestController {
	@Autowired 
	EmployeeServiceImpl empService;
	
	@GetMapping("/employee/{id}")
ResponseEntity<EmployeeBean> findEmployeeById(@PathVariable int id) {
	EmployeeBean empBean =empService.findEmployeeById(id);
	if(empBean!=null) {
	return new ResponseEntity<>(empBean, HttpStatus.OK);
	}
	else return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
}
	@GetMapping("/employees")
	ResponseEntity<List<EmployeeBean>> findEmployeeById() {
		List<EmployeeBean> empList = empService.findEmployees();
		if(empList.size()!=0)return new ResponseEntity<>(empList,HttpStatus.OK);
		else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
}
	@PostMapping("/employee/save")
	ResponseEntity<String> saveEmployee(@RequestBody EmployeeBean e) {
		
		empService.insertEmployee(e);
		return new ResponseEntity<>("Employee saved successfully", HttpStatus.OK);

	}
	
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		empService.deleteEmployee(id);
		return new ResponseEntity<>("Employee deleted successfully!",HttpStatus.OK);
	}
	@PutMapping("/employee/update/{id}")
	ResponseEntity<EmployeeBean> updateEmployee(@PathVariable int id,@RequestBody EmployeeBean updatedEmployee ) {
		
		return new ResponseEntity<>(empService.updateEmployee(id,updatedEmployee),HttpStatus.OK);
	}
}
