package com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.DAO.*;
import com.VO.*;

@Controller
public class aaaController{

	@Autowired
	AaaDAO aaaDAO;

	@RequestMapping(value="loadaaa.html", method=RequestMethod.GET)
	public ModelAndView loadaaa()
	{
		return new ModelAndView("aaa","AaaVO",new AaaVO());
	}

	@RequestMapping(value="insertaaa.html", method=RequestMethod.GET)
	public ModelAndView insertaaa(@ModelAttribute AaaVO aaaVO)
	{
		this.aaaDAO.insert(aaaVO);
		return new ModelAndView("redirect:searchaaa.html");
	}

	@RequestMapping(value="searchaaa.html", method=RequestMethod.GET)
	public ModelAndView searchaaa(@ModelAttribute AaaVO aaaVO)
	{
		List ls = this.aaaDAO.search();
		return new ModelAndView("aaaSearch","list",ls);
	}

	@RequestMapping(value="deleteaaa.html",method=RequestMethod.GET)
	public ModelAndView deleteaaa(@ModelAttribute AaaVO aaaVO, @RequestParam String id )
	{
		aaaVO.setAaaId (Integer.parseInt(id));
		this.aaaDAO.delete(aaaVO);
		return new ModelAndView("redirect:searchaaa.html");
	}

	@RequestMapping(value="editaaa.html",method=RequestMethod.GET)
	public ModelAndView editaaa(@ModelAttribute AaaVO aaaVO, @RequestParam String id)
	{
		aaaVO.setAaaId (Integer.parseInt(id));
		List ls = this.aaaDAO.edit(aaaVO);
		AaaVO aaaVO2 = (AaaVO)ls.get(0);
		return new ModelAndView("aaa","AaaVO",aaaVO2);
	}
}