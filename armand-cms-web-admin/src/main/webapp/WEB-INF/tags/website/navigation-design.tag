<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<ul class="nav nav-sidebar-sub">
	<li>
		<a href="<c:url value="/website/1000/design/theme" />">
			<i class="fa ${select eq 'theme' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Theme
		</a>
	</li>
	<li>
		<a href="<c:url value="/website/1000/design/navigation" />">
			<i class="fa ${select eq 'navigation' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Navigation
		</a>
	</li>
	<li>
		<a href="<c:url value="/website/1000/design/pages" />">
			<i class="fa ${select eq 'pages' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Pages
		</a>
	</li>
	<li>
		<a href="<c:url value="/website/1000/design/preview" />">
			<i class="fa ${select eq 'preview' ? 'fa-long-arrow-right' : 'fa-blank' }"></i>
			Preview
		</a>
	</li>
</ul>
