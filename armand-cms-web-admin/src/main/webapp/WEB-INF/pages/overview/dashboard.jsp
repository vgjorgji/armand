<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="overview" tagdir="/WEB-INF/tags/overview"%>

<layout:template title="Dashboard" select="overview">
	<jsp:body>
		<overview:navigation select="dashboard" />
		
		<div class="main">
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
	</jsp:body>
</layout:template>