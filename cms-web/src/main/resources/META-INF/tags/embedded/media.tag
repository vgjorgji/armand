<%@ tag body-content="scriptless" %>
<%@ attribute name="media" type="com.vcms.media.model.Media" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:choose>
	<c:when test="${media.type eq 'Image'}">
		<img 
				<c:if test="${not media.external}"> src="<c:url value="${media.src}" />" </c:if>
				<c:if test="${media.external}"> src="${media.src}" </c:if>
				<c:if test="${media.width > 0}"> width="${media.width}"</c:if>
				<c:if test="${media.height > 0}"> height="${media.height}"</c:if>
		 	/>
	</c:when>
	<c:when test="${media.type eq 'Video'}">
		Video Media
	</c:when>
	<c:when test="${media.type eq 'Document'}">
		Document Media
	</c:when>
</c:choose>