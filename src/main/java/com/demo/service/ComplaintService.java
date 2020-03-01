package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ComplaintDAO;
import com.demo.model.ComplaintVO;
import com.demo.model.LoginVO;

@Service
public class ComplaintService {
	
		@Autowired
		ComplaintDAO complaintDAO;
		
		@Transactional
		public void insert(ComplaintVO complaintVO) 
		{
			complaintDAO.insert(complaintVO);
		}
	
		@Transactional
		public List search() 
		{
			List ls=complaintDAO.search();
			return ls;
		}
		
		@Transactional
		public List search(LoginVO loginVO) 
		{
			List ls=complaintDAO.search(loginVO);
			return ls;
		}
		
		@Transactional
		public void delete(ComplaintVO complaintVO) 
		{
			// TODO Auto-generated method stub
			complaintDAO.delete(complaintVO);
		}
	
		@Transactional
		public List edit(ComplaintVO complaintVO)
		{
			List ls=complaintDAO.edit(complaintVO);
			return ls;
		}
		
		@Transactional
		public void update(ComplaintVO complaintVO)
		{
			complaintDAO.update(complaintVO);
		}

		@Transactional
		public List countOfPendingComplaint(LoginVO loginVO2) {
			List ls = complaintDAO.countOfPendingComplaint(loginVO2);
			return ls;
		}

		@Transactional
		public List countOfComplaint(LoginVO loginVO2) {
			List ls = complaintDAO.countOfComplaint(loginVO2);
			return ls;
		}
		
		@Transactional
		public List countOfSolvedComplaint(LoginVO loginVO2) {
			List ls = complaintDAO.countOfSolvedComplaint(loginVO2);
			return ls;
		}

		@Transactional
		public List countOfComplaint() {
			List ls = complaintDAO.countOfComplaint();
			return ls;
		}

		
}
