package com.abhishek.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abhishek.bean.EmployeeBean;
import com.abhishek.web.client.EmployeeRestClientService;

@Controller
public class EmployeeHomeController {
	@Autowired 
	EmployeeRestClientService client;
	private Long updateId;
    public EmployeeHomeController() {
       
     updateId = -1L;
    }
@RequestMapping("/logout")
public String logoutUser() {
    return "index";
}

@GetMapping("/delete-employee")
public ModelAndView deleteEmployee(@RequestParam Long id) throws Exception {
    try {
		client.deleteEmployeeById(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    ModelAndView modelAndView = new ModelAndView("home");
    modelAndView.addObject("empList",client.getEmployees());
    modelAndView.addObject("message","Employee Deleted Succesfully");
   
    return modelAndView;
}
@RequestMapping("add-employee")
public ModelAndView addEmployee() {
	EmployeeBean bean = new EmployeeBean();
	ModelAndView mv = new ModelAndView();
	mv.setViewName("Addemployee");
	mv.addObject("employee",bean);
	return mv;
}

@PostMapping("register-employee")
public ModelAndView registerEmployee(@Valid @ModelAttribute("employee")EmployeeBean employee,BindingResult result) throws Exception {
	ModelAndView mv = new ModelAndView();
	//saving the employee using client
	if(result.hasErrors())
	{
		mv.addObject("errors", result.getFieldErrors());
		mv.setViewName("Addemployee");
		return mv;
	}
	client.saveEmployee(employee);
	mv.setViewName("home");
	mv.addObject("message","employee added Successfully");
	mv.addObject("empList",client.getEmployees());
	return mv;	
}
@RequestMapping("update-employee")
public ModelAndView modifyEmployee(@RequestParam Long id) throws Exception {
	EmployeeBean employee = new EmployeeBean();
	List<EmployeeBean>eList =client.getEmployees().stream().filter(item->item.getEmp_id() == id).collect(Collectors.toList());
	employee = eList.get(0);
	ModelAndView mv = new ModelAndView();
//	System.out.println(employee.getName()+" and"+employee.getSalary());
	mv.setViewName("updateEmployee");
	this.updateId = id;
	mv.addObject("employee",employee);
		
	return mv;
}

@RequestMapping("updateEmployee")
public ModelAndView updateEmployee(@Valid@ModelAttribute("employee")EmployeeBean emp,BindingResult result) throws Exception {
	ModelAndView mv = new ModelAndView();
	if(result.hasErrors()) {
		mv.addObject("errors", result.getFieldErrors());
		mv.setViewName("updateEmployee");
		return mv;
	}
	
	client.updateEmployee(emp,updateId);
	mv.setViewName("home");
	mv.addObject("message","employee updated Successfully");
	mv.addObject("empList",client.getEmployees());
	return mv;	
}

}
