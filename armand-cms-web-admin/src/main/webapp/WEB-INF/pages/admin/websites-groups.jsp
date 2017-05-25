<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/websites-groups" var="pageUrl"/>

<template:tree title="Administration | Websites Groups" 
		pageTitle="Websites Groups"
		selectGlobal="admin"
		selectSide="websites-groups" 
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<table:tree pageUrl="${pageUrl}" />
				
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentMainNode">
		<!-- not supported -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentNode">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#websiteGroup}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="websiteGroup" label="ID" />
					<form:select id="websiteId" field="websiteId" group="websiteGroup"
						options="../allWebsites" optionValue="id" optionText="name" label="Website" />
					<form:input id="name" field="name" group="websiteGroup" label="Name" />
					<form:checkbox id="master" field="master" group="websiteGroup" label="Master" />
					<form:buttons group="websiteGroup"
						cancelUrl="${pageUrl}/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/tree/node/{{websiteId}}/{{id}}"
						saveUrl="${pageUrl}/tree/node/{{websiteId}}/save" saveScroll="#main" />
				</form>
				{{/websiteGroup}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentSubNode">
	</jsp:attribute>
</template:tree>
