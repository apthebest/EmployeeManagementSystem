package com.abhishek.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class EmployeeBean {
	private int emp_id;

	@NotEmpty(message="name should not be empty")
	private String name;
	@NotNull(message="salary cant be empty")
	@Range(min=1000,message="salary must be greater then 1000")
	private double salary;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}

