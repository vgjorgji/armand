<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>
<%@ attribute name="showButtonAdd" type="java.lang.Boolean" required="true" %>

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
	<c:if test="${showButtonAdd}">
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
	</c:if>
</form>