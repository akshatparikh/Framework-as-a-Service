package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.fileutilities.FileBaseMethods;
import com.demo.model.FieldVO;
import com.demo.model.FormVO;
import com.demo.model.LoginVO;
import com.demo.model.ModuleVO;
import com.demo.model.ProjectVO;
import com.demo.service.FieldService;
import com.demo.service.FormService;
import com.demo.service.ModuleService;
import com.demo.service.ProjectService;
import com.demo.service.RegistrationService;

@Controller
public class formController {
	
	@Autowired
	FormService formService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	FieldService fieldService;
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value="/user/loadForm.html")
	public ModelAndView loadForm()
	{
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		List projectList=projectService.search(loginVO);
		
		/*List moduleList = moduleService.search();*/
		return new ModelAndView("user/addForm", "FormVO", new FormVO()).
				addObject("projectList",projectList);
					
	}
	
	@RequestMapping(value="/insertForm.html")
	public ModelAndView insertForm(@RequestParam String radioButtonValues ,
			@ModelAttribute FormVO formVO,
			HttpSession session
			/*@RequestParam(name="file") MultipartFile file*/ )
	{	
		
		String path = session.getServletContext().getRealPath("/");
		//String fileName = file.getOriginalFilename();
		
		//String finalPath = path+"document\\dataset\\"; 
		
		/*try {
			byte b[] = file.getBytes();
			
			BufferedOutputStream bufferedOutputStream = 
			new BufferedOutputStream(new FileOutputStream(finalPath+"/"+fileName));
			bufferedOutputStream.write(b);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		formVO.setFileName(fileName);
		formVO.setFilePath(finalPath);
		
		this.formService.insertDataset(formVO);*/
		
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		formVO.setLoginVO(loginVO);
		
		ProjectVO projectVO = formVO.getProjectVO();
		ModuleVO moduleVO = formVO.getModuleVO();
		
		List projectList = this.projectService.edit(projectVO);
		List moduleList = this.moduleService.edit(moduleVO);
		
		ProjectVO projectVO2  = (ProjectVO)projectList.get(0);
		ModuleVO moduleVO2  = (ModuleVO)moduleList.get(0);

		this.formService.insert(formVO);

		List<FieldVO> fieldList = formVO.getFieldList();

		for (FieldVO fieldVO : fieldList) 
		{
			fieldVO.setFormVO(formVO);
			this.fieldService.insert(fieldVO);
		}
		
		List<FormVO> formList = formService.search(loginVO,projectVO);
		
		for(FormVO formVO1 : formList){
			System.out.println(formVO.getFormName());
		}

		//String path = session.getServletContext().getRealPath("/");
		String email = userName;
		//String path = session.getServletContext().getRealPath("/");
				
		FileBaseMethods.createProjectModule(path+"/projects",email,projectVO2.getProjectName(),moduleVO2.getModuleName());
		FileBaseMethods.createJSP(path+"/projects",email,projectVO2.getProjectName(),moduleVO2.getModuleName(),formVO.getFormName(),fieldList);
		FileBaseMethods.createVO(path+"/projects",email,projectVO2.getProjectName(),formVO.getFormName(),fieldList);
		FileBaseMethods.createDAO(path+"/projects",email,projectVO2.getProjectName(),formVO.getFormName(),fieldList);
		FileBaseMethods.createController(path+"/projects",email,projectVO2.getProjectName(),formVO.getFormName(),fieldList);
		FileBaseMethods.createSearchJSP(path+"/projects",email,projectVO2.getProjectName(),moduleVO2.getModuleName(),formVO.getFormName(),fieldList);
		FileBaseMethods.createXML(path+"/projects",email,projectVO2.getProjectName(),formVO.getFormName(),formList);
		FileBaseMethods.createWEB(path+"/projects",email,projectVO2.getProjectName(),formVO.getFormName(),fieldList);
		
		return new ModelAndView("redirect:/user/loadForm.html");	
	}

	@RequestMapping(value="/searchModule.html")
	public ModelAndView searchModule(@ModelAttribute ModuleVO moduleVO,HttpServletRequest request)
	{	
		
		String userName = FileBaseMethods.getCurrentUser();
		List userList = this.registrationService.searchByUserName(userName);

		LoginVO loginVO= (LoginVO)userList.get(0);
		
		String projectId = request.getParameter("u");
		
		ProjectVO projectVO = new ProjectVO();
		projectVO.setProjectId(Integer.parseInt(projectId));
		
		moduleVO.setProjectVO(projectVO);
		
		List moduleList= this.moduleService.search(projectVO);
		
		System.out.println("sizeeeeeeeeee" + moduleList.size());
		
		return new ModelAndView("/user/json").addObject("moduleList",moduleList);

	}

	
	
}