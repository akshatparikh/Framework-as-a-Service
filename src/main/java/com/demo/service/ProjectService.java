package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProjectDAO;
import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;


@Service
public class ProjectService {

	@Autowired
	ProjectDAO projectDAO;
	
	@Transactional
	public void insert(ProjectVO projectVO) 
	{
		projectDAO.insert(projectVO);
	}

	@Transactional
	public List search() 
	{
		List ls=projectDAO.search();
		return ls;
	}

	@Transactional
	public List search(LoginVO loginVO) 
	{
		List ls=projectDAO.search(loginVO);
		return ls;
	}
	
	@Transactional
	public void delete(ProjectVO projectVO) 
	{
		// TODO Auto-generated method stub
		projectDAO.delete(projectVO);
	}

	@Transactional
	public List edit(ProjectVO projectVO)
	{
		List ls=projectDAO.edit(projectVO);
		return ls;
	}
	
	@Transactional
	public void update(ProjectVO projectVO)
	{
		projectDAO.update(projectVO);
	}

	@Transactional
	public List validateProject(ProjectVO projectVO, LoginVO loginVO)
	{
		List ls = projectDAO.validateProject(projectVO, loginVO);
		return ls;

	}

	@Transactional
	public List countOfUser(LoginVO loginVO2) {
		List ls = projectDAO.countOfUser(loginVO2);
		return ls;
	}

	@Transactional
	public List countOfProject() {
		List ls = projectDAO.countOfProject();
		return ls;
	}

}
