<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/design/theme" var="pageUrl"/>

<template:main title="Demo Website | Design | Theme" 
		pageTitle="Theme"
		selectGlobal="website"
		selectSide="design"
		selectSideSub="theme"
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
			
				<div class="panel panel-default">
					<div class="panel-body">
						{{#websiteView}}
						<form class="form-horizontal">
							<form:hidden id="id" field="id" group="websiteView" />
							<form:select id="style" field="style" group="websiteView"
								options="styles" label="Style" />
							<form:select id="color" field="color" group="websiteView"
								options="modernColors" label="Color" />
							<form:select id="selectColor" field="selectColor" group="websiteView" 
								options="modernColors" label="Select Color" />
							<form:select id="font" field="font" group="websiteView"
								options="fonts" label="Font" />
							<form:buttons group="websiteView"
								resetUrl="${pageUrl}/reset"
								saveUrl="${pageUrl}/save" />
						</form>
						{{/websiteView}}
					</div>
				</div> <!-- /.panel -->
				
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
	</jsp:attribute>
</template:main>