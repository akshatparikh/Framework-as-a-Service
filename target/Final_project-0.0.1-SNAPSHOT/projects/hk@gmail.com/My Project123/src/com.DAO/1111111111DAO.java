package com.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.VO.*;

@Repository
public class 1111111111DAO{ 

	@Autowired
	SessionFactory sessionFactory;

	public void insert(1111111111VO 1111111111VO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(1111111111VO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List search(){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from 1111111111VO");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ls;
	}

	public void delete(1111111111VO 1111111111VO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(1111111111VO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List edit(1111111111VO 1111111111VO){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from 1111111111VO where id = '"+ 1111111111VO.get1111111111Id() +"' ");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return ls;
	}

}