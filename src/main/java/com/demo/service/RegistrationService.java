package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.RegistrationDAO;
import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;
import com.demo.model.RegistrationVO;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;
	
	@Transactional
	public void insert(RegistrationVO registrationVO) 
	{
		this.registrationDAO.insert(registrationVO);
	}
	
	@Transactional
	public void insert(LoginVO loginVO) 
	{
		this.registrationDAO.insert(loginVO);
	}

	@Transactional
	public List validateEmail(LoginVO loginVO) 
	{
		List ls = this.registrationDAO.validateEmail(loginVO);
		return ls;
	}
	
	@Transactional
	public List searchByUserName(String userName) 
	{
		List ls = this.registrationDAO.searchByUserName(userName);
		return ls;
	}

	@Transactional
	public List search(RegistrationVO registrationVO) 
	{
		List ls = this.registrationDAO.search(registrationVO);
		return ls;
	}

	@Transactional
	public List search() 
	{
		List ls = this.registrationDAO.search();
		return ls;
	}

	@Transactional
	public List edit(RegistrationVO registrationVO)
	{
		List ls=registrationDAO.edit(registrationVO);
		return ls;
	}
	
	@Transactional
	public void update(RegistrationVO registrationVO)
	{
		registrationDAO.update(registrationVO);
	}

}
