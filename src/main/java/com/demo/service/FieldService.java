package com.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.FieldDAO;
import com.demo.model.FieldVO;

@Service
public class FieldService {
	
	@Autowired
	FieldDAO fieldDAO;

	@Transactional
	public void insert(FieldVO fieldVO) 
	{
		
		fieldDAO.insert(fieldVO);
	}
	
}
