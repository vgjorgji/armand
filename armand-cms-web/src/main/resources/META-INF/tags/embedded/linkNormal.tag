<%@ tag body-content="scriptless" %>
<%@ attribute name="link" type="com.vcms.design.model.Link" required="true" %>
<%@ attribute name="showCaret" type="java.lang.Boolean" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<a 
		<c:if test="${not link.external}"> href="<c:url value="${link.url}" />" </c:if>
		<c:if test="${link.external}"> href="${link.url}" target="_blank"</c:if> 
		>
	<vcms:localText value="${link.text}" />
	<c:if test="${showCaret}">
		<span class="caret"></span>
	</c:if>
</a>
