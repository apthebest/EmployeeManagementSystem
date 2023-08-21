package com.learning.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.springboot.entity.EmployeeEntity;
@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity,Integer> {

}
