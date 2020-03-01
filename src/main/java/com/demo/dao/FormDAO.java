package com.demo.dao;

import java.util.List;

import com.demo.model.FormVO;
import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

public interface FormDAO {

	public void insert(FormVO formVO);

	public List search(ModuleVO moduleVO);

	public List search(LoginVO loginVO, ProjectVO projectVO);

	void insertDataset(FormVO formVO);

}
