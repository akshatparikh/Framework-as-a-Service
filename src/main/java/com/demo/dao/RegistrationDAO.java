package com.demo.dao;

import java.util.List;

import com.demo.model.LoginVO;
import com.demo.model.RegistrationVO;

public interface RegistrationDAO {

	public void insert(RegistrationVO registrationVO);

	public void insert(LoginVO loginVO);

	public List validateEmail(LoginVO loginVO);
	
	public List searchByUserName(String userName);

	public List search(RegistrationVO registrationVO);

	public List search();

	public List edit(RegistrationVO registrationVO);

	public void update(RegistrationVO registrationVO);
}
