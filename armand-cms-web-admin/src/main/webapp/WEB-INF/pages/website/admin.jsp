<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/admin" var="pageUrl"/>

<template:main title="Demo Website | Admin" 
		pageTitle="Website Administration"
		selectGlobal="website"
		selectSide="admin"
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						&nbsp;
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
		<!-- ??? -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						&nbsp;
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
	</jsp:attribute>
</template:main>