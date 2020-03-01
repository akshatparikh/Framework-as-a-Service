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
public class JkkjjkjkjDAO{ 

	@Autowired
	SessionFactory sessionFactory;

	public void insert(JkkjjkjkjVO jkkjjkjkjVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(jkkjjkjkjVO);
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
			Query query = session.createQuery("from JkkjjkjkjVO");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ls;
	}

	public void delete(JkkjjkjkjVO jkkjjkjkjVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(jkkjjkjkjVO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List edit(JkkjjkjkjVO jkkjjkjkjVO){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from JkkjjkjkjVO where id = '"+ jkkjjkjkjVO.getJkkjjkjkjId() +"' ");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return ls;
	}

}