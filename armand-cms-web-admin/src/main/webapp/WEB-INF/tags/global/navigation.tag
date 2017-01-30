<%@ tag body-content="scriptless" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><i class="fa fa-diamond"></i>Armand</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="<c:if test="${select eq 'dashboard'}">active</c:if>">
					<a href="<c:url value="/dashboard/overview" />">Dashboard</a>
				</li>
				<li class="<c:if test="${select eq 'admin'}">active</c:if>">
					<a href="<c:url value="/admin/overview" />">Administration</a>
				</li>
				<li class="<c:if test="${select eq 'websites'}">active</c:if>">
					<a href="<c:url value="/websites/overview" />">Websites</a>
				</li>
				<c:if test="${not empty selectedWebsite}">
					<li class="<c:if test="${select eq 'website'}">active</c:if>">
						<a href="<c:url value="/website/1000/overview" />">Demo Website</a>
					</li>
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<c:url value="/faq/overview" />">FAQ</a>
				</li>
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
						<img src="<c:url value="/static/img/stub/img.jpg" />" alt="" class="img-responsive img-circle"> Vlado Gjorgjiev <span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li><a href="#">Settings</a></li>
						<li><a href="#">Mail</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
					</ul>
				</li>
			</ul>
			<form class="navbar-form navbar-right" role="search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go</button>
					</span>
				</div>
			</form>
		</div> <!-- /.navbar-collapse -->
	</div> <!-- /.container-fluid -->
</nav>