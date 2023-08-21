package com.learning.springboot.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.dao.EmployeeDAO;
import com.learning.springboot.employeebean.EmployeeBean;
import com.learning.springboot.entity.EmployeeEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
EmployeeDAO empDAO;

@Override
public void insertEmployee(EmployeeBean e) {
	// TODO Auto-generated method stub
	if(e!=null)
	{
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(e, entity);
		empDAO.save(entity);
		System.out.println("Employee Inserted Successfully");
		}
	else {
		System.out.println("Employee should be not null");
	}
}

@Override
public EmployeeBean findEmployeeById(Integer id) {
	// TODO Auto-generated method stub
	Optional<EmployeeEntity> o =  empDAO.findById(id);
	List<EmployeeEntity>empList=o.stream().collect(Collectors.toList());
	if(empList.size()!=0) {
		EmployeeEntity entity = empList.get(0);
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	return null;
}

@Override
public void deleteEmployee(int id) {
	// TODO Auto-generated method stub
	empDAO.deleteById(id);
	
}

@Override
public List<EmployeeBean> findEmployees() {
	List<EmployeeEntity>empList = new ArrayList<>();
	empList = empDAO.findAll();
	List<EmployeeBean> list = new ArrayList<>();
	for(EmployeeEntity e:empList) {
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(e,bean);
		list.add(bean);
	}
	return list;
	
}

@Override
public EmployeeBean updateEmployee(int id,EmployeeBean updatedEmployee) {
	// TODO Auto-generated method stub
	EmployeeEntity currentEntity = null;
	
	Optional<EmployeeEntity> o =  empDAO.findById(id);
	EmployeeBean updatedBean = new EmployeeBean();
		if(o.isPresent()) {
			System.out.println("updating...");
			currentEntity = o.get();
			currentEntity.setName(updatedEmployee.getName());
			currentEntity.setSalary(updatedEmployee.getSalary());
			empDAO.save(currentEntity);
			BeanUtils.copyProperties(currentEntity, updatedBean);
			}
		else {
			System.out.println("cant enter null values");
		}
	
	return updatedBean;
}



}
