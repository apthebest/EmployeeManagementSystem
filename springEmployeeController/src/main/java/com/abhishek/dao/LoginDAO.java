package com.abhishek.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.bean.LoginBean;
import com.abhishek.entity.LoginEntity;

@Repository

public class LoginDAO {
	@Autowired
	EntityManagerFactory emf;
	
	@Transactional
public void  registerUser(LoginBean bean) {
	LoginEntity le = new LoginEntity();
		
		BeanUtils.copyProperties(bean, le);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(le);
		em.getTransaction().commit();
		
}
public boolean validateUser(LoginBean bean) {
	EntityManager em = emf.createEntityManager();

	LoginEntity result=em.find(LoginEntity.class, bean.getUname());
	if(result==null)
		return false;
	return result.getPassword().equals(bean.getPassword());
}
}
