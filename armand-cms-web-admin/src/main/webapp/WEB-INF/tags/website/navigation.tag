<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="sidebar">
	<ul class="nav nav-sidebar">
		<li class="<c:if test="${select eq 'dashboard'}">active</c:if>">
			<a href="<c:url value="/website/1000/dashboard" />"><i class="fa fa-desktop"></i>Dashboard</a>
		</li>
		<li class="<c:if test="${select eq 'designer'}">active</c:if>">
			<a href="<c:url value="/website/1000/designer" />"><i class="fa fa-paint-brush"></i>Designer</a>
			
			<c:if test="${select eq 'designer'}">
				<ul class="nav nav-sidebar">
					<li>
						<a href="#"><i class="fa fa-delicious"></i>Theme</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-delicious"></i>Navigation</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-delicious"></i>Pages</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-delicious"></i>Preview</a>
					</li>
				</ul>
			</c:if>
		</li>
		<li>
			<a href="#"><i class="fa fa-delicious"></i>Review Design</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-pencil-square-o"></i>Content Writer</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-magic"></i>Review Content</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-globe"></i>Go Live!</a>
		</li>
	</ul>
	<h3>TOOLS</h3>
	<ul class="nav nav-sidebar">
		<li>
			<a href="#"><i class="fa fa-bar-chart"></i>Analytics</a>
		</li>
		<li>
			<a href="#"><i class="fa fa-file"></i>Export</a>
		</li>
	</ul>
</div>