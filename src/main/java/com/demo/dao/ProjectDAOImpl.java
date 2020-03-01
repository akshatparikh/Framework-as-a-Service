package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(ProjectVO projectVO)
	{
		try {

			Session session=this.sessionFactory.getCurrentSession();
			session.save(projectVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List search()
	{
		List ls=new ArrayList();

		try{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectVO where status = true");
			ls=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public List search(LoginVO loginVO)
	{
		List ls=new ArrayList();

		try{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ProjectVO where status = true AND loginVO_user_id ='"+loginVO.getLoginId()+"' ");
			ls=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	@Override
	public void delete(ProjectVO projectVO)
	{
		try {
			Session session=this.sessionFactory.getCurrentSession();
			session.delete(projectVO);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List edit(ProjectVO projectVO)
	{
		List ls=new ArrayList();
		try {

			Session session=this.sessionFactory.getCurrentSession();		
			Query q=session.createQuery("from ProjectVO where id='"+projectVO.getProjectId()+"'");	
			ls=q.list();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void update(ProjectVO projectVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(projectVO);
	}

	@Override
	public List validateProject(ProjectVO projectVO, LoginVO loginVO) 
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ProjectVO where projectName='"+projectVO.getProjectName()+"' and status="+true+" and loginVO_user_id ='"+loginVO.getLoginId()+"'  ");
		ls=q.list();
		return ls;
	}
	
	@Override
	public List countOfUser(LoginVO loginVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(project_Id) from ProjectVO where loginVO='"+loginVO.getLoginId()+"' and status = "+true+" ");	
		ls=q.list();	
		return ls;
	}

	@Override
	public List countOfProject() {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(project_Id) from ProjectVO where status = "+true+"");	
		ls=q.list();	
		return ls;
	}

}
