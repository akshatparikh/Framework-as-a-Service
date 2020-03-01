package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;
import com.demo.model.RegistrationVO;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(RegistrationVO registrationVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(registrationVO);
	}
	
	@Override
	public void insert(LoginVO loginVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(loginVO);
	}

	@Override
	public List validateEmail(LoginVO loginVO) 
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from LoginVO where username='"+loginVO.getUsername()+"'");
		ls=q.list();
		return ls;
	}
	
	@Override
	public List searchByUserName(String userName) 
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from LoginVO where username='"+userName+"'");
		ls=q.list();
		return ls;
	}

	@Override
	public List search(RegistrationVO registrationVO) 
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from RegistrationVO where loginVO ='"+registrationVO.getLoginVO().getLoginId()+"'");
		ls=q.list();
		return ls;
	}

	@Override
	public List search() 
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from LoginVO where role='ROLE_USER' ");
		ls=q.list();
		return ls;
	}

	@Override
	public List edit(RegistrationVO registrationVO)
	{
		List ls=new ArrayList();
		try {

			Session session=this.sessionFactory.getCurrentSession();		
			Query q=session.createQuery("from RegistrationVO where userId='"+registrationVO.getUserId()+"'");	
			ls=q.list();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(RegistrationVO registrationVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(registrationVO);
	}
	
}
