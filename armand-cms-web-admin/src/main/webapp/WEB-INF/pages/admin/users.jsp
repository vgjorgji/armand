<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/users" var="pageUrl"/>

<template:details title="Administration | Users" 
		pageTitle="Users"
		selectGlobal="admin"
		selectSide="users" 
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<table:full pageUrl="${pageUrl}"
					headers="Username,First Name,Last Name,Email,Phone,Language"
					fields="username,firstName,lastName,email,phone,language.id"
					rowCssClass="{{^enabled}}disabled{{/enabled}} {{#master}}text-danger text-bold{{/master}}" />
				
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentDetails">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#user}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="user" label="ID" />
					<form:input id="username" field="username" group="user" label="Username" />
					<form:input id="password" field="password" group="user" label="Password" type="password" />
					<form:checkbox id="enabled" field="enabled" group="user" label="Enabled" />
					<form:checkbox id="master" field="master" group="user" label="Master" />
					<form:input id="firstName" field="firstName" group="user" label="First Name" />
					<form:input id="lastName" field="lastName" group="user" label="Last Name" />
					<form:input id="email" field="email" group="user" label="Email" type="email" />
					<form:input id="phone" field="phone" group="user" label="Phone" />
					<form:select id="language" field="language.id" group="user"
						options="languages" optionValue="id" label="Language" />
					<form:buttons group="user"
						cancelUrl="${pageUrl}/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/edit/{{id}}"
						saveUrl="${pageUrl}/save" saveScroll="#main"
						deleteUrl="${pageUrl}/delete/{{id}}" deleteScroll="#main" />
				</form>
				{{/user}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
</template:details>
