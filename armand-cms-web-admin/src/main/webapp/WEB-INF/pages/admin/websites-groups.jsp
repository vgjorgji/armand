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
			
				<table class="tree">
					<tbody>
						<tr class="tree-lvl-1">
							<td class="title">
								Demo Website
							</td>
							<td class="icon">
							</td>
							<td class="id">
								<small>1000</small>
							</td>
							<td class="control">
								<a href="#" class="text-success">
									<i class="fa fa-plus"></i>
								</a>
							</td>
							<td class="control">&nbsp;</td>
							<td class="control">&nbsp;</td>
						</tr>
						<tr class="tree-lvl-2">
							<td class="title">
								Group Masters
							</td>
							<td class="icon">
								<i class="fa fa-user-secret"></i>
							</td>
							<td class="id">
								<small>1000</small>
							</td>
							<td class="control">
								<a href="#" class="text-success">
									<i class="fa fa-plus"></i>
								</a>
							</td>
							<td class="control">
								<a href="#" class="text-warning">
									<i class="fa fa-pencil"></i>
								</a>
							</td>
							<td class="control">
								<a href="#" class="text-danger">
									<i class="fa fa-times"></i>
								</a>
							</td>
						</tr>
						<tr class="tree-lvl-3">
							<td class="title">
								Vlado Gjorgjiev
							</td>
							<td class="icon">
							</td>
							<td class="id">
								<small>1000</small>
							</td>
							<td class="control">
								&nbsp;
							</td>
							<td class="control">
								&nbsp;
							</td>
							<td class="control">
								<a href="#" class="text-danger">
									<i class="fa fa-times"></i>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
				
			</div>
		</div> <!-- /.panel -->
	</jsp:attribute>
	
	<jsp:attribute name="fragmentLvl1">
		<div class="panel panel-default">
			<div class="panel-body">
				{{#website}}
				<form class="form-horizontal">
					<form:input-static id="id" field="id" group="website" label="ID" />
					<form:select id="companyId" field="companyId" group="website"
						options="allCompanies" optionValue="id" optionText="name" label="Company" />
					<form:input id="name" field="name" group="website" label="Name" />
					<form:input id="baseUrl" field="baseUrl" group="website" label="Base URL" />
					<form:select id="cmsPackage" field="cmsPackage.id" group="website"
						options="cmsPackages" optionValue="id" label="CMS Package" />
					<form:select id="languages" field="languages" fieldValues="id" group="website"
						options="allLanguages" optionValue="id" multi="true" label="Languages" />
					<form:select id="status" field="status.id" group="website"
						options="statuses" optionValue="id" label="Status" />
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
	
	<jsp:attribute name="fragmentLvl2">
	</jsp:attribute>
	
	<jsp:attribute name="fragmentLvl3">
	</jsp:attribute>
</template:tree>
