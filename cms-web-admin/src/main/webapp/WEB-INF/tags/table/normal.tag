<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>
<%@ attribute name="headers" type="java.lang.String" required="true" %>
<%@ attribute name="fields" type="java.lang.String" required="true" %>
<%@ attribute name="rowCssClass" type="java.lang.String" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>


<!-- ./table-controls -->
<table:paging-top pageUrl="${pageUrl}" showButtonAdd="true" />

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
			{{#paging.fetch.models}}
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
			{{/paging.fetch.models}}
			{{^paging.fetch.models}}
			<tr>
				<td colspan="3">No entries.</td>
			</tr>
			{{/paging.fetch.models}}
		</tbody>
	</table>
</div> <!-- ./table-responsive -->

<!-- /.table-controls -->
<table:paging-bottom pageUrl="${pageUrl}" />
