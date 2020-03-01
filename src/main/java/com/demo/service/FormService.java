package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FormDAO;
import com.demo.model.FormVO;
import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

@Service
public class FormService {

	@Autowired
	FormDAO formDAO;
	
	@Transactional
	public void insert(FormVO formVO) 
	{
		formDAO.insert(formVO);
	}

	@Transactional
	public List search(ModuleVO moduleVO) 
	{
		List moduleList = formDAO.search(moduleVO);
		return moduleList;
	}

	@Transactional
	public List search(LoginVO loginVO, ProjectVO projectVO) 
	{
		List ls=formDAO.search(loginVO,projectVO);
		return ls;

	}

	@Transactional
	public void insertDataset(FormVO formVO) {
		formDAO.insert(formVO);		
	}
	
}
