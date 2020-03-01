package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FeedbackDAO;
import com.demo.model.FeedbackVO;

@Service
public class FeedbackService {

		@Autowired
		FeedbackDAO feedbackDAO;
		
		@Transactional
		public void insert(FeedbackVO feedbackVO) 
		{
			feedbackDAO.insert(feedbackVO);
		}
	
		@Transactional
		public List search() 
		{
			List ls=feedbackDAO.search();
			return ls;
		}
		
		@Transactional
		public void delete(FeedbackVO feedbackVO) 
		{
			// TODO Auto-generated method stub
			feedbackDAO.delete(feedbackVO);
		}
	
		@Transactional
		public List edit(FeedbackVO feedbackVO)
		{
			List ls=feedbackDAO.edit(feedbackVO);
			return ls;
		}
		
		@Transactional
		public void update(FeedbackVO feedbackVO)
		{
			feedbackDAO.update(feedbackVO);
		}

		@Transactional
		public List countOfFeedback() {
			List ls=feedbackDAO.countOfFeedback();
			return ls;
		}
	
}
