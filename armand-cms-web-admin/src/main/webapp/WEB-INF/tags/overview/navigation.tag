<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar">
	<ul class="nav nav-sidebar">
		<li class="<c:if test="${select eq 'dashboard'}">active</c:if>">
			<a href="<c:url value="/dashboard" />"><i class="fa fa-desktop"></i>Dashboard</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-table"></i>Reports</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-bar-chart"></i>Analytics</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-file"></i>Export</a>
		</li>
	</ul>
</div>