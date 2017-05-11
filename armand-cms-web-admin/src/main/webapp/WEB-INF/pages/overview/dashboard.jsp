<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<c:url value="/overview/dashboard" var="pageUrl"/>

<template:main title="Dashboard" 
		pageTitle="Dashboard"
		selectGlobal="overview"
		selectSide="dashboard"
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div class="row placeholders">
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
			</div>
			<div class="col-xs-6 col-sm-3 placeholder">
				<h4>Label</h4>
				<span class="text-muted">Something else</span>
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
		
	</jsp:attribute>
</template:main>