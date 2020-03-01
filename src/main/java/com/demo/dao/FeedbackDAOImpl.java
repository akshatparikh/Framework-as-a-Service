package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.model.FeedbackVO;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(FeedbackVO feedbackVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.save(feedbackVO);
	}
	
	@Override
	public List search()
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from FeedbackVO where status = true");
		ls=q.list();
		return ls;
	}
	
	@Override
	public void delete(FeedbackVO feedbackVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(feedbackVO);
	}

	@Override
	public List edit(FeedbackVO feedbackVO)
	{
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		Query q=session.createQuery("from FeedbackVO where id='"+feedbackVO.getFeedbackId()+"'");	
		ls=q.list();	
		return ls;
	}

	@Override
	public void update(FeedbackVO feedbackVO)
	{
		Session session=this.sessionFactory.getCurrentSession();
		session.update(feedbackVO);
	}

	@Override
	public List countOfFeedback() {
		List ls=new ArrayList();
		Session session=this.sessionFactory.getCurrentSession();		
		Query q=session.createQuery("select COUNT(feedback_Id) from FeedbackVO");	
		ls=q.list();	
		return ls;
	}
	
}
