package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void update(LoginVO loginVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(loginVO);
	}
	
	@Override
	public List edit(LoginVO loginVO)
	{
		List ls=new ArrayList();
		try {

			Session session=this.sessionFactory.getCurrentSession();		
			Query q=session.createQuery("from LoginVO where loginId='"+loginVO.getLoginId()+"'");	
			ls=q.list();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@Override
	public List searchstep1(LoginVO loginVO) 
	{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from LoginVO where username = '"+loginVO.getUsername()+"' ");
		List ls = q.list();
		return ls;
	}
	
	@Override
	public void updatePassword(LoginVO loginVO) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("UPDATE LoginVO set password='"+loginVO.getPassword() +"'where username='"+loginVO.getUsername() +"'");
		q.executeUpdate();
		
	}

	@Override
	public List countOfUser() {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(user_Id) from LoginVO");	
		ls=q.list();	
		return ls;
	}

	
}
