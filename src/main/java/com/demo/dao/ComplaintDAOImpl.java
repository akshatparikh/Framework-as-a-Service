package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.ComplaintVO;
import com.demo.model.LoginVO;

@Repository
public class ComplaintDAOImpl implements ComplaintDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(ComplaintVO complaintVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(complaintVO);
	}
	
	@Override
	public List search()
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ComplaintVO where status = "+true+" ");
		ls=q.list();
		return ls;
	}
	
	@Override
	public List search(LoginVO loginVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ComplaintVO where status = true AND loginVO_user_id ='"+loginVO.getLoginId()+"' ");
		ls=q.list();
		return ls;
	}
	
	@Override
	public void delete(ComplaintVO complaintVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(complaintVO);
	}
	
	@Override
	public List edit(ComplaintVO complaintVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		Query q=session.createQuery("from ComplaintVO where complaintId='"+complaintVO.getComplaintId()+"'");	
		ls=q.list();	
		return ls;
	}
	
	@Override
	public void update(ComplaintVO complaintVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(complaintVO);
	}
	
	@Override
	public List countOfPendingComplaint(LoginVO loginVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(complaint_Id) from ComplaintVO where loginVO='"+loginVO.getLoginId()+"' and complaintStatus = 'PENDING' and  status = "+true+" ");	
		ls=q.list();	
		return ls;
	}
	
	@Override
	public List countOfComplaint(LoginVO loginVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(complaint_Id) from ComplaintVO where loginVO='"+loginVO.getLoginId()+"'  and  status = "+true+" ");	
		ls=q.list();	
		return ls;
	}
	
	@Override
	public List countOfSolvedComplaint(LoginVO loginVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(complaint_Id) from ComplaintVO where loginVO='"+loginVO.getLoginId()+"' and complaintStatus = 'RESOLVED'  and  status = "+true+" ");	
		ls=q.list();	
		return ls;
	}

	@Override
	public List countOfComplaint() {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		
		Query q=session.createQuery("select COUNT(complaint_Id) from ComplaintVO");	
		ls=q.list();	
		return ls;
	}
	
}
