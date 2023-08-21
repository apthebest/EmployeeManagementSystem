package com.abhishek.service;

import com.abhishek.bean.LoginBean;

public interface EmployeeConsumerService {
public boolean validateUser(LoginBean bean);
public void registerUser(LoginBean bean);
}
