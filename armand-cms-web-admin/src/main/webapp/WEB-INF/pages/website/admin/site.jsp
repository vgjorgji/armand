<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/admin/site" var="pageUrl"/>

<template:main title="Demo Website | Admin | Website" 
		pageTitle="Website"
		selectGlobal="website"
		selectSide="admin"
		selectSideSub="site"
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
			
				<div class="panel panel-default">
					<div class="panel-body">
						{{#website}}
						<form class="form-horizontal">
							<form:hidden id="id" field="id" group="website" />
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
								resetUrl="${pageUrl}/load"
								saveUrl="${pageUrl}/save" />
						</form>
						{{/website}}
					</div>
				</div> <!-- /.panel -->
				
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
	</jsp:attribute>
</template:main>