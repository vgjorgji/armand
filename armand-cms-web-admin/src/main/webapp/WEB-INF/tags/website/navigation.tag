<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>
<%@ attribute name="selectSub" type="java.lang.String" required="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<div class="sidebar ${select}">
	<ul class="nav nav-sidebar">
		<li class="<c:if test="${select eq 'dashboard'}">active</c:if>">
			<a href="<c:url value="/website/1000/dashboard" />">
				<i class="fa fa-desktop"></i>
				Dashboard
			</a>
		</li>
		<li class="<c:if test="${select eq 'design'}">active</c:if>">
			<a href="<c:url value="/website/1000/design" />">
				<i class="fa fa-paint-brush"></i>
				Design
			</a>
			<c:if test="${select eq 'design'}">
				<website:navigation-design select="${selectSub}" />
			</c:if>
		</li>
		<li class="<c:if test="${select eq 'design-review'}">active</c:if>">
			<a href="<c:url value="/website/1000/design-review" />">
				<i class="fa fa-delicious"></i>
				Design Review
			</a>
		</li>
		<li>
			<a href="#">
				<i class="fa fa-pencil-square-o"></i>
				Content
			</a>
		</li>
		<li>
			<a href="#">
				<i class="fa fa-magic"></i>
				Content Review
			</a>
		</li>
		<li>
			<a href="#">
				<i class="fa fa-globe"></i>
				Publish
			</a>
		</li>
	</ul>
	<h3>TOOLS</h3>
	<ul class="nav nav-sidebar">
		<li>
			<a href="#">
				<i class="fa fa-bar-chart"></i>
				Analytics
			</a>
		</li>
		<li>
			<a href="#">
				<i class="fa fa-file"></i>
				Export
			</a>
		</li>
	</ul>
</div>