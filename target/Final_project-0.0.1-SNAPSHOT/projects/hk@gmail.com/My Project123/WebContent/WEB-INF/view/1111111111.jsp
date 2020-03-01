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

<f:form action="insert1111111111.html" modelAttribute="1111111111VO" method="get" >
firstname: <f:input type="text" path="firstname"></f:input><br><br>
gender:		<input type="radio" value=" male "  name="gender" >male
		<input type="radio" value=" female "  name="gender" >female
<f:hidden path="1111111111Id"/>
<input type="submit" value="submit"><br><br>

</f:form>

</body>
</html>