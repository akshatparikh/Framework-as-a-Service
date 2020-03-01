package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class loginController extends FileBaseMethods{

	@Autowired
	LoginService loginService;
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="login.html")
	public ModelAndView registration()
	{
		return new ModelAndView("login");	
	}
	
	@RequestMapping(value="/enterEmail.html")
	public ModelAndView enterEmail()
	{
		return new ModelAndView("/user/enterEmail");	
	}
	
	@RequestMapping(value="/forgetPassword.html")
	public ModelAndView forgetPassword(@RequestParam("username") String un,LoginVO loginVO,HttpSession session)
	{
		
		System.out.println("USERNAME>>>"+un);
		session.setAttribute("username", un);
		loginVO.setUsername(un);

		List ls=this.loginService.searchstep1(loginVO);
		System.out.println("List size>>>>>>>>>"+ls.size());
		if(ls!=null && !ls.isEmpty())
		{
			int OTP=generateOTP(4);
			System.out.println("OTP>>>>>"+OTP);
			String subject="otp";
			String content="otp:"+OTP;
			sendMail(un,subject, content);
			session.setAttribute("generatedOTP",OTP);
			return new ModelAndView("/user/forgetpassword");	
		}
		else
		{
			return new ModelAndView("redirect:/");	
		}   
		
	}
	
	@RequestMapping(value="step2", method = RequestMethod.POST)
	public ModelAndView step2(@RequestParam("password") String pwd ,LoginVO loginVO,RegistrationVO registrationVO,HttpSession session)
	{
		String userName= (String)session.getAttribute("username");
		loginVO.setUsername(userName);
		loginVO.setPassword(pwd);
		
		this.loginService.updatePassword(loginVO);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value="/admin/viewUser.html")
	public ModelAndView viewUser()
	{
		List userList=registrationService.search();
		List projectList=projectService.search();
		
		return new ModelAndView("/admin/viewUser","userList", userList).addObject("projectList", projectList);	
	}

	
	@RequestMapping(value="admin/blockUser.html")
	public ModelAndView blockUser(@RequestParam String loginId,@ModelAttribute LoginVO loginVO)
	{
		loginVO.setLoginId(Integer.parseInt(loginId));
	
		List user = loginService.edit(loginVO);		
		
		LoginVO loginVO2 = (LoginVO)user.get(0);
		
		loginVO2.setEnabled("0");
		
		this.loginService.update(loginVO2);
		
		return new ModelAndView("redirect:/admin/viewUser.html");	
	}
	
	@RequestMapping(value="admin/unblockUser.html")
	public ModelAndView unblockUser(@RequestParam String loginId,@ModelAttribute LoginVO loginVO)
	{
		loginVO.setLoginId(Integer.parseInt(loginId));
	
		List user = loginService.edit(loginVO);		
		
		LoginVO loginVO2 = (LoginVO)user.get(0);
		
		loginVO2.setEnabled("1");
		
		this.loginService.update(loginVO2);
		
		return new ModelAndView("redirect:/admin/viewUser.html");	
	}
	
}
