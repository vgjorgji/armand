<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>


<!-- ./table-controls -->
<table:paging-top pageUrl="${pageUrl}" showButtonAdd="false" />

<!-- tree -->
<table class="tree">
	<tbody>
		{{#paging.fetch.models}}
		<tr class="tree-lvl-1">
			<td class="title">
				{{title}}
			</td>
			<td class="icon">
				{{#icon}}
					<i class="{{cssClass}}"></i>
				{{/icon}}
			</td>
			<td class="id">
				<small>{{id}}</small>
			</td>
			<td class="control">&nbsp;</td>
			<td class="control">&nbsp;</td>
			<td class="control">
				<a href="#" class="text-success"
						data-url="${pageUrl}/tree/node/{{id}}/add" 
						data-method="GET"
						data-spinner="true"
						data-spinner-location="#table-ajax">
					<i class="fa fa-plus"></i>
				</a>
			</td>
		</tr>
			{{#nodes}}
			<tr class="tree-lvl-2">
				<td class="title">
					{{title}}
				</td>
				<td class="icon">
					{{#icon}}
						<i class="{{cssClass}}"></i>
					{{/icon}}
				</td>
				<td class="id">
					<small>{{id}}</small>
				</td>
				<td class="control">
					<a href="#" class="text-warning"
							data-url="${pageUrl}/tree/node/{{../id}}/{{id}}/edit" 
							data-method="GET"
							data-spinner="true"
							data-spinner-location="#table-ajax">
						<i class="fa fa-pencil"></i>
					</a>
				</td>
				<td class="control">
					<a href="#" class="text-danger"
							data-url="${pageUrl}/tree/node/{{../id}}/{{id}}/delete" 
							data-method="POST"
							data-spinner="true"
							data-spinner-location="#table-ajax">
						<i class="fa fa-times"></i>
					</a>
				</td>
				<td class="control">
					<a href="#" class="text-success"
							data-url="${pageUrl}/tree/node/{{../id}}/{{id}}/add" 
							data-method="GET"
							data-spinner="true"
							data-spinner-location="#table-ajax">
						<i class="fa fa-plus"></i>
					</a>
				</td>
			</tr>
				{{#subNodes}}
				<tr class="tree-lvl-3">
					<td class="title">
						{{title}}
					</td>
					<td class="icon">
						{{#icon}}
							<i class="{{cssClass}}"></i>
						{{/icon}}
					</td>
					<td class="id">
						<small>{{id}}</small>
					</td>
					<td class="control">
						<a href="#" class="text-warning"
								data-url="${pageUrl}/tree/node/{{../../id}}/{{../id}}/{{id}}/edit" 
								data-method="GET"
								data-spinner="true"
								data-spinner-location="#table-ajax">
							<i class="fa fa-pencil"></i>
						</a>
					</td>
					<td class="control">
						<a href="#" class="text-danger"
								data-url="${pageUrl}/tree/node/{{../../id}}/{{../id}}/{{id}}/delete" 
								data-method="POST"
								data-spinner="true"
								data-spinner-location="#table-ajax">
							<i class="fa fa-times"></i>
						</a>
					</td>
					<td class="control">
						&nbsp;
					</td>
				</tr>
				{{/subNodes}}
			{{/nodes}}
		{{/paging.fetch.models}}
	</tbody>
</table> <!-- ./tree -->

<!-- /.table-controls -->
<table:paging-bottom pageUrl="${pageUrl}" />
