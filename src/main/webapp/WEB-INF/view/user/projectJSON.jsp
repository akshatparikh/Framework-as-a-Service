<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>

<c:set value="${projectList}" var="i"></c:set>

<c:if test="${f:length(i) gt 0}">
<% out.println("Duplicate");%>
</c:if>

<c:if test="${f:length(i) eq 0}">
<% out.println("Fresh");%>
</c:if>