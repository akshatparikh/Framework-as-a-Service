package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDAO;
import com.demo.model.LoginVO;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	@Transactional
	public void update(LoginVO loginVO) {
		
		loginDAO.update(loginVO);
		
	}

	@Transactional
	public List edit(LoginVO loginVO) {
			List ls=loginDAO.edit(loginVO);
			return ls;
	}
	
	@Transactional
	public List searchstep1(LoginVO loginVO) 
	{
		List ls = loginDAO.searchstep1(loginVO);
		return ls;
	}
	@Transactional
	public void updatePassword(LoginVO loginVO)
	{
		loginDAO.updatePassword(loginVO);
	}

	@Transactional
	public List countOfUser() {
		List ls = loginDAO.countOfUser();
		return ls;
	}

	
}
