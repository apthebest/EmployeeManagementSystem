package com.abhishek.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.abhishek.bean.EmployeeBean;
import com.abhishek.bean.LoginBean;
import com.abhishek.service.EmployeeConsumerServiceImpl;
import com.abhishek.web.client.EmployeeRestClientService;



@Controller
@SessionAttributes("username")
public class LoginController {
	@Autowired 
	EmployeeRestClientService client;
	@Autowired
	EmployeeConsumerServiceImpl empService;

private String username;
@RequestMapping("/validateUser")
public ModelAndView validateLogin(LoginBean bean) throws Exception {
	//if user enters correct credential, redirect him to the home page
	if(empService.validateUser(bean)) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("username",bean.getUname());
		this.username = bean.getUname();
	return modelAndView;
	}
	//else redirect it to loginFailure page
	else {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginFailure");
		String message = "enter valid credentials";
		modelAndView.addObject("message",message);
	return modelAndView;
	}
}

@RequestMapping("/registerUser")
public String register() {
	return "registerUser";
}

@RequestMapping("/createAccount")
public ModelAndView createAccount(LoginBean bean) throws Exception {

	empService.registerUser(bean);
	ModelAndView modelAndView = new ModelAndView();
	
    this.username = bean.getUname();
    modelAndView.addObject("username",bean.getUname());
	modelAndView.setViewName("home");
	modelAndView.addObject("registerSuccess","Account Created Successfully!");
	return modelAndView;
	
}

@ModelAttribute("empList")
List<EmployeeBean> getEmpList() throws Exception{
	return client.getEmployees();

}
@ModelAttribute("username")
public String getUserName() {
	
	return this.username;
}
}
