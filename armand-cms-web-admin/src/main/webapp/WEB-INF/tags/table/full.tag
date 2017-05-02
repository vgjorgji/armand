<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>
<%@ attribute name="headers" type="java.lang.String" required="true" %>
<%@ attribute name="fields" type="java.lang.String" required="true" %>
<%@ attribute name="rowCssClass" type="java.lang.String" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="table-controls">
	<div class="table-search">
		<div class="input-group">
			<input id="table-query" type="text" class="form-control" 
					value="{{paging.query}}" 
					data-group="paging"
					data-field="true"
					placeholder="Search">
			<span class="input-group-btn">
				<button id="table-search" class="btn btn-default" type="submit" 
						data-url="${pageUrl}/paging/search" 
						data-method="GET" 
						data-group="paging"
						data-prefix="table-"
						data-json="true"
						data-spinner="true"
						data-spinner-location="#table-ajax">
					Go
				</button>
				<button id="table-reset" class="btn btn-default"
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
		<select id="table-size" class="form-control"
				data-url="${pageUrl}/paging/search" 
				data-method="GET"
				data-group="paging"
				data-prefix="table-"
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
		<button id="table-add" class="btn btn-success" 
				data-url="${pageUrl}/add" 
				data-method="GET" 
				data-spinner="true"
				data-spinner-location="#table-ajax"
				data-scroll="#details">
			<i class="fa fa-plus"></i>Add
		</button>
	</div>
</form> <!-- ./table-controls -->

<!-- table -->
<div class="table-responsive">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<c:forTokens items="${headers}" delims="," var="token">
					<th>${token}</th>
				</c:forTokens>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			{{#paging.models}}
			<tr id="table-row-{{id}}" class="${rowCssClass}">
				<td><small>{{id}}</small></td>
				<c:forTokens items="${fields}" delims="," var="token">
					<td>{{${token}}}</td>
				</c:forTokens>
				<td>
					<a id="table-edit-{{id}}" href="#"
							data-url="${pageUrl}/edit/{{id}}" 
							data-method="GET" 
							data-spinner="true"
							data-spinner-location="#table-ajax"
							data-scroll="#details">
						Edit
					</a>
				</td>
			</tr>
			{{/paging.models}}
			{{^paging.models}}
			<tr>
				<td colspan="3">No entries.</td>
			</tr>
			{{/paging.models}}
		</tbody>
	</table>
</div> <!-- ./table-responsive -->

<div class="table-controls">
	<div class="table-page">
		<ul class="pager">
			<li class="previous">
				{{#paging.pagePreviousEnabled}}
				<a id="table-page-previous" href="#"
						data-url="${pageUrl}/paging/previous" 
						data-method="GET" 
						data-json="true"
						data-group="paging"
						data-prefix="table-"
						data-spinner="true"
						data-spinner-location="#table-ajax">
					<i class="fa fa-long-arrow-left"></i>
				</a>
				{{/paging.pagePreviousEnabled}}
				{{^paging.pagePreviousEnabled}}
				<span id="table-page-previous" class="disabled" data-spinner="true">
					<i class="fa fa-long-arrow-left"></i>
				</span>
				{{/paging.pagePreviousEnabled}}
			</li>
			<li>
				<span>
					<strong id="table-page" class="fake-input" 
							data-field="true" 
							data-group="paging">
						{{paging.page}}
					</strong>
					 / {{paging.pageCount}}
				</span>
			</li>
			<li class="next">
				{{#paging.pageNextEnabled}}
				<a id="table-page-next" href="#"
						data-url="${pageUrl}/paging/next" 
						data-method="GET" 
						data-json="true"
						data-group="paging"
						data-prefix="table-"
						data-spinner="true"
						data-spinner-location="#table-ajax">
					<i class="fa fa-long-arrow-right"></i>
				</a>
				{{/paging.pageNextEnabled}}
				{{^paging.pageNextEnabled}}
				<span id="table-page-next" class="disabled" data-spinner="true">
					<i class="fa fa-long-arrow-right"></i>
				</span>
				{{/paging.pageNextEnabled}}
			</li>
		</ul>
	</div>
	<div>
		<small>
			Showing {{paging.modelsStart}} to {{paging.modelsEnd}} of <strong>{{paging.modelsCount}}</strong> entries
		</small>
	</div>
</div> <!-- /.table-controls -->