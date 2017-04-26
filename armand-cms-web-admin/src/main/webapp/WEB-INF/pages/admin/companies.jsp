<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<c:url value="/admin/companies" var="pageUrl"/>

<layout:template title="Administration | Companies" 
		selectGlobal="admin"
		selectSide="companies" 
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Companies</h2>

		<div class="row placeholders">
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">{{user.email}}</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">${userSettings.selectedWebsiteId}</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
		</div>
	</jsp:body>
</layout:template>
