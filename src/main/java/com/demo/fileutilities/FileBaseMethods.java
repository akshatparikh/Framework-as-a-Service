package com.demo.fileutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.demo.model.FieldVO;
import com.demo.model.FormVO;

public class FileBaseMethods {

	final static String FILESEPERATOR = "/";
	
	public static String getCurrentUser(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
	}
	
	//Used to create base directory 
	public static Boolean createUserDirectory(String path,String directoryName){
		File file = null;
		try {
			file  = new File(path+"/"+directoryName);
			file.mkdirs();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean createProjectModule(String path,String email,String projectName,String moduleName){
		File file = null;
		
		try {
			
			file  = new File(path+"/"+email+"/"+projectName+"/src");
			file.mkdirs();
			
			file  = new File(path+"/"+email+"/"+projectName+"/src/com.VO");
			file.mkdirs();
		
			file  = new File(path+"/"+email+"/"+projectName+"/src/com.DAO");
			file.mkdirs();
					
			file = new File(path+"/"+email+"/"+projectName+"/src/com.Controller");
			file.mkdirs();
			
			file = new File(path+"/"+email+"/"+projectName+"/WebContent/WEB-INF");
			file.mkdirs();
			
			file  = new File(path+"/"+email+"/"+projectName+"/WebContent/WEB-INF/view");
			file.mkdirs();
			
			return true;
			} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}	

	public static void createJSP(String path,String email, String projectName,String moduleName, String formName,List fieldList){
		
		System.out.println(fieldList.size());

		for (int i = 0  ; i < fieldList.size() ; i++) {
			
			System.out.println(fieldList.get(i).toString());
			
			FieldVO fieldVO = (FieldVO) fieldList.get(i);
			
			System.out.println(fieldVO.getFieldName());
			System.out.println(fieldVO.getFieldType());
			System.out.println(fieldVO.getFieldValue());
		}
		
		System.out.println("before jsp creaion****************");
		
		/*String line = "";
		String data = "";*/
		
		try{
			FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR + "WebContent/WEB-INF/view/"+formName+".jsp");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("<%@ page language="+"\"java\""+" contentType="+"\"text/html; charset=ISO-8859-1\""+"    \n pageEncoding="+"\"ISO-8859-1\""+"%> ");
			
			bufferedWriter.write("\n <!DOCTYPE html PUBLIC " +"\"-//W3C//DTD HTML 4.01 Transitional//EN\""+ "\"http://www.w3.org/TR/html4/loose.dtd\">" );
			bufferedWriter.write("\n <html>");
			bufferedWriter.write("\n <head>");
			bufferedWriter.write("\n<meta http-equiv="+"\"Content-Type\""+ "content="+"\"text/html; charset=ISO-8859-1\">");
			bufferedWriter.write("\n<title>Insert title here</title>");
			
			bufferedWriter.write("\n\n<script type=\"text/javascript\">");
			bufferedWriter.write("\nfunction validate(form)");
			bufferedWriter.write("\n{\n");
			
			for (Object object1 : fieldList) {
				FieldVO fieldVO1 = (FieldVO) object1;
				
				if(fieldVO1.getFieldType().equals("text"))
				{
					bufferedWriter.write("\t var "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +" = document.getElementById(\""+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"\");\n");
					bufferedWriter.write("\t var "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"1 = document.getElementById(\""+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"1\");\n");
					bufferedWriter.write("\t var "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"2 = document.getElementById(\""+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"2\");\n");
					bufferedWriter.write("\n\t if("+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +".value==\"\")");
					bufferedWriter.write("\n\t {");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +".style.border=\"1px solid red\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"1.style.display=\"\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"2.style.display=\"none\";");
					bufferedWriter.write("\n\t\t return false;");
					bufferedWriter.write("\n\t}");
					bufferedWriter.write("\n\telse if("+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +".value.length < 3)");
					bufferedWriter.write("\n\t{");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +".style.border=\"1px solid red\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"1.style.display=\"none\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"2.style.display=\"\";");
					bufferedWriter.write("\n\t\t return false;");
					bufferedWriter.write("\n\t}");
					bufferedWriter.write("\n\telse");
					bufferedWriter.write("\n\t{");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +".style=\"display none\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"1.style.display=\"none\";");
					bufferedWriter.write("\n\t\t "+ Character.toString(fieldVO1.getFieldName().charAt(0)).toLowerCase() + fieldVO1.getFieldName().substring(1) +"2.style.display=\"none\";");
					bufferedWriter.write("\n\t}\n\n");
					
				}
					
			}
			bufferedWriter.write("\n}");
			bufferedWriter.write("</script>");
			bufferedWriter.write("\n</head>");
			bufferedWriter.write("\n<body>\n");
			
