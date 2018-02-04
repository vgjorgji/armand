<%@ tag body-content="scriptless" %>
<%@ attribute name="fragmentMain" fragment="true" %>
<%@ attribute name="fragmentMainNode" fragment="true" %>
<%@ attribute name="fragmentNode" fragment="true" %>
<%@ attribute name="fragmentSubNode" fragment="true" %>
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
			<div class="row">
				<div class="col-lg-6">
					<div id="main" class="main-fragment" data-load="${loadUrl}" data-spinner="true">
					</div>
				</div>
				<div class="col-lg-6">
					<div id="main-node" class="main-fragment">
					</div>
					<div id="node" class="main-fragment">
					</div>
					<div id="sub-node" class="main-fragment">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/html" id="fragment-main">
		<jsp:invoke fragment="fragmentMain"/>
	</script>
	<script type="text/html" id="fragment-main-node">
		<jsp:invoke fragment="fragmentMainNode"/>
	</script>
	<script type="text/html" id="fragment-node">
		<jsp:invoke fragment="fragmentNode"/>
	</script>
	<script type="text/html" id="fragment-sub-node">
		<jsp:invoke fragment="fragmentSubNode"/>
	</script>
</body>