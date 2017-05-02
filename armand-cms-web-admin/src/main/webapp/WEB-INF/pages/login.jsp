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
		
			<h1>Sign In</h1>
			
			<form id="form" action="<c:url value="/login" />" method="post" role="form" autocomplete="off">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
				<div class="form-group">
					<input id="username" name="username" placeholder="Username"
						type="text" class="form-control" autocomplete="off" required autofocus>
				</div>
				
				<div class="form-group">
					<input id="password" name="password" placeholder="Password" 
						type="password" class="form-control" autocomplete="off" required>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Log in
					</button>
				</div>
	
				<div class="form-group">
					<c:if test="${param.failure ne null}">
						<div class="alert alert-danger" role="alert">
							Authentication error
						</div>
					</c:if>
					<c:if test="${param.error ne null}">
						<div class="alert alert-danger" role="alert">
							Invalid username and password.
						</div>
					</c:if>
					<c:if test="${param.logout ne null}">
						<div class="alert alert-success" role="alert">
							You have been logged out.
						</div>
					</c:if>
				</div>
	
			</form>
		</div>
	</div>
</body>
</html>