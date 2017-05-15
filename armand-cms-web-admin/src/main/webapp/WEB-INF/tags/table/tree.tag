<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>


<!-- ./table-controls -->
<table:paging-top pageUrl="${pageUrl}" showButtonAdd="false" />

<!-- tree -->
<table class="tree">
	<tbody>
		{{#tree.mainNodes}}
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
			<td class="control">
				<a href="#" class="text-success">
					<i class="fa fa-plus"></i>
				</a>
			</td>
			<td class="control">&nbsp;</td>
			<td class="control">&nbsp;</td>
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
				{{/subNodes}}
			{{/nodes}}
		{{/tree.mainNodes}}
	</tbody>
</table> <!-- ./tree -->

<!-- /.table-controls -->
<table:paging-bottom pageUrl="${pageUrl}" />
