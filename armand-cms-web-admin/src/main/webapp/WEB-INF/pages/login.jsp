<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Login" />

<body>
	<div class="container">
		<div class="center-block max-width-4">
		
			<h2>Please sign in</h2>
			
			<form id="form" action="<c:url value="/login" />" method="post" role="form" autocomplete="off">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
				<div class="form-group">
					<label for="username" class="sr-only">Email address</label>
					<input id="username" name="username" placeholder="Username"
						type="text" class="form-control" autocomplete="off" required autofocus>
				</div>
				
				<div class="form-group">
					<label for="password" class="sr-only">Password</label> 
					<input id="password" name="password" placeholder="Password" 
						type="password" class="form-control" autocomplete="off" required>
				</div>
				
				<div class="form-group">
					<div class="checkbox">
						<label>
							<input type="checkbox" value="remember-me"> Remember me
						</label>
					</div>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Log in
					</button>
				</div>
	
				<div class="form-group">
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
				</div>
	
			</form>
		</div>
	</div>
</body>
</html>
