<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<c:url value="/admin/users" var="pageUrl"/>

<layout:template title="Administration | Users" 
		selectGlobal="admin"
		selectSide="users" 
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Users</h2>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>#</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Language</th>
				</tr>
			</thead>
			<tbody>
				{{#users}}
				<tr class="{{^enabled}}disabled{{/enabled}} {{#master}}info{{/master}}">
					<th scope="row">{{number}}</th>
					<td>{{username}}</td>
					<td>{{firstName}}</td>
					<td>{{lastName}}</td>
					<td>{{email}}</td>
					<td>{{phone}}</td>
					<td>{{language.id}}</td>
				</tr>
				{{/users}}
			</tbody>
		</table>
	</jsp:body>
</layout:template>
