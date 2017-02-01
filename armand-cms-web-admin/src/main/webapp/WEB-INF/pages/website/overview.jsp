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
			
				<div>
					<a href="<c:url value="/website/1000/golive" />" class="btn btn-danger pull-right">
						<i class="fa fa-globe"></i>Go Live
					</a>
					<h2 class="page-header">Demo Website</h2>
				</div>
		
				<!-- Actions -->
				<div class="row">
					<!-- Design -->
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading"><i class="fa fa-square-o"></i>Designer</div>
							<div class="panel-body">
								<p>View changes: Style, Color, Select Color, Font.</p>
								<p>
									Pages: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-danger">5</strong> removed.
								</p>
								<p>
									Components: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-warning">1</strong> changed,
									<strong class="text-danger">5</strong> removed.
								</p>
								<button type="button" class="btn btn-info">Open Designer</button>
							</div>
						</div>
					</div>
					<!-- Review Design -->
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading"><i class="fa fa-delicious"></i>Design Reviewer</div>
							<div class="panel-body">
								<p>View changes: Style, Color, Select Color, Font.</p>
								<p>
									Pages: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-danger">5</strong> removed.
								</p>
								<p>
									Components: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-warning">1</strong> changed,
									<strong class="text-danger">5</strong> removed.
								</p>
								<button type="button" class="btn btn-warning">Open Design Reviewer</button>
							</div>
						</div>
					</div>
					<!-- Write Content -->
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading"><i class="fa fa-pencil-square-o"></i>Writer</div>
							<div class="panel-body">
								<p>
									Pages: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-danger">5</strong> removed.
								</p>
								<p>
									Components: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-warning">1</strong> changed,
									<strong class="text-danger">5</strong> removed.
								</p>
								<button type="button" class="btn btn-info">Open Writer</button>
							</div>
						</div>
					</div>
					<!-- Review Content -->
					<div class="col-md-3">
						<div class="panel panel-default">
							<div class="panel-heading"><i class="fa fa-magic"></i>Content Reviewer</div>
							<div class="panel-body">
								<p>
									Pages: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-danger">5</strong> removed.
								</p>
								<p>
									Components: 
									<strong class="text-success">20</strong> new, 
									<strong class="text-warning">1</strong> changed,
									<strong class="text-danger">5</strong> removed.
								</p>
								<button type="button" class="btn btn-warning">Open Content Reviewer</button>
							</div>
						</div>
					</div>
				</div><!-- /.row -->
			</div> <!-- /.right menu -->
			
		</div>
	</div> <!-- /.container-fluid -->
</body>
</html>
