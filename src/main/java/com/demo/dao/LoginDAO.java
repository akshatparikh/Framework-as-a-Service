package com.demo.dao;

import java.util.List;

import com.demo.model.LoginVO;

public interface LoginDAO {

	public void update(LoginVO loginVO);

	public List edit(LoginVO loginVO);
	
	public List searchstep1(LoginVO loginVO);

	public void updatePassword(LoginVO loginVO);

	public List countOfUser();

}
