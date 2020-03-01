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
public class AaaDAO{ 

	@Autowired
	SessionFactory sessionFactory;

	public void insert(AaaVO aaaVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(aaaVO);
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
			Query query = session.createQuery("from AaaVO");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ls;
	}

	public void delete(AaaVO aaaVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(aaaVO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List edit(AaaVO aaaVO){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from AaaVO where id = '"+ aaaVO.getAaaId() +"' ");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return ls;
	}

}