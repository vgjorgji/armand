<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="nav nav-sidebar">
	<li class="<c:if test="${select eq 'overview'}">active</c:if>">
		<a href="#"><i class="fa fa-desktop"></i>Overview</a>
	</li>
	<li class="<c:if test="${select eq 'companies'}">active</c:if>">
		<a href="#"><i class="fa fa-building"></i>Companies</a>
	</li>
	<li class="<c:if test="${select eq 'users'}">active</c:if>">
		<a href="#"><i class="fa fa-user"></i>Users</a>
	</li>
	<li class="<c:if test="${select eq 'groups'}">active</c:if>">
		<a href="#"><i class="fa fa-users"></i>Groups</a>
	</li>
</ul>
