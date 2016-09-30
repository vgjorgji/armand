
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="vapi" uri="http://www.vcms.com/tags/vapi"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!-- Title -->
		<title>
			Login
		</title>
		
		<!-- css -->
		<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-3.3.6.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-theme-3.3.6.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/fontawesome.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/site.css"/>" type="text/css" />
		
		<!-- Scripts -->
		<script type="text/javascript" src="<c:url value="/static/js/jquery-1.12.1.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min-3.3.6.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/static/js/site.js"/>"></script>
	</head>

	<body>
		<header>
			<nav class="navbar" role="navigation">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#">
						<img src="<c:url value="static/img/RNE_PCS.gif"/>" alt="RailNet Europe - Path Coordination System"></a>
					</div>
					<div class="navbar-header navbar-right">
						<a class="navbar-brand" href="http://europa.eu/">
						<img src="<c:url value="static/img/en_cef.png"/>" alt="European Union"></a>
					</div>
					<%--<div class="navbar-text navbar-right"><strong>PCS NG: </strong>v5.0 2016-04-04</div>--%>
				</div>
			</nav>
		</header>
		
		<section id="login-section">
			<div class="container">
				<div class="row">
					<div class="col-xs-4 col-xs-offset-4">
	
						<form id="form" action="<c:url value="/login" />" method="post" role="form" autocomplete="off"
								data-bv-feedbackicons-valid="glyphicon"
								data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
								data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
							<div class="form-group">
								<input id="username" name="username" placeholder="Username"
									type="text" class="form-control input-lg"  autocomplete="off" 
									required autofocus data-bv-notempty-message="Required" />
							</div>
							<div class="form-group">
								<input id="password" name="password" placeholder="Password"
									type="password" class="form-control input-lg" autocomplete="off"
									required data-bv-notempty-message="Required" />
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
							<c:if test="${param.failure ne null}">
								<div class="alert alert-danger" role="alert">
									<p>Authentication error</p>
								</div>
							</c:if>
							<c:if test="${param.error ne null}">
								<div class="alert alert-danger" role="alert">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout ne null}">
								<div class="alert alert-success" role="alert">
									<p>You have been logged out.</p>
								</div>
							</c:if>

							<button type="submit" class="btn btn-primary btn-block btn-lg">
								Log in
							</button>
						</form>
					</div>
				</div>
			</div>
		</section>
	
		<footer>
			<div class="container">
				<div class="row">
					<div class="col-xs-6">
						<section id="contact-section">
							<h2>Contact</h2>
							<p>
								If you have questions or comments please contact
								<a href="mailto:support.pcs@rne.eu" title="Contact PCS Support" tabindex="1">PCS-Support</a>.
							</p>
							<p>
								Your questions, bug reports or comments sent by e-mail in
								English are registered as tickets and handled on all weekdays,
								regardless of holidays or vacation periods, with a guaranteed
								response time (24x7 e-mail support, 4 hours response time).
							</p>
						</section>
					</div>
					<div class="col-xs-6">
						<section id="important-links-section">
							<h2>Links</h2>
							<ul>
								<li><a href="https://pfiptest.railneteurope.info/pcsip/site/index.html" target=" ">PCS IP Documentation</a></li>
								<li><a href="http://cms.rne.eu/pcs/documentation" target=" ">RNE CMS</a></li>
							</ul>
						</section>
					</div>
				</div>
			</div>
		</footer>
	
		<script>
		    $(document).ready(function() {
		    	$('#form').bootstrapValidator();
		    });
	  	</script>
	</body>
</html>