			bufferedWriter.write("\n<%@ taglib prefix=\"f\" uri=\"http://www.springframework.org/tags/form\" %>\n\n");
			bufferedWriter.write("<f:form action=\"insert"+formName+".html\" modelAttribute=\""+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) +"VO\" method=\"get\" >\n\n");
			
			for (Object object : fieldList) {
				FieldVO fieldVO = (FieldVO) object;
				
				if(fieldVO.getFieldType().equals("textarea"))
				{
					
					bufferedWriter.write(fieldVO.getFieldName()+": <f:"+fieldVO.getFieldType()+" rows=\"3\" cols=\"20\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\" path=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\" ></f:textarea><br><br>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"1\">Enter "+fieldVO.getFieldName()+" Name</span>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"2\">Enter Valid "+fieldVO.getFieldName()+" Name</span>\n\n");
					bufferedWriter.write("\n<br><br>");
				}
				
				else if(fieldVO.getFieldType().equals("text"))
				{	
					bufferedWriter.write(fieldVO.getFieldName()+": <f:input type=\""+fieldVO.getFieldType()+"\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\" path=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\"></f:input><br><br>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"1\">Enter "+fieldVO.getFieldName()+" value</span>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"2\">Enter Valid "+fieldVO.getFieldName()+" value</span>\n\n");
					bufferedWriter.write("\n<br><br>");
				}
				
				else if(fieldVO.getFieldType().equals("file"))
				{	
					bufferedWriter.write(fieldVO.getFieldName()+": <f:input type=\""+fieldVO.getFieldType()+"\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\"  name=\"file\"  path=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"\"></f:input><br><br>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"1\">Enter "+fieldVO.getFieldName()+" value</span>\n");
					bufferedWriter.write("\t<span style=\"color: red;display: none\" id=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +"2\">Enter Valid "+fieldVO.getFieldName()+" value</span>\n\n");
					bufferedWriter.write("\n<br><br>");
				}
				
				else if(fieldVO.getFieldType().equals("radio") )
				{
					System.out.println("**************************************");
					System.out.println(fieldVO.getFieldName());
					System.out.println(fieldVO.getFieldType());
					System.out.println(fieldVO.getFieldValue());
					System.out.println("**************************************");
					
					String str = fieldVO.getFieldValue();
					String list[] = str.split(",");
					
					bufferedWriter.write(fieldVO.getFieldName() + ":");
					
					for(String fieldValue : list)
					{
						bufferedWriter.write("\t\t<input type=\""+fieldVO.getFieldType()+"\" value=\" "+fieldValue+" \"  name=\""+fieldVO.getFieldName()+"\" >"+fieldValue+"\n");
					}
					bufferedWriter.write("<br><br>");
				}
				
				else if(fieldVO.getFieldType().equals("checkbox") )
				{
					System.out.println("**************************************");
					System.out.println(fieldVO.getFieldName());
					System.out.println(fieldVO.getFieldType());
					System.out.println(fieldVO.getFieldValue());
					System.out.println("**************************************");
					
					String str = fieldVO.getFieldValue();
					String list[] = str.split(",");
					
					bufferedWriter.write(fieldVO.getFieldName() + ":");
					
					for(String fieldValue : list)
					{
						bufferedWriter.write("\t\t<input type=\""+fieldVO.getFieldType()+"\" value=\" "+fieldValue+" \"  name=\""+fieldVO.getFieldName()+"\" >"+fieldValue+"\n");
					}
					bufferedWriter.write("<br><br>");
				}
				else 
				{
					String str = fieldVO.getFieldValue();
					String list[] = str.split(",");
					
					bufferedWriter.write(fieldVO.getFieldName() + ":");
					bufferedWriter.write("<select name=\""+Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase()+"\">");
					
					for(String fieldValue : list)
					{
					bufferedWriter.write("\t\t\t\t\n<option>"+fieldValue+"</option>");
					}
					
					bufferedWriter.write("\n</select>");
				}
			}
			bufferedWriter.write("<br><br>");
			bufferedWriter.write("\n<f:hidden path=\""+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"Id\"/>\n");
			bufferedWriter.write("\n\n<input type=\"submit\" onclick=\"return validate()\" value=\"submit\"><br><br>\n\n");
			bufferedWriter.write("</f:form>\n");
			
			bufferedWriter.write("\n</body>");
			bufferedWriter.write("\n</html>"); 
			
			bufferedWriter.close();
			fileWriter.close();
			
		   }
		catch(Exception e) 
			{
				e.printStackTrace();
			}
	}

