<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">
				<i class="logo"></i>
				<span>ARMAND</span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="<c:if test="${select eq 'overview'}">active</c:if>">
					<a href="<c:url value="/overview/dashboard" />">Overview</a>
				</li>
				<c:if test="${userSettings.user.master}">
					<li class="<c:if test="${select eq 'admin'}">active</c:if>">
						<a href="<c:url value="/admin/dashboard" />">Administration</a>
					</li>
				</c:if>
				<li class="<c:if test="${select eq 'websites'}">active</c:if>">
					<a href="<c:url value="/websites/dashboard" />">Websites</a>
				</li>
				<c:if test="${userSettings.selectedWebsiteId > 0}">
					<li class="website <c:if test="${select eq 'website'}">active</c:if>">
						<a href="<c:url value="/website/${userSettings.selectedWebsiteId}/dashboard" />">
							<em id="global-website-name">${userSettings.selectedWebsiteName}</em>
						</a>
					</li>
				</c:if>
				<li class="<c:if test="${select eq 'faq'}">active</c:if>">
					<a href="<c:url value="/faq/dashboard" />">FAQ</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<i class="fa fa-list"></i><span> </span><span class="badge btn-danger">1</span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle logged-user" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<img src="<c:url value="/static/img/stub/img.jpg" />" alt="" class="img-responsive img-circle">
							&nbsp;${userSettings.user.firstName} ${userSettings.user.lastName}&nbsp;
							<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">Settings</a></li>
						<li><a href="#">Mail</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="<c:url value="/logout" />"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
					</ul>
				</li>
			</ul>
		</div> <!-- /.navbar-collapse -->
	</div> <!-- /.container-fluid -->
</nav>