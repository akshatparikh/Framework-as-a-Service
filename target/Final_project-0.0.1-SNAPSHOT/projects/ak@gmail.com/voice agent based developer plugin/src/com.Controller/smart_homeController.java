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
public class smart_homeController{

	@Autowired
	Smart_homeDAO smart_homeDAO;

	@RequestMapping(value="loadsmart_home.html", method=RequestMethod.GET)
	public ModelAndView loadsmart_home()
	{
		return new ModelAndView("smart_home","Smart_homeVO",new Smart_homeVO());
	}

	@RequestMapping(value="insertsmart_home.html", method=RequestMethod.GET)
	public ModelAndView insertsmart_home(@ModelAttribute Smart_homeVO smart_homeVO)
	{
		this.smart_homeDAO.insert(smart_homeVO);
		return new ModelAndView("redirect:searchsmart_home.html");
	}

	@RequestMapping(value="searchsmart_home.html", method=RequestMethod.GET)
	public ModelAndView searchsmart_home(@ModelAttribute Smart_homeVO smart_homeVO)
	{
		List ls = this.smart_homeDAO.search();
		return new ModelAndView("smart_homeSearch","list",ls);
	}

	@RequestMapping(value="deletesmart_home.html",method=RequestMethod.GET)
	public ModelAndView deletesmart_home(@ModelAttribute Smart_homeVO smart_homeVO, @RequestParam String id )
	{
		smart_homeVO.setSmart_homeId (Integer.parseInt(id));
		this.smart_homeDAO.delete(smart_homeVO);
		return new ModelAndView("redirect:searchsmart_home.html");
	}

	@RequestMapping(value="editsmart_home.html",method=RequestMethod.GET)
	public ModelAndView editsmart_home(@ModelAttribute Smart_homeVO smart_homeVO, @RequestParam String id)
	{
		smart_homeVO.setSmart_homeId (Integer.parseInt(id));
		List ls = this.smart_homeDAO.edit(smart_homeVO);
		Smart_homeVO smart_homeVO2 = (Smart_homeVO)ls.get(0);
		return new ModelAndView("smart_home","Smart_homeVO",smart_homeVO2);
	}
}