<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/websites-groups" var="pageUrl"/>

<template:details title="Administration | Websites Groups" 
		selectGlobal="admin"
		selectSide="websites-groups" 
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<h2 class="page-header">Websites Groups</h2>
		
		<div class="panel panel-default">
			<div class="panel-body">
			
				<table class="table">
					<tbody>
						<tr class="info">
							<td style="width: 100px">1000</td>
							<td colspan="3">Demo Website</td>
							<td style="width: 40px">
								<button class="btn btn-success btn-xs">
									<i class="fa fa-plus"></i>
								</button>
							</td>
							<td style="width: 40px">&nbsp;</td>
							<td style="width: 40px">&nbsp;</td>
						</tr>
						<tr class="active">
							<td>1000</td>
							<td>&nbsp;</td>
							<td colspan="2">Group Masters</td>
							<td>
								<button class="btn btn-success btn-xs">
									<i class="fa fa-plus"></i>
								</button>
							</td>
							<td>
								<button class="btn btn-warning btn-xs">
									<i class="fa fa-pencil"></i>
								</button>
							</td>
							<td>
								<button class="btn btn-danger btn-xs">
									<i class="fa fa-times"></i>
								</button>
							</td>
						</tr>
						<tr>
							<td>1000</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>Vlado Gjorgjiev</td>
							<td>
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
							<td>
								<button class="btn btn-danger btn-xs">
									<i class="fa fa-times"></i>
								</button>
							</td>
						</tr>
					</tbody>
				</table>
				
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
</template:details>
