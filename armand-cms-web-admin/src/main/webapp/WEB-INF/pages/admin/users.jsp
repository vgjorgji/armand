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
			
				<form class="table-controls">
					<div class="table-search">
						<div class="input-group">
							<input id="query" type="text" class="form-control" 
									value="{{paging.query}}" 
									data-group="paging" 
									data-field="true"
									placeholder="Search">
							<span class="input-group-btn">
								<button id="searchBtn" class="btn btn-default" type="submit" 
										data-url="${pageUrl}/paging/search" 
										data-method="GET" 
										data-group="paging"
										data-json="true"
										data-spinner="true"
										data-spinner-location="#table-ajax">
									Go
								</button>
								<button id="resetBtn" class="btn btn-default"
										data-url="${pageUrl}/paging/reset" 
										data-method="GET" 
										data-spinner="true"
										data-spinner-location="#table-ajax">
									Reset
								</button>
							</span>
						</div>
					</div>
					<div class="table-size">
						<select id="size" class="form-control"
								data-url="${pageUrl}/paging/search" 
								data-method="GET"
								data-group="paging"
								data-json="true" 
								data-field="true"
								data-spinner="true"
								data-spinner-location="#table-ajax"
								data-selected="{{paging.size}}">
							{{#paging.sizes}}<option>{{.}}</option>{{/paging.sizes}}
						</select>
					</div>
					<div class="table-ajax">
						<i id="table-ajax"></i>
					</div>
					<div class="pull-right">
						<button id="addBtn" class="btn btn-success" 
								data-url="${pageUrl}/add" 
								data-method="GET" 
								data-spinner="true"
								data-spinner-location="#table-ajax">
							<i class="fa fa-plus"></i>Add
						</button>
					</div>
				</form>
			
				<!-- table -->
				<div class="table-responsive">
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
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							{{#paging.models}}
							<tr class="{{^enabled}}disabled{{/enabled}} {{#master}}info{{/master}}">
								<td><small>{{id}}</small></td>
								<td>{{username}}</td>
								<td>{{firstName}}</td>
								<td>{{lastName}}</td>
								<td>{{email}}</td>
								<td>{{phone}}</td>
								<td>{{language.id}}</td>
								<td>
									<a id="edit{{id}}" href="#"
											data-url="${pageUrl}/edit/{{id}}" 
											data-method="GET" 
											data-spinner="true"
											data-spinner-location="#table-ajax">
										Edit
									</a>
								</td>
							</tr>
							{{/paging.models}}
							{{^paging.models}}
							<tr>
								<td colspan="7">No entries.</td>
							</tr>
							{{/paging.models}}
						</tbody>
					</table>
				</div>
				
				<div class="table-controls">
					<div class="table-page">
						<ul class="pager">
							<li class="previous {{^paging.pagePreviousEnabled}}disabled{{/paging.pagePreviousEnabled}}">
								<a id="pagePrevious" href="#"
										data-url="${pageUrl}/paging/previous" 
										data-method="GET" 
										data-json="true"
										data-group="paging"
										data-spinner="true"
										data-spinner-location="#table-count">
									<i class="fa fa-long-arrow-left"></i>
								</a>
							</li>
							<li>
								<span>
									<strong id="page" class="fake-input" data-field="true" data-group="paging">{{paging.page}}</strong>
									 / {{paging.pageCount}}
								</span>
							</li>
							<li class="next {{^paging.pageNextEnabled}}disabled{{/paging.pageNextEnabled}}">
								<a id="pageNext" href="#"
										data-url="${pageUrl}/paging/next" 
										data-method="GET" 
										data-json="true"
										data-group="paging"
										data-spinner="true"
										data-spinner-location="#table-count">
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</li>
						</ul>
					</div>
					<div>
						<small id="table-count">Showing {{paging.modelsStart}} to {{paging.modelsEnd}} of <strong>{{paging.modelsCount}}</strong> entries</small>
					</div>
				</div>
				
			</div>
		</div> <!-- /.panel -->
	</jsp:body>
</layout:template>