public static void createVO(String path,String email, String projectName, String formName,List fieldList){
		
		try{
			FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR +  "src/com.VO/" + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) +"VO.java"  );
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write("package com.VO;\n\n");
			bufferedWriter.write("import javax.persistence.Column;");
			bufferedWriter.write("\nimport javax.persistence.Entity;");
			bufferedWriter.write("\nimport javax.persistence.GeneratedValue;");
			bufferedWriter.write("\nimport javax.persistence.GenerationType;");
			bufferedWriter.write("\nimport javax.persistence.Id;");
			bufferedWriter.write("\nimport javax.persistence.Table;");
			
			bufferedWriter.write("\n\n@Entity \n");
			bufferedWriter.write("@Table(name=\""+formName+"_Table\")\n");
			bufferedWriter.write("public class" + " " + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO{ \n\n");
			bufferedWriter.write("\t@Id \n");
			bufferedWriter.write("\t@GeneratedValue(strategy=GenerationType.AUTO) \n");
			bufferedWriter.write("\t@Column(name=\""+ formName + "Id\")");
			bufferedWriter.write("\t\n\nprivate int " + formName + "Id;\n\n");
			
			bufferedWriter.write("\tpublic int get"  + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "Id()  {\n");
			bufferedWriter.write("\t\treturn "   + formName + "Id ;\n");
			bufferedWriter.write("\t}\n\n");
			
			bufferedWriter.write("\tpublic void set"  + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "Id (int "  + formName + "Id) {\n");
			bufferedWriter.write("\t\tthis." + formName + "Id = " + formName + "Id;\n");
			bufferedWriter.write("\t}\n\n");
			
			for (Object object : fieldList) {
			FieldVO fieldVO = (FieldVO) object;
			
			bufferedWriter.write("@Column(name=\""+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) + "Id\")");
			bufferedWriter.write("\tprivate String "+ Character.toString(fieldVO.getFieldName().charAt(0)).toLowerCase() + fieldVO.getFieldName().substring(1) +";\n\n");
			
			bufferedWriter.write("\tpublic String get" + Character.toString(fieldVO.getFieldName().charAt(0)).toUpperCase() + fieldVO.getFieldName().substring(1) + "(){\n");
			bufferedWriter.write("\t\treturn " + fieldVO.getFieldName() + ";\n");
			bufferedWriter.write("\t}\n\n");
			
			bufferedWriter.write("\tpublic void set" + Character.toString(fieldVO.getFieldName().charAt(0)).toUpperCase() + fieldVO.getFieldName().substring(1)+"(String " +fieldVO.getFieldName()+") {\n");
			bufferedWriter.write("\t\tthis." + fieldVO.getFieldName() + "=" + fieldVO.getFieldName()+ ";\n");
			bufferedWriter.write("\t}\n\n");
			
			}
			bufferedWriter.write("\t}");
			
			bufferedWriter.close();
			fileWriter.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
}

