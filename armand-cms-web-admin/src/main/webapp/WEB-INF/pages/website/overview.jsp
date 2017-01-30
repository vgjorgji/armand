<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Websites" />

<body>
	<global:navigation select="website" />
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 sidebar">
				<website:navigation select="overview" />
			</div>
			
			<div class="col-md-10 col-md-offset-2 main">
			
				<h2 class="page-header">Demo Website</h2>
		
				<div class="row">
					Highlights
				</div> <!-- /.row -->
			</div> <!-- /.right menu -->
			
		</div>
	</div> <!-- /.container-fluid -->
</body>
</html>
