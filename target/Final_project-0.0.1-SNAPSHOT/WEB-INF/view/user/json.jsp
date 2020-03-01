<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${moduleList}"></c:set>
<c:set var="lengthOfJSON" value="${f:length(list)}"></c:set>

[

<c:forEach items="${moduleList}" var="i" varStatus="j">


	{
		"moduleId" : "${i.moduleId}" ,
		"moduleName" : "${i.moduleName}"
	}

<c:if test="${j.count ne lengthOfJSON}">
,
</c:if>

</c:forEach>

]