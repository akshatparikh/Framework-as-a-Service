<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    
 pageEncoding="ISO-8859-1"%> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<f:form action="insertsmart_home.html" modelAttribute="Smart_homeVO" method="get" >
gender:		<input type="radio" value=" india "  name="gender" >india
		<input type="radio" value="  canada "  name="gender" > canada
country:<select name="c">				
<option>india</option>				
<option> canada</option>
</select>fnam: <f:input type="text" path="fnam"></f:input><br><br>
<f:hidden path="smart_homeId"/>
<input type="submit" value="submit"><br><br>

</f:form>

</body>
</html>