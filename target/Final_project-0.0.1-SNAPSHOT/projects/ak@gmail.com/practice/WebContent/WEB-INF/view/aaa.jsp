<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    
 pageEncoding="ISO-8859-1"%> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
<meta http-equiv="Content-Type"content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function validate(form)
{
	 var cloth = document.getElementById("cloth");
	 var cloth1 = document.getElementById("cloth1");
	 var cloth2 = document.getElementById("cloth2");

	 if(cloth.value=="")
	 {
		 cloth.style.border="1px solid red";
		 cloth1.style.display="";
		 cloth2.style.display="none";
		 return false;
	}
	else if(cloth.value.length < 3)
	{
		 cloth.style.border="1px solid red";
		 cloth1.style.display="none";
		 cloth2.style.display="";
		 return false;
	}
	else
	{
		 cloth.style="display none";
		 cloth1.style.display="none";
		 cloth2.style.display="none";
	}


}</script>
</head>
<body>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<f:form action="insertaaa.html" modelAttribute="AaaVO" method="get" >

cloth: <f:input type="text" id="cloth" path="cloth"></f:input><br><br>
	<span style="color: red;display: none" id="cloth1">Enter cloth value</span>
	<span style="color: red;display: none" id="cloth2">Enter Valid cloth value</span>


<br><br><br><br>
<f:hidden path="aaaId"/>


<input type="submit" onclick="return validate()" value="submit"><br><br>

</f:form>

</body>
</html>