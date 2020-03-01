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
import com.demo.model.FeedbackVO;
import com.demo.model.LoginVO;
import com.demo.service.FeedbackService;
import com.demo.service.RegistrationService;

@Controller
public class feedbackController {
	
	@Autowired
	FeedbackService feedbackService;

	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/user/loadFeedback.html")
	public ModelAndView loadFeedback()
	{
		return new ModelAndView("/user/addFeedback","FeedbackVO",new FeedbackVO());	
	}
	
	@RequestMapping(value="/insertFeedback.html")
	public ModelAndView insertFeedback(@RequestParam String feedbackRating, @ModelAttribute FeedbackVO feedbackVO)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		feedbackVO.setFeedbackRating(feedbackRating);
		feedbackVO.setLoginVO(loginVO);
		feedbackService.insert(feedbackVO);
		return new ModelAndView("redirect:/user/loadviewFeedback.html");	
	}
	
	@RequestMapping(value="/user/loadviewFeedback.html")
	public ModelAndView loadviewComplaint()
	{
		List feedbackList=feedbackService.search();
		return new ModelAndView("/user/viewFeedback").addObject("feedbackList", feedbackList);
	}
	
	@RequestMapping(value="/deleteFeedback.html",method=RequestMethod.GET)
	public ModelAndView deletedata(@RequestParam String feedbackId,@ModelAttribute FeedbackVO feedbackVO)
	{
		feedbackVO.setFeedbackId(Integer.parseInt(feedbackId));
		List feedbackList = feedbackService.edit(feedbackVO);		
		FeedbackVO feedbackVO2 = (FeedbackVO)feedbackList.get(0);
		feedbackVO2.setStatus(false);
		feedbackService.update(feedbackVO2);
		return new ModelAndView("redirect:/user/loadviewFeedback.html");
	}

	/*********************************************ADMIN FUNCTIONALITIES***************************************************************/

	@RequestMapping(value="admin/fetchFeedback.html")
	public ModelAndView fetchFeedback()
	{
		List feedbackList=feedbackService.search();
		return new ModelAndView("admin/viewFeedback").addObject("feedbackList", feedbackList);
	}
	
}
