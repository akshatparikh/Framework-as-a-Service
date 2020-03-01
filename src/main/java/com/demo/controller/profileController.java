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
import com.demo.model.RegistrationVO;
import com.demo.service.LoginService;
import com.demo.service.RegistrationService;

@Controller
public class profileController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/user/loadProfile.html")
	public ModelAndView loadProject()
	{
		RegistrationVO registrationVO = new RegistrationVO();
		
		String userName = FileBaseMethods.getCurrentUser();
		List ls = this.registrationService.searchByUserName(userName);
		
		LoginVO loginVO  = (LoginVO)ls.get(0);
		
		registrationVO.setLoginVO(loginVO);
		
		List userList = this.registrationService.search(registrationVO);
		
		return new ModelAndView("user/userProfile","userList",userList);	
	}
	
	
	@RequestMapping(value="/editProfile.html",method=RequestMethod.GET)
	public ModelAndView editdata(@ModelAttribute RegistrationVO registrationVO,@RequestParam ("userId")int userId)
	{
		
		registrationVO.setUserId(userId);
		List profileList = registrationService.edit(registrationVO);
		
		System.out.println("ProfileList==============="+profileList.size());
		return new ModelAndView("user/editProfile","profileList",(RegistrationVO)profileList.get(0));		
	}
	
	@RequestMapping(value="/updateProfile.html",method=RequestMethod.POST)
	public ModelAndView updatedata(@ModelAttribute RegistrationVO registrationVO,@ModelAttribute LoginVO loginVO)
	{
		
		loginVO.setUsername(registrationVO.getLoginVO().getUsername());
		loginVO.setPassword(registrationVO.getLoginVO().getPassword());
		loginVO.setEnabled("1");
		loginVO.setRole("ROLE_USER");
		loginVO.setLoginId(registrationVO.getLoginVO().getLoginId());

		registrationVO.setLoginVO(loginVO);
		
		this.registrationService.update(registrationVO);
		return new ModelAndView("redirect:/user/loadProfile.html");
	}

	@RequestMapping(value="/user/deleteAccount.html",method=RequestMethod.GET)
	public ModelAndView deleteAccount(@RequestParam String loginId,@ModelAttribute LoginVO loginVO)
	{
		loginVO.setLoginId(Integer.parseInt(loginId));
		
		System.out.println(loginId);
		
		List user = loginService.edit(loginVO);		
		
		LoginVO loginVO2 = (LoginVO)user.get(0);
		
		loginVO2.setEnabled("0");
		
		this.loginService.update(loginVO2);
		
		return new ModelAndView("redirect:/login.html");
	}
}
