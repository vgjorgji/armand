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
					<form:input-static id="websiteId" field="websiteId" group="websiteGroup" label="Website" />
					<form:input id="name" field="name" group="websiteGroup" label="Name" />
					<form:checkbox id="master" field="master" group="websiteGroup" label="Master" />
					<form:buttons group="websiteGroup"
						cancelUrl="${pageUrl}/tree/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/tree/node/{{websiteId}}/{{id}}/edit"
						saveUrl="${pageUrl}/tree/node/{{websiteId}}/save" saveScroll="#main" />
				</form>
				{{/websiteGroup}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentSubNode">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#websiteUser}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="websiteUser" label="ID" />
					<form:input-static id="websiteId" field="websiteId" group="websiteUser" label="Website" />
					<form:input-static id="websiteGroupId" field="websiteGroupId" group="websiteUser" label="Website Group" />
					<form:select id="userId" field="userId" group="websiteUser"
						options="../allUsers" optionValue="id" optionText="fullName" label="User" />
					<form:select id="powerGroup" field="powerGroup" group="websiteUser"
						options="../powerGroups" label="Power Group" />
					<form:select id="language" field="language.id" group="websiteUser"
						options="../allLanguages" optionValue="id" label="Language" />
					<form:input id="jobPosition" field="jobPosition" group="websiteUser" label="Job Position" />
					<form:input id="biography" field="biography" group="websiteUser" label="Biography" />
					<form:buttons group="websiteUser"
						cancelUrl="${pageUrl}/tree/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/tree/node/{{websiteId}}/{{websiteGroupId}}/{{id}}/edit"
						saveUrl="${pageUrl}/tree/node/{{websiteId}}/{{websiteGroupId}}/save" saveScroll="#main" />
				</form>
				{{/websiteUser}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
</template:tree>
