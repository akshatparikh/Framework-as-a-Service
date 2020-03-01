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

<f:form action="insertformDescription.html" modelAttribute="FormDescriptionVO" method="get" >
aaaaaaaaaaa:		<input type="checkbox" name="aaaaaaaaaaa" value="cricket">cricket
		<input type="checkbox" name="aaaaaaaaaaa" value=" dance"> dance
<f:hidden path="formDescriptionId"/>
<input type="submit" value="submit"><br><br>

</f:form>

</body>
</html>