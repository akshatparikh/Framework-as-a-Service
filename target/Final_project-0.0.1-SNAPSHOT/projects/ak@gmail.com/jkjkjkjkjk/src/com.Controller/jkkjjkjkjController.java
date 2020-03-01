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
public class jkkjjkjkjController{

	@Autowired
	JkkjjkjkjDAO jkkjjkjkjDAO;

	@RequestMapping(value="loadjkkjjkjkj.html", method=RequestMethod.GET)
	public ModelAndView loadjkkjjkjkj()
	{
		return new ModelAndView("jkkjjkjkj","JkkjjkjkjVO",new JkkjjkjkjVO());
	}

	@RequestMapping(value="insertjkkjjkjkj.html", method=RequestMethod.GET)
	public ModelAndView insertjkkjjkjkj(@ModelAttribute JkkjjkjkjVO jkkjjkjkjVO)
	{
		this.jkkjjkjkjDAO.insert(jkkjjkjkjVO);
		return new ModelAndView("redirect:searchjkkjjkjkj.html");
	}

	@RequestMapping(value="searchjkkjjkjkj.html", method=RequestMethod.GET)
	public ModelAndView searchjkkjjkjkj(@ModelAttribute JkkjjkjkjVO jkkjjkjkjVO)
	{
		List ls = this.jkkjjkjkjDAO.search();
		return new ModelAndView("jkkjjkjkjSearch","list",ls);
	}

	@RequestMapping(value="deletejkkjjkjkj.html",method=RequestMethod.GET)
	public ModelAndView deletejkkjjkjkj(@ModelAttribute JkkjjkjkjVO jkkjjkjkjVO, @RequestParam String id )
	{
		jkkjjkjkjVO.setJkkjjkjkjId (Integer.parseInt(id));
		this.jkkjjkjkjDAO.delete(jkkjjkjkjVO);
		return new ModelAndView("redirect:searchjkkjjkjkj.html");
	}

	@RequestMapping(value="editjkkjjkjkj.html",method=RequestMethod.GET)
	public ModelAndView editjkkjjkjkj(@ModelAttribute JkkjjkjkjVO jkkjjkjkjVO, @RequestParam String id)
	{
		jkkjjkjkjVO.setJkkjjkjkjId (Integer.parseInt(id));
		List ls = this.jkkjjkjkjDAO.edit(jkkjjkjkjVO);
		JkkjjkjkjVO jkkjjkjkjVO2 = (JkkjjkjkjVO)ls.get(0);
		return new ModelAndView("jkkjjkjkj","JkkjjkjkjVO",jkkjjkjkjVO2);
	}
}