public static void createDAO(String path,String email, String projectName, String formName,List fieldList){

	try
	{
		FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR +  "src/com.DAO/" + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) +"DAO.java"  );
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		bufferedWriter.write("package com.DAO;\n\n");
		bufferedWriter.write("import java.util.ArrayList;");
		bufferedWriter.write("\nimport java.util.List;");

		bufferedWriter.write("\nimport org.hibernate.Query;");
		bufferedWriter.write("\nimport org.hibernate.Session;");
		bufferedWriter.write("\nimport org.hibernate.SessionFactory;");
		bufferedWriter.write("\nimport org.hibernate.Transaction;");
		bufferedWriter.write("\nimport org.springframework.beans.factory.annotation.Autowired;");
		bufferedWriter.write("\nimport org.springframework.stereotype.Repository;");
		
		bufferedWriter.write("\nimport com.VO.*;\n\n");
		bufferedWriter.write("@Repository\n");
		bufferedWriter.write("public class " +Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "DAO{ \n\n");
		bufferedWriter.write("\t@Autowired\n");
		bufferedWriter.write("\tSessionFactory sessionFactory;\n\n");
		bufferedWriter.write("\tpublic void insert("+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO){\n");
		bufferedWriter.write("\n\t\ttry{\n");	
		bufferedWriter.write("\t\t\tSession session=sessionFactory.openSession();\n");
		bufferedWriter.write("\t\t\tTransaction transaction=session.beginTransaction();\n");
		bufferedWriter.write("\t\t\tsession.saveOrUpdate("+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO);\n");
		bufferedWriter.write("\t\t\ttransaction.commit();\n");
		bufferedWriter.write("\t\t\tsession.close();\n\t\t}");
		bufferedWriter.write("catch(Exception e){\n");
		bufferedWriter.write("\t\t\te.printStackTrace();\n\t\t}\n\t}\n\n");
		
		bufferedWriter.write("\tpublic List search(){\n");
		bufferedWriter.write("\n\t\tList ls = new ArrayList();\n");
		bufferedWriter.write("\t\ttry{\n");	
		bufferedWriter.write("\t\t\tSession session=sessionFactory.openSession();\n");
		bufferedWriter.write("\t\t\tTransaction transaction=session.beginTransaction();\n");
		bufferedWriter.write("\t\t\tQuery query = session.createQuery(\"from " +Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO\");\n");
		bufferedWriter.write("\t\t\tls=query.list();\n");
		bufferedWriter.write("\t\t\ttransaction.commit();\n");
		bufferedWriter.write("\t\t\tsession.close();\n\t\t}");
		bufferedWriter.write("catch(Exception e){\n");
		bufferedWriter.write("\t\t\te.printStackTrace();\n\t\t}\t\n");
		bufferedWriter.write("\t\treturn ls;\n");
		bufferedWriter.write("\t}\n\n");
		
		bufferedWriter.write("\tpublic void delete("+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO){\n");
		bufferedWriter.write("\n\t\ttry{\n");	
		bufferedWriter.write("\t\t\tSession session=sessionFactory.openSession();\n");
		bufferedWriter.write("\t\t\tTransaction transaction=session.beginTransaction();\n");
		bufferedWriter.write("\t\t\tsession.delete("+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO);\n");
		bufferedWriter.write("\t\t\ttransaction.commit();\n");
		bufferedWriter.write("\t\t\tsession.close();\n\t\t}");
		bufferedWriter.write("catch(Exception e){\n");
		bufferedWriter.write("\t\t\te.printStackTrace();\n\t\t}\n\t}\n\n");
		
		bufferedWriter.write("\tpublic List edit("+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO){\n");
		bufferedWriter.write("\n\t\tList ls = new ArrayList();\n");
		bufferedWriter.write("\t\ttry{\n");	
		bufferedWriter.write("\t\t\tSession session=sessionFactory.openSession();\n");
		bufferedWriter.write("\t\t\tTransaction transaction=session.beginTransaction();\n");
		bufferedWriter.write("\t\t\tQuery query = session.createQuery(\"from " + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO where id =" + " \'\"+ " + Character.toString(formName.charAt(0)).toLowerCase() +  formName.substring(1)+"VO.get" + Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "Id()" +  " +\"\' "  + "\");\n");
		bufferedWriter.write("\t\t\tls=query.list();\n");
		bufferedWriter.write("\t\t\ttransaction.commit();\n");
		bufferedWriter.write("\t\t\tsession.close();\n\t\t}");
		bufferedWriter.write("catch(Exception e){\n");
		bufferedWriter.write("\t\t\te.printStackTrace();\n\t\t}\n\t");
		bufferedWriter.write("\t\treturn ls;\n");
		bufferedWriter.write("\t}\n\n");
		
		bufferedWriter.write("}");
				
		bufferedWriter.close();
		fileWriter.close();
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}
	
}
	
public static void createController(String path,String email, String projectName, String formName,List fieldList){
	
	try
	{	
		FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR +  "src/com.Controller/" + formName +"Controller.java"  );
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		bufferedWriter.write("package com.Controller;\n\n");
		bufferedWriter.write("import java.util.List;");
		bufferedWriter.write("\nimport org.springframework.beans.factory.annotation.Autowired;");
		bufferedWriter.write("\nimport org.springframework.stereotype.Controller;");
		bufferedWriter.write("\nimport org.springframework.web.bind.annotation.ModelAttribute;");
		bufferedWriter.write("\nimport org.springframework.web.bind.annotation.RequestMapping;");
		bufferedWriter.write("\nimport org.springframework.web.bind.annotation.RequestMethod;");
		bufferedWriter.write("\nimport org.springframework.web.bind.annotation.RequestParam;");
		bufferedWriter.write("\nimport org.springframework.web.servlet.ModelAndView;");
		bufferedWriter.write("\nimport com.DAO.*;");
		bufferedWriter.write("\nimport com.VO.*;");
		
		bufferedWriter.write("\n\n@Controller\n");
		bufferedWriter.write("public class "+formName+"Controller{");
		bufferedWriter.write("\n\n\t@Autowired");
		bufferedWriter.write("\n\t"+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1)+"DAO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"DAO;\n\n");
	
		bufferedWriter.write("\t@RequestMapping(value=\"load"+formName+".html\", method=RequestMethod.GET)\n");
		bufferedWriter.write("\tpublic ModelAndView load"+formName+"()\n\t{");
		bufferedWriter.write("\n\t\treturn new ModelAndView(\""+formName+"\",\""+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1)+"VO\",new "+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1)+"VO());\n\t}\n\n");
		
		bufferedWriter.write("\t@RequestMapping(value=\"insert"+formName+".html\", method=RequestMethod.GET)\n");
		bufferedWriter.write("\tpublic ModelAndView insert"+formName+"(@ModelAttribute "+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO)\n\t{");
		bufferedWriter.write("\n\t\tthis."+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"DAO.insert("+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO);\n");
		bufferedWriter.write("\t\treturn new ModelAndView(\"redirect:search"+formName+".html\");\n\t}");
		
		bufferedWriter.write("\n\n\t@RequestMapping(value=\"search"+formName+".html\", method=RequestMethod.GET)\n");
		bufferedWriter.write("\tpublic ModelAndView search"+formName+"(@ModelAttribute "+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO)\n\t{");
		bufferedWriter.write("\n\t\tList ls = this."+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"DAO.search();");
		bufferedWriter.write("\n\t\treturn new ModelAndView(\""+ formName +"Search\",\"list\",ls);\n\t}");
		
		bufferedWriter.write("\n\n\t@RequestMapping(value=\"delete"+formName+".html\",method=RequestMethod.GET)");
		bufferedWriter.write("\n\tpublic ModelAndView delete"+formName+"(@ModelAttribute "+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO, @RequestParam String id )\n\t{");
		bufferedWriter.write("\n\t\t"+Character.toString(formName.charAt(0)).toLowerCase()+ formName.substring(1)+"VO.set"+ Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "Id (Integer.parseInt(id));");
		bufferedWriter.write("\n\t\tthis."+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"DAO.delete("+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO);");
		bufferedWriter.write("\n\t\treturn new ModelAndView(\"redirect:search"+formName+".html\");\n\t}");
		
		bufferedWriter.write("\n\n\t@RequestMapping(value=\"edit"+formName+".html\",method=RequestMethod.GET)");
		bufferedWriter.write("\n\tpublic ModelAndView edit"+formName+"(@ModelAttribute "+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO, @RequestParam String id)\n\t{");
		bufferedWriter.write("\n\t\t"+Character.toString(formName.charAt(0)).toLowerCase()+ formName.substring(1)+"VO.set"+ Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "Id (Integer.parseInt(id));");
		bufferedWriter.write("\n\t\tList ls = this."+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1) +"DAO.edit("+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO);");
		bufferedWriter.write("\n\t\t"+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO "+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO2 = (" +Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO)ls.get(0);");
		bufferedWriter.write("\n\t\treturn new ModelAndView(\""+formName+"\",\""+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) + "VO\","+Character.toString(formName.charAt(0)).toLowerCase() + formName.substring(1)+"VO2);\n\t}\n");
		
		bufferedWriter.write("}");
				
		bufferedWriter.close();
		fileWriter.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

}
		
public static void createSearchJSP(String path,String email, String projectName,String moduleName, String formName,List fieldList){
	
	/*String line = "";
	String data = "";*/
	
	try
	{
		FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR + "WebContent/WEB-INF/view/"+formName+"Search.jsp"  );
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		bufferedWriter.write("	<%@ page language="+"\"java\""+" contentType="+"\"text/html; charset=ISO-8859-1\""+"    \n pageEncoding="+"\"ISO-8859-1\""+"%> ");
		
		bufferedWriter.write("\n <!DOCTYPE html PUBLIC " +"\"-//W3C//DTD HTML 4.01 Transitional//EN\""+ "\"http://www.w3.org/TR/html4/loose.dtd\">" );
		bufferedWriter.write("\n <html>");
		bufferedWriter.write("\n <head>");
		bufferedWriter.write("\n<meta http-equiv="+"\"Content-Type\""+ "content="+"\"text/html; charset=ISO-8859-1\">");
		bufferedWriter.write("\n<title>Insert title here</title>");
		bufferedWriter.write("\n</head>");
		bufferedWriter.write("\n<body>\n");
		
		bufferedWriter.write("\n<%@ taglib prefix=\"f\" uri=\"http://www.springframework.org/tags/form\" %>");
		bufferedWriter.write("\n<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jstl/core_rt\" %>\n");
		bufferedWriter.write("\n<table border=\"1\">\n");

		bufferedWriter.write("\n<tr>");
		bufferedWriter.write("\n<td>Id</td>");
		
		for (Object object : fieldList) {
			FieldVO fieldVO = (FieldVO) object;
					
			bufferedWriter.write("\n<td>"+fieldVO.getFieldName()+"</td>");
			
		}
		bufferedWriter.write("\n<td>Remove</td>\n");
		bufferedWriter.write("<td>Edit</td>\n");
		bufferedWriter.write("</tr>\n\n");
		
		bufferedWriter.write("<c:forEach items=\"${list}\" var=\"i\">\n");
		bufferedWriter.write("<tr>\n");
		bufferedWriter.write("\n<td> ${i."+formName+"Id} </td>");
		
		for (Object object : fieldList) {
			FieldVO fieldVO = (FieldVO) object;
					
			bufferedWriter.write("\n<td> ${i."+fieldVO.getFieldName()+"} </td>");
		
		}
		
		bufferedWriter.write("\n<td><a href = \"<%=request.getContextPath()%>/delete"+formName+".html?id=${i."+formName+"Id}\" >Delete</a></td>");
		bufferedWriter.write("\n<td><a href = \"<%=request.getContextPath()%>/edit"+formName+".html?id=${i."+formName+"Id}\" >Edit</a></td>");
		bufferedWriter.write("\n</tr>\n");
		bufferedWriter.write("\n</c:forEach>");
		
		bufferedWriter.write("\n</table>");
		
		
		/*bufferedWriter.write(" <s:forEach items="${sessionScope.list}" var="i"> ");
		bufferedWriter.write("<tr>");
		bufferedWriter.write("<td>${i."+formName+"}Id</td>");
		bufferedWriter.write("<td>${i."+fieldVO.getFieldName+"}Id</td>");
		bufferedWriter.write("<td>${i."+fieldVO.getFieldtype+"}Id</td>");
		bufferedWriter.write("</tr>");
		bufferedWriter.write*/
		
		bufferedWriter.close();
		fileWriter.close();	
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}

public static void createXML(String path,String email, String projectName,String formName, List<FormVO> formList)
{
	try
	{
	FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR + "WebContent/WEB-INF" + FILESEPERATOR + "spring-servlet.xml"  );
	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	bufferedWriter.write("\n\n<beans xmlns=\"http://www.springframework.org/schema/beans\"");
	bufferedWriter.write("\n\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:p=\"http://www.springframework.org/schema/p\"");
	bufferedWriter.write("\n\txmlns:context=\"http://www.springframework.org/schema/context\"");
	bufferedWriter.write("\n\txsi:schemaLocation=\"http://www.springframework.org/schema/beans");
	bufferedWriter.write("\n\nhttp://www.springframework.org/schema/beans/spring-beans-3.0.xsd");
	bufferedWriter.write("\nhttp://www.springframework.org/schema/context");
	bufferedWriter.write("\nhttp://www.springframework.org/schema/context/spring-context-3.0.xsd\">");
	bufferedWriter.write("\n\n\n\n\t<context:component-scan base-package=\"com\"/><!--base package of vo,dao,con-->");
	bufferedWriter.write("\n\n\n\t<bean class =\"org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor\"/>");
	bufferedWriter.write("\n\n\t<bean");
	bufferedWriter.write("\n\t\tclass=\"org.springframework.web.servlet.view.InternalResourceViewResolver\">");
	bufferedWriter.write("\n\t\t<property name=\"prefix\" value=\"/WEB-INF/view/\" /><!--path where files are located-->");
	bufferedWriter.write("\n\t\t<property name=\"suffix\" value=\".jsp\" /><!--extensions of located files-->");
	bufferedWriter.write("\n\t</bean>");
	bufferedWriter.write("\n\n\t<bean id=\"dataSource\" class=\"org.apache.commons.dbcp2.BasicDataSource\">");
	bufferedWriter.write("\n\t\t<property name=\"driverClassName\" value=\"com.mysql.jdbc.Driver\"/>");
	bufferedWriter.write("\n\t\t<property name=\"url\" value=\"jdbc:mysql://localhost/\"/>");
	bufferedWriter.write("\n\t\t<property name=\"username\" value=\"\"/>");
	bufferedWriter.write("\n\t\t<property name=\"password\" value=\"\"/>");
	bufferedWriter.write("\n\t</bean>");
	bufferedWriter.write("\n\n\t<context:annotation-config />");
	bufferedWriter.write("\n\n\t<bean id=\"sessionFactory\" class=\"org.springframework.orm.hibernate4.LocalSessionFactoryBean\">");
	bufferedWriter.write("\n\n\t\t<property name=\"dataSource\" ref=\"dataSource\"/>");
	bufferedWriter.write("\n\t\t<property name=\"annotatedClasses\">");
	bufferedWriter.write("\n\t\t\t<list>");
	

	for (FormVO formVO : formList) {
		bufferedWriter.write("\n\t\t\t\t<value>com.VO."+Character.toString(formName.charAt(0)).toUpperCase() + formName.substring(1) +"VO</value><!--vo file destination-->");
	}
	
	
	
	bufferedWriter.write("\n\t\t\t</list>");
	bufferedWriter.write("\n\t\t</property>");
	bufferedWriter.write("\n\n\t\t<property name=\"hibernateProperties\">");
	bufferedWriter.write("\n\t\t\t<props>");
	bufferedWriter.write("\n\t\t\t\t<prop key=\"hibernate.dialect\">org.hibernate.dialect.MySQLDialect</prop>");
	bufferedWriter.write("\n\t\t\t\t<prop key=\"hibernate.show_sql\">true</prop>");
	bufferedWriter.write("\n\t\t\t\t<prop key=\"hibernate.hbm2ddl.auto\">update</prop>");
	bufferedWriter.write("\n\t\t\t</props>");
	bufferedWriter.write("\n\t\t</property>");
	bufferedWriter.write("\n\n\t</bean>");
	bufferedWriter.write("\n\n</beans>");
			
	bufferedWriter.close();
	fileWriter.close();	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
	public static void createWEB(String path,String email, String projectName, String formName,List fieldList)
	{
		try
		{
		 FileWriter fileWriter = new FileWriter(path + FILESEPERATOR + email + FILESEPERATOR + projectName + FILESEPERATOR + "WebContent/WEB-INF" + FILESEPERATOR + "web.xml"  );
		 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		 bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		 bufferedWriter.write("\n\n<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
		 bufferedWriter.write("\n\txmlns=\"http://java.sun.com/xml/ns/javaee\" ");
		 bufferedWriter.write("\n\txsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\"");
		 bufferedWriter.write("\n\tversion=\"2.5\">\n\n\n\n");
		 bufferedWriter.write("\t<servlet>");
		 bufferedWriter.write("\n\t\t<servlet-name>spring</servlet-name><!--servlet name should be same as per file name-->");
		 bufferedWriter.write("\n\t\t<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>");
		 bufferedWriter.write("\n\t</servlet>");
		 bufferedWriter.write("\n\n\t<servlet-mapping>");
		 bufferedWriter.write("\n\t\t<servlet-name>spring</servlet-name><!--servlet name should be same as above-->");
		 bufferedWriter.write("\n\t\t<url-pattern>*.html</url-pattern><!--we can add mutliple url pattern-->");
		 bufferedWriter.write("\n\t</servlet-mapping>");
		 bufferedWriter.write("\n\n</web-app>");
		
		bufferedWriter.close();
		fileWriter.close();	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	// Generate OTP
		protected static int generateOTP(int limit) {

	        int otp = 0;

	        if (limit > 5 || limit < 1)
	            limit = 3;

	        for (int i = 0; i < limit; i++) {

	            int x = new Random().nextInt(9);

	            if (x == 0 && i == 0)
	                i--;
	            else
	                otp = (otp * 10) + x;
	        }

	        return otp;
	    }
	
		// Send mail to user
				public static void sendMail(String email, String subject , String content) {

					java.util.Properties properties = new java.util.Properties();
					properties.put("mail.smtp.auth", "true");
					properties.put("mail.smtp.starttls.enable", "true");
					javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

					try {
						MimeMessage message = new MimeMessage(mailSession);

						message.setContent(content, "text/html");
						message.setSubject(subject);

						InternetAddress sender = new InternetAddress("framework.faas@gmail.com", "Framework as a service");
						InternetAddress receiver = new InternetAddress(email);
						message.setFrom(sender);
						message.setRecipient(MimeMessage.RecipientType.TO, receiver);
						message.saveChanges();

						javax.mail.Transport transport = mailSession.getTransport("smtp");
						transport.connect("smtp.gmail.com", 587, "framework.faas@gmail.com" , "Sourcecode2019");
						transport.sendMessage(message, message.getAllRecipients());
						transport.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

}
