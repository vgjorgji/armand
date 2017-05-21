<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/websites" var="pageUrl"/>

<template:details title="Administration | Websites" 
		pageTitle="Websites"
		selectGlobal="admin"
		selectSide="websites" 
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div class="panel panel-default">
			<div class="panel-body">
			
				<table:normal pageUrl="${pageUrl}"
						headers="Company,Name,URL,CMS Package,Status,Expiry Date"
						fields="companyId,name,baseUrl,cmsPackage.id,status.id,expiryDate" />
				
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentDetails">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#website}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="website" label="ID" />
					<form:select id="companyId" field="companyId" group="website"
						options="../allCompanies" optionValue="id" optionText="name" label="Company" />
					<form:input id="name" field="name" group="website" label="Name" />
					<form:input id="baseUrl" field="baseUrl" group="website" label="Base URL" />
					<form:select id="cmsPackage" field="cmsPackage.id" group="website"
						options="../cmsPackages" optionValue="id" label="CMS Package" />
					<form:select id="languages" field="languages" fieldValues="id" group="website"
						options="../allLanguages" optionValue="id" multi="true" label="Languages" />
					<form:select id="status" field="status.id" group="website"
						options="../statuses" optionValue="id" label="Status" />
					<form:input id="expiryDate" field="expiryDate" group="website" label="Expiry Date" />
					<form:buttons group="website"
						cancelUrl="${pageUrl}/cancel" cancelScroll="#main" 
						resetUrl="${pageUrl}/edit/{{id}}"
						saveUrl="${pageUrl}/save" saveScroll="#main" />
				</form>
				{{/website}}
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
</template:details>
