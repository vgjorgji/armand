<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/companies" var="pageUrl"/>

<template:details title="Administration | Companies" 
		pageTitle="Comapnies"
		selectGlobal="admin"
		selectSide="companies" 
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<table:normal pageUrl="${pageUrl}"
						headers="Contact User,Name,Address 2,Phone 1,Email"
						fields="contactUserId,name,address2,phone1,email" />
				
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentDetails">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#company}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="company" label="ID" />
					<form:select id="contactUserId" field="contactUserId" group="company"
						options="../allUsers" optionValue="id" optionText="fullName" label="Contact User" />
					<form:input id="name" field="name" group="company" label="Name" />
					<form:input id="address1" field="address1" group="company" label="Address 1" />
					<form:input id="address2" field="address2" group="company" label="Address 2" />
					<form:input id="phone1" field="phone1" group="company" label="Phone 1" />
					<form:input id="phone2" field="phone2" group="company" label="Phone 2" />
					<form:input id="email" field="email" group="company" label="Email" type="email" />
					<form:buttons group="company"
						cancelUrl="${pageUrl}/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/edit/{{id}}"
						saveUrl="${pageUrl}/save" saveScroll="#main"
						deleteUrl="${pageUrl}/delete/{{id}}" deleteScroll="#main" />
				</form>
				{{/company}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
</template:details>
