<%@ tag body-content="scriptless" %>
<%@ attribute name="pageUrl" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
</div>