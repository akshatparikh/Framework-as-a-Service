package com.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.ComplaintVO;
import com.demo.model.LoginVO;
import com.demo.service.ComplaintService;
import com.demo.service.RegistrationService;

@Controller
public class complaintController {
	
	@Autowired
	ComplaintService complaintService;
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/user/loadComplaint.html")
	public ModelAndView loadComplaint()
	{
		return new ModelAndView("/user/addComplaint","ComplaintVO",new ComplaintVO());
	}
	
	@RequestMapping(value="/insertComplaint.html")
	public ModelAndView insertComplaint(@ModelAttribute ComplaintVO complaintVO)
	{
		
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		Date d = new Date();
		DateFormat d1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		complaintVO.setComplaintDate(d1.format(d));
		complaintVO.setComplaintStatus("PENDING");
		complaintVO.setLoginVO(loginVO);
		complaintService.insert(complaintVO);
		
		return new ModelAndView("redirect:/user/loadviewComplaint.html");	
	}
	
	@RequestMapping(value="/user/loadviewComplaint.html")
	public ModelAndView loadviewComplaint(@ModelAttribute ComplaintVO complaintVO)
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		List complaintList=complaintService.search(loginVO);
		return new ModelAndView("/user/viewComplaint").addObject("complaintList", complaintList);
	}
	
	@RequestMapping(value="/deleteComplaint.html",method=RequestMethod.GET)
	public ModelAndView deletedata(@RequestParam String complaintId,@ModelAttribute ComplaintVO complaintVO)
	{
		complaintVO.setComplaintId(Integer.parseInt(complaintId));
		List complaintList = complaintService.edit(complaintVO);		
		ComplaintVO complaintVO2 = (ComplaintVO)complaintList.get(0);
		complaintVO2.setStatus(false);
		complaintService.update(complaintVO2);	
		return new ModelAndView("redirect:/user/loadviewComplaint.html");		
	}

	@RequestMapping(value="/editComplaint.html",method=RequestMethod.GET)
	public ModelAndView editdata(@RequestParam String complaintId,@ModelAttribute ComplaintVO complaintVO)
	{
		complaintVO.setComplaintId(Integer.parseInt(complaintId));
		List complaintList = complaintService.edit(complaintVO);
		return new ModelAndView("/user/editComplaint","search_data",(ComplaintVO)complaintList.get(0));		
	}
	
	@RequestMapping(value="/updateComplaint.html",method=RequestMethod.GET)
	public ModelAndView updatedata(@RequestParam String complaintId,@ModelAttribute ComplaintVO complaintVO)
	{
		complaintVO.setComplaintId(Integer.parseInt(complaintId));
		complaintService.update(complaintVO);
		return new ModelAndView("redirect:/user/loadviewComplaint.html");
	}

	
		/********************************ADMIN FUNCTIONALITIES******************************************************************/ 

	@RequestMapping(value="admin/fetchComplaint.html")
	public ModelAndView fetchComplaint(@ModelAttribute ComplaintVO complaintVO)
	{
		List complaintList=complaintService.search();
		return new ModelAndView("admin/viewComplaint").addObject("complaintList", complaintList);
	}
	
	@RequestMapping(value="replyComplaint.html",method=RequestMethod.GET)
	public ModelAndView replyComplaint(@RequestParam String complaintId, @ModelAttribute ComplaintVO complaintVO)
	{
		complaintVO.setComplaintId(Integer.parseInt(complaintId));
		List complaintList = complaintService.edit(complaintVO);
		return new ModelAndView("admin/replyComplaint","search_data",(ComplaintVO)complaintList.get(0));		
	}
	
	@RequestMapping(value="updateReply.html",method=RequestMethod.GET)
	public ModelAndView updateReply(@RequestParam String complaintId, @ModelAttribute ComplaintVO complaintVO)
	{
		complaintVO.setComplaintId(Integer.parseInt(complaintId));
		Date d = new Date();
		DateFormat d1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		complaintVO.setComplaintReplyDate(d1.format(d));
		complaintService.update(complaintVO);
		
		List complaintList = complaintService.edit(complaintVO);		
		ComplaintVO complaintVO2 = (ComplaintVO)complaintList.get(0);
		complaintVO2.setComplaintStatus("RESOLVED");
		complaintService.update(complaintVO2);	

		return new ModelAndView("redirect:admin/fetchComplaint.html");
	}
	
}
