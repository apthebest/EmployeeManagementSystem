package com.abhishek.web.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.MediaType;
import com.abhishek.bean.EmployeeBean;

@Service
public class EmployeeRestClientService {

	 private final RestTemplate restTemplate;
	
	 HttpHeaders headers ;
	 HttpEntity<String>requestEntity;
	    @Autowired
	    public EmployeeRestClientService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	        headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);

	       
	    }
private String template_url = "http://localhost:8089/";

//client method to get all the employees
public List<EmployeeBean> getEmployees() throws Exception {
    try {
        ResponseEntity<List<EmployeeBean>> response = restTemplate.exchange(template_url + "employees", HttpMethod.GET, null, new ParameterizedTypeReference<List<EmployeeBean>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
        	List<EmployeeBean>empList = response.getBody();
            return empList;
        } else {
        	System.out.println("No employees found!!");
       
            // Handle non-successful status code, if needed
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

//client method to delete a employee by id
public void deleteEmployeeById(Long id) throws Exception{
	try {
		  ResponseEntity<String> response = restTemplate.exchange(
	                template_url+"employee"+"/delete/"+id,
	                org.springframework.http.HttpMethod.DELETE,
	                null,
	                String.class
	        );
		   if (response.getStatusCode().is2xxSuccessful()) {
	            System.out.println("Resource deleted successfully");
	        } else if (response.getStatusCode().is4xxClientError()) {
	            System.out.println("Resource not found");
	        } else {
	            System.out.println("An error occurred");
	        }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

//client method to save a employee
public void saveEmployee(EmployeeBean emp) throws Exception {
	try {
		  ResponseEntity<String> response = restTemplate.exchange(
	                template_url+"employee/save",
	                org.springframework.http.HttpMethod.POST,
	                new HttpEntity<>(emp, headers),
	                String.class
	        );
		   if (response.getStatusCode().is2xxSuccessful()) {
	            System.out.println("Resource added successfully");
	        } else if (response.getStatusCode().is4xxClientError()) {
	            System.out.println("Resource not found");
	        } else {
	            System.out.println("An error occurred");
	        }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

//client method to update an employee
public EmployeeBean updateEmployee(EmployeeBean emp,Long id) throws Exception {
	try {
		  ResponseEntity<EmployeeBean> response = restTemplate.exchange(
	                template_url+"employee/update/"+id,
	                org.springframework.http.HttpMethod.PUT,
	                new HttpEntity<>(emp, headers),
	                EmployeeBean.class
	        );
		   if (response.getStatusCode().is2xxSuccessful()) {
			   System.out.println("resource updated successfully");
			   
	           return response.getBody() ;
	           } else if (response.getStatusCode().is4xxClientError()) {
	            System.out.println("Resource can't be updated");
	        } else {
	            System.out.println("An error occurred");
	        }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return null;
}

}
