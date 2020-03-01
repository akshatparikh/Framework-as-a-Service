package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ModuleDAO;
import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;

@Service
public class ModuleService {
	
		@Autowired(required = true)
		ModuleDAO moduleDAO;
		
		@Transactional
		public void insert(ModuleVO moduleVO) 
		{
			moduleDAO.insert(moduleVO);
		}

		@Transactional
		public List search() {
			List ls = moduleDAO.search();
			return ls;
		}

		@Transactional
		public List search(LoginVO loginVO) {
			List ls = moduleDAO.search(loginVO);
			return ls;
		}

		
		@Transactional
		public void delete(ModuleVO moduleVO) 
		{
			// TODO Auto-generated method stub
			moduleDAO.delete(moduleVO);
		}

		@Transactional
		public List edit(ModuleVO moduleVO)
		{
			List ls=moduleDAO.edit(moduleVO);
			return ls;
		}
			
		@Transactional
		public void update(ModuleVO moduleVO)
		{
			moduleDAO.update(moduleVO);
		}

		@Transactional
		public List search(ProjectVO projectVO) {
			List ls = moduleDAO.search(projectVO);
			return ls;		}
}
