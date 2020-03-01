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

<f:form action="insertform.html" modelAttribute="FormVO" method="get" >
firstname: <f:input type="text" path="firstname"></f:input><br><br>
gender:		<input type="radio" value=" playing "  name="gender" >playing
		<input type="radio" value=" dancing "  name="gender" >dancing
hobby:<select name="h">				
<option>playing</option>				
<option>dancing</option>
</select><f:hidden path="formId"/>
<input type="submit" value="submit"><br><br>

</f:form>

</body>
</html>