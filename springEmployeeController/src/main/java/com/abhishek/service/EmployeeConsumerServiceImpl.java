package com.abhishek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.bean.LoginBean;
import com.abhishek.dao.LoginDAO;
@Service
public class EmployeeConsumerServiceImpl implements EmployeeConsumerService {
@Autowired 
LoginDAO loginDAO;
	@Override
	public boolean validateUser(LoginBean bean) {
		// TODO Auto-generated method stub
		return loginDAO.validateUser(bean);
		
	}

	

	@Override
	public void registerUser(LoginBean bean) {
		// TODO Auto-generated method stub
		
		loginDAO.registerUser(bean);
	}

}
