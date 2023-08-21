package com.learning.springboot.sevice;

import java.util.List;

import com.learning.springboot.employeebean.EmployeeBean;
import com.learning.springboot.entity.EmployeeEntity;

public interface EmployeeService {
	public void insertEmployee(EmployeeBean e);
	public EmployeeBean findEmployeeById(Integer id);
	public void deleteEmployee(int id);
	public List<EmployeeBean> findEmployees();
	public EmployeeBean updateEmployee(int id,EmployeeBean e);
}
