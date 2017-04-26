<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar">
	<ul class="nav nav-sidebar">
		<li class="<c:if test="${select eq 'dashboard'}">active</c:if>">
			<a href="<c:url value="/admin/dashboard" />"><i class="fa fa-desktop"></i>Dashboard</a>
		</li>
		<li class="<c:if test="${select eq 'users'}">active</c:if>">
			<a href="<c:url value="/admin/users" />"><i class="fa fa-user"></i>Users</a>
		</li>
		<li class="<c:if test="${select eq 'companies'}">active</c:if>">
			<a href="<c:url value="/admin/companies" />"><i class="fa fa-building"></i>Companies</a>
		</li>
		<li class="<c:if test="${select eq 'groups'}">active</c:if>">
			<a href="#"><i class="fa fa-users"></i>Groups</a>
		</li>
	</ul>
</div>