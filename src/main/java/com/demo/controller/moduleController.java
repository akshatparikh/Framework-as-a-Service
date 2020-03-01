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
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;
import com.demo.service.ModuleService;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class moduleController {
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	ProjectService projectService;

	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/user/loadModule.html")
	public ModelAndView loadModule(@ModelAttribute ProjectVO projectVO)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);

		List ls = projectService.search(loginVO);
		return new ModelAndView("/user/addModule","ModuleVO",new ModuleVO()).addObject("projectList",ls);	
	}
	
	@RequestMapping(value="/insertModule.html")
	public ModelAndView insertProject(@ModelAttribute ModuleVO moduleVO)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		moduleVO.setLoginVO(loginVO);
		moduleService.insert(moduleVO);
		return new ModelAndView("redirect:/user/loadviewModule.html");	
	}
	
	@RequestMapping(value="/user/loadviewModule.html")
	public ModelAndView loadviewModule()
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		List moduleList=moduleService.search(loginVO);
		return new ModelAndView("/user/viewModule").addObject("moduleList", moduleList);
	}

	@RequestMapping(value="/deleteModule.html",method=RequestMethod.GET)
	public ModelAndView deletedata(@RequestParam String moduleId,@ModelAttribute ModuleVO moduleVO)
	{
		moduleVO.setModuleId(Integer.parseInt(moduleId));
		List moduleList = moduleService.edit(moduleVO);		
		ModuleVO moduleVO2 = (ModuleVO)moduleList.get(0);
		moduleVO2.setStatus(false);
		moduleService.update(moduleVO2);
		return new ModelAndView("redirect:/user/loadviewModule.html");		
	}

	@RequestMapping(value="/editModule.html",method=RequestMethod.GET)
	public ModelAndView editdata(@RequestParam String moduleId,@ModelAttribute ModuleVO moduleVO)
	{
		moduleVO.setModuleId(Integer.parseInt(moduleId));
		List moduleList = moduleService.edit(moduleVO);
		List projectList = projectService.search();
		return new ModelAndView("/user/editModule","moduleList",moduleList.get(0)).addObject("projectList",projectList);		
	}
	
	@RequestMapping(value="/updateModule.html",method=RequestMethod.GET)
	public ModelAndView updatemodule(@RequestParam String moduleId,@ModelAttribute ModuleVO moduleVO)
	{
		moduleVO.setModuleId(Integer.parseInt(moduleId));
		moduleService.update(moduleVO);
		return new ModelAndView("redirect:/user/loadviewModule.html");
	}

						/***************ADMIN CONFIG***************/
	
	@RequestMapping(value="/admin/manageModule.html")
	public ModelAndView manageModule()
	{
		List moduleList=moduleService.search();
		return new ModelAndView("/admin/viewModule").addObject("moduleList", moduleList);
	}
}
