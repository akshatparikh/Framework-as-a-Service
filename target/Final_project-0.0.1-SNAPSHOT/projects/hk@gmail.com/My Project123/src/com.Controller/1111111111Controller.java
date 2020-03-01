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
public class 1111111111Controller{

	@Autowired
	1111111111DAO 1111111111DAO;

	@RequestMapping(value="load1111111111.html", method=RequestMethod.GET)
	public ModelAndView load1111111111()
	{
		return new ModelAndView("1111111111","1111111111VO",new 1111111111VO());
	}

	@RequestMapping(value="insert1111111111.html", method=RequestMethod.GET)
	public ModelAndView insert1111111111(@ModelAttribute 1111111111VO 1111111111VO)
	{
		this.1111111111DAO.insert(1111111111VO);
		return new ModelAndView("redirect:search1111111111.html");
	}

	@RequestMapping(value="search1111111111.html", method=RequestMethod.GET)
	public ModelAndView search1111111111(@ModelAttribute 1111111111VO 1111111111VO)
	{
		List ls = this.1111111111DAO.search();
		return new ModelAndView("1111111111Search","list",ls);
	}

	@RequestMapping(value="delete1111111111.html",method=RequestMethod.GET)
	public ModelAndView delete1111111111(@ModelAttribute 1111111111VO 1111111111VO, @RequestParam String id )
	{
		1111111111VO.set1111111111Id (Integer.parseInt(id));
		this.1111111111DAO.delete(1111111111VO);
		return new ModelAndView("redirect:search1111111111.html");
	}

	@RequestMapping(value="edit1111111111.html",method=RequestMethod.GET)
	public ModelAndView edit1111111111(@ModelAttribute 1111111111VO 1111111111VO, @RequestParam String id)
	{
		1111111111VO.set1111111111Id (Integer.parseInt(id));
		List ls = this.1111111111DAO.edit(1111111111VO);
		1111111111VO 1111111111VO2 = (1111111111VO)ls.get(0);
		return new ModelAndView("1111111111","1111111111VO",1111111111VO2);
	}
}