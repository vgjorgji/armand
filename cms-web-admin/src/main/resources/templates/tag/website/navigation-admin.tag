<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<ul class="nav nav-sidebar-sub">
	<li>
		<a href="<c:url value="/website/${userSettings.selectedWebsiteId}/admin/site" />">
			<i class="fa ${select eq 'site' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Website
		</a>
	</li>
	<li>
		<a href="<c:url value="/website/${userSettings.selectedWebsiteId}/admin/users" />">
			<i class="fa ${select eq 'users' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Users
		</a>
	</li>
</ul>
