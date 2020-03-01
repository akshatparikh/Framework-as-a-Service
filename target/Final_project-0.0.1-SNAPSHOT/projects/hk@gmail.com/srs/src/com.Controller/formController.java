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
public class formController{

	@Autowired
	FormDAO formDAO;

	@RequestMapping(value="loadform.html", method=RequestMethod.GET)
	public ModelAndView loadform()
	{
		return new ModelAndView("form","FormVO",new FormVO());
	}

	@RequestMapping(value="insertform.html", method=RequestMethod.GET)
	public ModelAndView insertform(@ModelAttribute FormVO formVO)
	{
		this.formDAO.insert(formVO);
		return new ModelAndView("redirect:searchform.html");
	}

	@RequestMapping(value="searchform.html", method=RequestMethod.GET)
	public ModelAndView searchform(@ModelAttribute FormVO formVO)
	{
		List ls = this.formDAO.search();
		return new ModelAndView("formSearch","list",ls);
	}

	@RequestMapping(value="deleteform.html",method=RequestMethod.GET)
	public ModelAndView deleteform(@ModelAttribute FormVO formVO, @RequestParam String id )
	{
		formVO.setFormId (Integer.parseInt(id));
		this.formDAO.delete(formVO);
		return new ModelAndView("redirect:searchform.html");
	}

	@RequestMapping(value="editform.html",method=RequestMethod.GET)
	public ModelAndView editform(@ModelAttribute FormVO formVO, @RequestParam String id)
	{
		formVO.setFormId (Integer.parseInt(id));
		List ls = this.formDAO.edit(formVO);
		FormVO formVO2 = (FormVO)ls.get(0);
		return new ModelAndView("form","FormVO",formVO2);
	}
}