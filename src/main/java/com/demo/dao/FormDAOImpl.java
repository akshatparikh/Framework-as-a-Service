package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.FormVO;
import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

@Repository
public class FormDAOImpl implements FormDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(FormVO formVO)
	{
		try {
			Session session=this.sessionFactory.getCurrentSession();
			session.save(formVO);	
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
	}

	@Override
	public List search(ModuleVO moduleVO)
	{
		List ls=new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from ModuleVO where projectVO.projectId = '"+moduleVO.getProjectVO().getProjectId()+"' and loginVO_userId =   " + moduleVO.getLoginVO().getLoginId());
			ls=q.list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ls;	
	}

	@Override
	public List search(LoginVO loginVO,ProjectVO projectVO)
	{
		List ls=new ArrayList();
		try
		{
			Session session=this.sessionFactory.getCurrentSession();
			Query q=session.createQuery("from FormVO where loginVO_user_id ='"+loginVO.getLoginId()+"' and projectVO_project_Id = '"+projectVO.getProjectId()+"'");
			ls=q.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void insertDataset(FormVO formVO)
	{
		try {
			Session session=this.sessionFactory.getCurrentSession();
			session.save(formVO);	
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
	}
}

