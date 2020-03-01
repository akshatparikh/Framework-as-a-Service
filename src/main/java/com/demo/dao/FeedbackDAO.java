package com.demo.dao;

import java.util.List;

import com.demo.model.FeedbackVO;

public interface FeedbackDAO {
	
	public void insert(FeedbackVO feedbackVO);
	
	public List search();

	void delete(FeedbackVO feedbackVO);
	
	public List edit(FeedbackVO feedbackVO);

	public void update(FeedbackVO feedbackVO);

	public List countOfFeedback();

}
