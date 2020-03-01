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
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<table border="1">

<tr>
<td>Id</td>
<td>aaaaaaaaaaa</td>
<td>Remove</td>
<td>Edit</td>
</tr>

<c:forEach items="${list}" var="i">
<tr>

<td> ${i.formDescriptionId} </td>
<td> ${i.aaaaaaaaaaa} </td>
<td><a href = "<%=request.getContextPath()%>/deleteformDescription.html?id=${i.formId}" >Delete</a></td>
<td><a href = "<%=request.getContextPath()%>/editformDescription.html?id=${i.formId}" >Edit</a></td>
</tr>

</c:forEach>
</table>