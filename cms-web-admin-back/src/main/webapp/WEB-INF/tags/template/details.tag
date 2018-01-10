<%@ tag body-content="scriptless" %>
<%@ attribute name="fragmentMain" fragment="true" %>
<%@ attribute name="fragmentDetails" fragment="true" %>
<%@ attribute name="title" type="java.lang.String" required="true" %>
<%@ attribute name="pageTitle" type="java.lang.String" required="false" %>
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
	<global:ajax-notify />
	<global:navigation select="${selectGlobal}" />
	
	<div class="main-wrap">
		<global:navigation-side selectGlobal="${selectGlobal}" 
				selectSide="${selectSide}" 
				selectSideSub="${selectSideSub}" />
		
		<div class="main-content">
			<c:if test="${not empty pageTitle}">
				<h2 class="page-header">${pageTitle}</h2>
			</c:if>
			<div id="main" class="main-fragment" data-load="${loadUrl}" data-spinner="true">
			</div>
			<div id="details" class="main-fragment">
			</div>
		</div>
	</div>
	
	<script type="text/html" id="fragment-main">
		<jsp:invoke fragment="fragmentMain"/>
	</script>
	<script type="text/html" id="fragment-details">
		<jsp:invoke fragment="fragmentDetails"/>
	</script>
</body>