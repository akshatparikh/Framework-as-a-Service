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
public class formDescriptionController{

	@Autowired
	FormDescriptionDAO formDescriptionDAO;

	@RequestMapping(value="loadformDescription.html", method=RequestMethod.GET)
	public ModelAndView loadformDescription()
	{
		return new ModelAndView("formDescription","FormDescriptionVO",new FormDescriptionVO());
	}

	@RequestMapping(value="insertformDescription.html", method=RequestMethod.GET)
	public ModelAndView insertformDescription(@ModelAttribute FormDescriptionVO formDescriptionVO)
	{
		this.formDescriptionDAO.insert(formDescriptionVO);
		return new ModelAndView("redirect:searchformDescription.html");
	}

	@RequestMapping(value="searchformDescription.html", method=RequestMethod.GET)
	public ModelAndView searchformDescription(@ModelAttribute FormDescriptionVO formDescriptionVO)
	{
		List ls = this.formDescriptionDAO.search();
		return new ModelAndView("formDescriptionSearch","list",ls);
	}

	@RequestMapping(value="deleteformDescription.html",method=RequestMethod.GET)
	public ModelAndView deleteformDescription(@ModelAttribute FormDescriptionVO formDescriptionVO, @RequestParam String id )
	{
		formDescriptionVO.setFormDescriptionId (Integer.parseInt(id));
		this.formDescriptionDAO.delete(formDescriptionVO);
		return new ModelAndView("redirect:searchformDescription.html");
	}

	@RequestMapping(value="editformDescription.html",method=RequestMethod.GET)
	public ModelAndView editformDescription(@ModelAttribute FormDescriptionVO formDescriptionVO, @RequestParam String id)
	{
		formDescriptionVO.setFormDescriptionId (Integer.parseInt(id));
		List ls = this.formDescriptionDAO.edit(formDescriptionVO);
		FormDescriptionVO formDescriptionVO2 = (FormDescriptionVO)ls.get(0);
		return new ModelAndView("formDescription","FormDescriptionVO",formDescriptionVO2);
	}
}