<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/admin/users" var="pageUrl"/>

<layout:template title="Administration | Users" 
		selectGlobal="admin"
		selectSide="users" 
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Users</h2>
		
		<div class="panel panel-default">
			<div class="panel-body">
			
				<div class="table-controls">
					<div class="table-search">
						<form>
							<div class="input-group">
								<form:input-solo id="search" field="paging.search" group="paging" placeholder="Search" />
								<span class="input-group-btn">
									<form:button-submit id="searchBtn" submitUrl="${pageUrl}/paging" group="paging" label="Go" />
								</span>
							</div>
						</form>
					</div>
				</div>
			
				<!-- table -->
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Username</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Phone</th>
								<th>Language</th>
							</tr>
						</thead>
						<tbody>
							{{#paging.users}}
							<tr class="{{^enabled}}disabled{{/enabled}} {{#master}}info{{/master}}">
								<td>{{username}}</td>
								<td>{{firstName}}</td>
								<td>{{lastName}}</td>
								<td>{{email}}</td>
								<td>{{phone}}</td>
								<td>{{language.id}}</td>
							</tr>
							{{/paging.users}}
							{{^paging.users}}
							<tr>
								<td colspan="7">No entries.</td>
							</tr>
							{{/paging.users}}
						</tbody>
					</table>
				</div>
				
				<div class="table-controls">
					<div class="table-page">
						<ul class="pager">
							<li class="previous {{^paging.pagePreviousEnabled}}disabled{{/paging.pagePreviousEnabled}}">
								<a href="${pageUrl}/paging">
									<i class="fa fa-long-arrow-left"></i>
								</a>
							</li>
							<li>
								<span><strong>{{paging.page}}</strong> / {{paging.pageCount}}</span>
							</li>
							<li class="next {{^paging.pageNextEnabled}}disabled{{/paging.pageNextEnabled}}">
								<a href="${pageUrl}/paging"><i class="fa fa-long-arrow-right"></i></a>
							</li>
						</ul>
					</div>
					<div class="table-size">
						<form:select-solo id="size" field="paging.size" group="paging" options="paging.sizes"  />
					</div>
					<div>
						<span>Showing {{paging.entriesStart}} to {{paging.entriesEnd}} of <strong>{{paging.entriesCount}}</strong> entries</span>
					</div>
				</div>
			</div>
		</div> <!-- /.panel -->
	</jsp:body>
</layout:template>
