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
public class FormDescriptionDAO{ 

	@Autowired
	SessionFactory sessionFactory;

	public void insert(FormDescriptionVO formDescriptionVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.saveOrUpdate(formDescriptionVO);
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
			Query query = session.createQuery("from FormDescriptionVO");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return ls;
	}

	public void delete(FormDescriptionVO formDescriptionVO){

		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(formDescriptionVO);
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List edit(FormDescriptionVO formDescriptionVO){

		List ls = new ArrayList();
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			Query query = session.createQuery("from FormDescriptionVO where id = '"+ formDescriptionVO.getFormDescriptionId() +"' ");
			ls=query.list();
			transaction.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			return ls;
	}

}