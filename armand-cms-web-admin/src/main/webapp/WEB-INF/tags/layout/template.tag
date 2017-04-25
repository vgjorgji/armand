<%@ tag body-content="scriptless" %>
<%@ attribute name="title" type="java.lang.String" required="true" %>
<%@ attribute name="selectGlobal" type="java.lang.String" required="true" %>
<%@ attribute name="selectSide" type="java.lang.String" required="true" %>
<%@ attribute name="selectSideSub" type="java.lang.String" required="false" %>
<%@ attribute name="loadUrl" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="overview" tagdir="/WEB-INF/tags/overview"%>
<%@ taglib prefix="admin" tagdir="/WEB-INF/tags/admin"%>
<%@ taglib prefix="websites" tagdir="/WEB-INF/tags/websites"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="${title}" />

<body>
	<div id="ajax-send" class="alert alert-warning" role="alert">Updating...</div>
	<div id="ajax-complete" class="alert alert-info" role="alert">Completed</div>
	
	<global:navigation select="${selectGlobal}" />
	
	<div class="main-wrap">
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
		
		<div class="main" id="main" data-load="${loadUrl}" data-spinner="true">
		</div>
	</div>
	
	<script type="text/html" id="template-main">
		<jsp:doBody />
	</script>
</body>