<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="dashboard" tagdir="/WEB-INF/tags/dashboard"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Dashboard" />

<body>
	<global:navigation select="dashboard" />
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 sidebar">
				<dashboard:navigation select="overview" />
			</div>
			<div class="col-md-10 col-md-offset-2 main">
			
				<h2 class="page-header">Dashboard</h2>

				<div class="row placeholders">
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
					<div class="col-xs-6 col-sm-3 placeholder">
						<h4>Label</h4>
						<span class="text-muted">Something else</span>
					</div>
				</div>
				
			</div> <!-- /.main -->
		</div> <!-- /.row -->
	</div> <!-- /.container-fluid -->
</body>
</html>
