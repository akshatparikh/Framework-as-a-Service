package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.LoginVO;
import com.demo.model.RegistrationVO;
import com.demo.service.ComplaintService;
import com.demo.service.FeedbackService;
import com.demo.service.LoginService;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class mainController {
	
	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	LoginService loginService;	

	@Autowired
	FeedbackService feedbackService;	
	
	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value={"/"})
	public ModelAndView loadpage(){
		return new ModelAndView("user/index2");	
	}
	
	@RequestMapping(value={"login"})
	public ModelAndView load(){
		return new ModelAndView("login");	
	}
	
	@RequestMapping(value="/admin/index")
	public ModelAndView loadAdmin(@ModelAttribute RegistrationVO registrationVO){
		List countOfComplaint = this.complaintService.countOfComplaint();
		
		List countOfProject = this.projectService.countOfProject();
		
		List countOfUser = this.loginService.countOfUser();
		
		List countOfFeedback = this.feedbackService.countOfFeedback();
		
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		registrationVO.setLoginVO(loginVO);
		List registerList = this.registrationService.search(registrationVO);
		
		registrationVO = (RegistrationVO)registerList.get(0);
		
		return new ModelAndView("admin/index","countOfUser",countOfUser)
				.addObject("countOfComplaint",countOfComplaint)
				.addObject("countOfProject",countOfProject)
				.addObject("countOfFeedback",countOfFeedback)
				.addObject("registrationVO",registrationVO);	
	}
	
	@RequestMapping(value="/user/index")
	public ModelAndView loadUser(@ModelAttribute RegistrationVO registrationVO){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		
		LoginVO loginVO = new LoginVO();
		loginVO.setUsername(userName);
		
		String userName1 = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName1);

		LoginVO loginVO3= (LoginVO)userList.get(0);
		//loginVO3.getLoginId();
		System.out.println(loginVO3.getLoginId());

		registrationVO.setLoginVO(loginVO3);
		List registerList = this.registrationService.search(registrationVO);
		
		registrationVO = (RegistrationVO)registerList.get(0);
		
		System.out.println(registrationVO.getLoginVO().getLoginId());
		System.out.println(registrationVO.getFirstName());

		List loginList  = this.loginService.searchstep1(loginVO);
		LoginVO loginVO2 = (LoginVO)loginList.get(0);
		
		List countOfPendingComplaint = this.complaintService.countOfPendingComplaint(loginVO2);
		
		List countOfComplaint = this.complaintService.countOfComplaint(loginVO2);
		
		List countOfSolvedComplaint = this.complaintService.countOfSolvedComplaint(loginVO2);
		
		List countOfUser = this.projectService.countOfUser(loginVO2);
		
		return new ModelAndView("user/index","countOfPendingComplaint",countOfPendingComplaint).addObject("countOfComplaint",countOfComplaint)
								.addObject("countOfSolvedComplaint",countOfSolvedComplaint)
								.addObject("registrationVO", registrationVO)
								.addObject("countOfUser",countOfUser);
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	}
	        return "login";
	        }


}
