
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>
<%@ taglib prefix="vapi" uri="http://www.vcms.com/tags/vapi"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- Title -->
<title>Login</title>

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
	<div class="container">

		<form id="form" action="<c:url value="/login" />" method="post" role="form" autocomplete="off" class="form-login">

			<h2 class="form-signin-heading">Please sign in</h2>

			<label for="username" class="sr-only">Email address</label>
			<input type="email" id="username" name="username" placeholder="Username"
				type="text" class="form-control" autocomplete="off"
				required autofocus id="inputEmail">
				
			<label for="password" class="sr-only">Password</label> 
			<input id="password" name="password" placeholder="Password" type="password"
				class="form-control" autocomplete="off" required>
			
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			<div class="checkbox">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>

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
</body>
</html>
