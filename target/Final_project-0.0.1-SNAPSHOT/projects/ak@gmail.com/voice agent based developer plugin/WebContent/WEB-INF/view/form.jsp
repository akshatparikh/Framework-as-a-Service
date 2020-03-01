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
gender:		<input type="radio" value=" cricet "  name="gender" >cricet
		<input type="radio" value="  football "  name="gender" > football
hibby:		<input type="checkbox" name="hibby" value="cricet">cricet
		<input type="checkbox" name="hibby" value=" football"> football
fname: <f:input type="text" path="fname"></f:input><br><br>
<f:hidden path="formId"/>
<input type="submit" value="submit"><br><br>

</f:form>

</body>
</html>