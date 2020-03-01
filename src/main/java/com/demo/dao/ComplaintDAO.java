package com.demo.dao;

import java.util.List;

import com.demo.model.ComplaintVO;
import com.demo.model.LoginVO;	

public interface ComplaintDAO {
	
	public void insert(ComplaintVO complaintVO);
	
	public List search();
	
	public List search(LoginVO loginVO);

	void delete(ComplaintVO complaintVO);

	public List edit(ComplaintVO complaintVO);

	public void update(ComplaintVO complaintVO);

	public List countOfPendingComplaint(LoginVO loginVO2);
	
	public List countOfComplaint(LoginVO loginVO2);
	
	public List countOfSolvedComplaint(LoginVO loginVO2);

	public List countOfComplaint();

}
