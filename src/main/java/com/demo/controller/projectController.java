package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.LoginVO;
import com.demo.model.ProjectVO;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class projectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/user/loadProject.html")
	public ModelAndView loadProject()
	{
		return new ModelAndView("user/addProject","ProjectVO",new ProjectVO());	
	}
	
	@RequestMapping(value="/insertProject.html")
	public ModelAndView insertProject(@ModelAttribute ProjectVO projectVO)
	{		
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		projectVO.setLoginVO(loginVO);
		projectService.insert(projectVO);
		return new ModelAndView("redirect:/user/loadviewProject.html");	
	}
	
	@RequestMapping(value="/user/loadviewProject.html")
	public ModelAndView loadviewProject()
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		List projectList=projectService.search(loginVO);
		return new ModelAndView("/user/viewProject").addObject("projectList", projectList);
	}
	
	@RequestMapping(value="/user/loadCode.html")
	public ModelAndView loadCode()
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		List projectList=projectService.search(loginVO);
		return new ModelAndView("/user/generateCode").addObject("projectList", projectList);
	}
	
	@RequestMapping(value="/deleteProject.html",method=RequestMethod.GET)
	public ModelAndView deletedata(@RequestParam String projectId,@ModelAttribute ProjectVO projectVO)
	{
		projectVO.setProjectId(Integer.parseInt(projectId));		
		List projectList = projectService.edit(projectVO);		
		ProjectVO projectVO2 = (ProjectVO)projectList.get(0);
		projectVO2.setStatus(false);
		this.projectService.update(projectVO2);
		return new ModelAndView("redirect:/user/loadviewProject.html");		
	}

	@RequestMapping(value="/editProject.html",method=RequestMethod.GET)
	public ModelAndView editdata(@ModelAttribute ProjectVO projectVO,@RequestParam String projectId)
	{
		projectVO.setProjectId(Integer.parseInt(projectId));
		List projectList = projectService.edit(projectVO);
		return new ModelAndView("/user/editProject","search_data",(ProjectVO)projectList.get(0));		
	}
	
	@RequestMapping(value="/updateProject.html",method=RequestMethod.GET)
	public ModelAndView updatedata(@RequestParam String projectId,@ModelAttribute ProjectVO projectVO)
	{
		projectVO.setProjectId(Integer.parseInt(projectId));
		this.projectService.update(projectVO);
		return new ModelAndView("redirect:/user/loadviewProject.html");
	}
	
	@RequestMapping(value="/user/validateProjectName.html")
	public ModelAndView validateProject(@RequestParam String projectName,@ModelAttribute ProjectVO projectVO)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		projectVO.setProjectName(projectName);
		List projectList=projectService.validateProject(projectVO,loginVO);
	
		return new ModelAndView("/user/projectJSON").addObject("projectList",projectList);		
	}

				/*****************ADMIN CONFIG***********************************/
	
	@RequestMapping(value="/admin/loadProject.html")
	public ModelAndView manageProject()
	{
	List projectList = projectService.search();
	return new ModelAndView("/admin/viewProject").addObject("projectList", projectList);
	}
	
}
