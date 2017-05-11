<%@ tag body-content="scriptless" %>
<%@ attribute name="selectGlobal" type="java.lang.String" required="true" %>
<%@ attribute name="selectSide" type="java.lang.String" required="true" %>
<%@ attribute name="selectSideSub" type="java.lang.String" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="overview" tagdir="/WEB-INF/tags/overview"%>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib prefix="websites" tagdir="/WEB-INF/tags/websites"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>


<c:choose>
	<c:when test="${selectGlobal eq 'overview'}">
		<overview:navigation select="${selectSide}" />
	</c:when>
	<c:when test="${selectGlobal eq 'admin'}">
		<admin:navigation select="${selectSide}" />
	</c:when>
	<c:when test="${selectGlobal eq 'websites'}">
		<websites:navigation select="${selectSide}" />
	</c:when>
	<c:when test="${selectGlobal eq 'website'}">
		<website:navigation select="${selectSide}" selectSub="${selectSideSub}" />
	</c:when>
</c:choose>
