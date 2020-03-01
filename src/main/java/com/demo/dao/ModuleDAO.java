package com.demo.dao;

import java.util.List;

import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

public interface ModuleDAO {

	public void insert(ModuleVO moduleVO);

	public List search();
	
	public List search(LoginVO loginVO);

	public void delete(ModuleVO moduleVO);

	public List edit(ModuleVO moduleVO);

	public void update(ModuleVO moduleVO);

	public List search(ProjectVO projectVO);
	
}
