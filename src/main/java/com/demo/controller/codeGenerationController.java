package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.CreateZip;
import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.FormVO;
import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;
import com.demo.service.FormService;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@RestController
public class codeGenerationController {
	
	@Autowired
	FormService formService;
	
	@Autowired
	RegistrationService registrationService;
	
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="formList.html")
	public ModelAndView loadformList(@ModelAttribute ProjectVO projectVO,@RequestParam String projectId,HttpSession session)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);
		
		LoginVO loginVO= (LoginVO)userList.get(0);
		projectVO.setProjectId(Integer.parseInt(projectId)); 
		
		List projectList = projectService.edit(projectVO);
		
		ProjectVO projectVO2 = (ProjectVO)projectList.get(0);
		
		List<FormVO> formList = formService.search(loginVO,projectVO);

		for(FormVO formVO : formList){
			System.out.println(formVO.getFormName());
		}
		
		String email = userName;
		
		String path = session.getServletContext().getRealPath("/");

		CreateZip createZip = new CreateZip();
		createZip.createZip(email, projectVO2.getProjectName(),path);
		
		
		//FileBaseMethods.createXML(path+"/projects",email,projectVO2.getProjectName(),formList);
		
		
		return new ModelAndView("redirect:/user/loadCode.html").addObject("flag","download");
	}

}
