<%@ tag body-content="scriptless" %>
<%@ attribute name="link" type="com.vcms.website.model.Link" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<c:if test="${not empty link}">
	<a 
			<c:if test="${not link.external}"> href="<c:url value="${link.url}" />" </c:if>
			<c:if test="${link.external}"> href="${link.url}" target="_blank"</c:if>
			class="cms-button cms-color-text cms-color-background">
		<c:if test="${not empty link.icon}">
			<i class="${link.icon.cssClass}"></i>
		</c:if>
		<vcms:localText value="${link.text}" />
	</a>
</c:if>