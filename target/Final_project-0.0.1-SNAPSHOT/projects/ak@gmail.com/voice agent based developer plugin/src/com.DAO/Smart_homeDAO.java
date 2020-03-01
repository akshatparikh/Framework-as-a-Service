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
public class Smart_homeDAO{ 

	@Autowired
	SessionFactory sessionFactory;

	public void insert(Smart_homeVO smart_homeVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(smart_homeVO);
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
			Query query = session.createQuery("from Smart_homeVO");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ls;
	}

	public void delete(Smart_homeVO smart_homeVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(smart_homeVO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List edit(Smart_homeVO smart_homeVO){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from Smart_homeVO where id = '"+ smart_homeVO.getSmart_homeId() +"' ");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return ls;
	}

}