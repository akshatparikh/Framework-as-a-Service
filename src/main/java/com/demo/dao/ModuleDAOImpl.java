package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

@Repository
public class ModuleDAOImpl implements ModuleDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(ModuleVO moduleVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(moduleVO);
	}
	
	@Override
	public List search()
	{
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ModuleVO where status = true");
		List ls=q.list();
		return ls;	
	}	

	@Override
	public List search(LoginVO loginVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ModuleVO where status = true AND loginVO_user_id ='"+loginVO.getLoginId()+"' ");
		List ls=q.list();
		return ls;	
	}	

	@Override
	public List search(ProjectVO projectVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ModuleVO where status = true AND projectVO_project_Id ='"+projectVO.getProjectId()+"' ");
		List ls=q.list();
		return ls;	
	}	
	
	@Override
	public void delete(ModuleVO moduleVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(moduleVO);
	}

	@Override
	public List edit(ModuleVO moduleVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		Query q=session.createQuery("from ModuleVO where id='"+moduleVO.getModuleId()+"'");	
		ls=q.list();	
		return ls;
	}

	@Override
	public void update(ModuleVO moduleVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(moduleVO);
	}

}
