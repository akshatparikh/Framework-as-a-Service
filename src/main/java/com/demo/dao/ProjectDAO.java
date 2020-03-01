package com.demo.dao;

import java.util.List;

import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;

public interface ProjectDAO {
	
	public void insert(ProjectVO projectVO);
	
	public List search();

	public List search(LoginVO loginVO);
	
	void delete(ProjectVO projectVO);

	public List edit(ProjectVO projectVO);

	public void update(ProjectVO projectVO);
	
	public List validateProject(ProjectVO projectVO, LoginVO loginVO);

	public List countOfUser(LoginVO loginVO2);

	public List countOfProject();

}
