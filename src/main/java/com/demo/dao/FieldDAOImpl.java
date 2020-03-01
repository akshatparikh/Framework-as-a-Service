package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.FieldVO;

@Repository
public class FieldDAOImpl implements FieldDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void insert(FieldVO fieldVO) 
	{
		try {
			Session session=this.sessionFactory.getCurrentSession();
			session.save(fieldVO);	
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
	}



}
