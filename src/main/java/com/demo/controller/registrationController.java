package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.LoginVO;
import com.demo.model.RegistrationVO;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class registrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/addUser.html")
	public ModelAndView registration()
	{
		return new ModelAndView("user/signup","RegistrationVO",new RegistrationVO());	
	}
	
	@RequestMapping(value="validateEmail.html")
	public ModelAndView validateEmail(@RequestParam String email,@ModelAttribute LoginVO loginVO)
	{
		loginVO.setUsername(email);
		List emailList=registrationService.validateEmail(loginVO);
	
		return new ModelAndView("user/emailJSON").addObject("emailList",emailList);
	}
	
	@RequestMapping(value="/insertUser.html")
	public ModelAndView insertUser(@ModelAttribute RegistrationVO registrationVO,LoginVO loginVO,HttpSession session)
	{
		loginVO.setUsername(registrationVO.getLoginVO().getUsername());
		loginVO.setPassword(registrationVO.getLoginVO().getPassword());
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
		
		registrationService.insert(loginVO);
		
		registrationVO.setLoginVO(loginVO);
		registrationService.insert(registrationVO);

		String rootPath = session.getServletContext().getRealPath("/");
		
		Boolean projectFlag = FileBaseMethods.createUserDirectory(rootPath+"/projects" ,registrationVO.getLoginVO().getUsername());
		Boolean sourceCodeFlag = FileBaseMethods.createUserDirectory(rootPath+"/sourcecode" ,registrationVO.getLoginVO().getUsername());
		
		System.out.println("User created in project directory " + projectFlag);
		System.out.println("User created in sourcecode directory " + sourceCodeFlag);
		
		
		return new ModelAndView("/login","RegistrationVO",new RegistrationVO());	
	}	

	/******************************/
	
	@RequestMapping(value="/addAdmin.html")
	public ModelAndView registrationAdmin()
	{
		return new ModelAndView("admin/signup","RegistrationVO",new RegistrationVO());	
	}
	
	@RequestMapping(value="/insertAdmin.html")
	public ModelAndView insertAdmin(@ModelAttribute RegistrationVO registrationVO,LoginVO loginVO,HttpSession session)
	{
		loginVO.setUsername(registrationVO.getLoginVO().getUsername());
		loginVO.setPassword(registrationVO.getLoginVO().getPassword());
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_ADMIN");
		
		registrationService.insert(loginVO);
		
		registrationVO.setLoginVO(loginVO);
		registrationService.insert(registrationVO);

		return new ModelAndView("/login","RegistrationVO",new RegistrationVO());	
	}	

}
