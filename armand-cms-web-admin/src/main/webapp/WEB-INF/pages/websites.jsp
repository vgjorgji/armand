<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Websites" />

<body>
	<global:navigation select="websites" />
	
	<div class="container-fluid">

		<div>
			<a href="#" class="btn btn-success pull-right"><i class="fa fa-plus"></i>Add</a>
			<h2 class="form-header">Websites</h2>
			<hr />
		</div>

		<div class="row">
			
			<div class="col-md-2 website-teaser">
				<div class="thumbnail">
					<div class="caption">
						<img src="http://placehold.it/52x52" class="website-logo" alt="Website Logo">
						<div class="website-name">
							<small>Company Name</small>
							<a href="<c:url value="/website/1000/overview" />">Website Name</a>
						</div>
						<h5>Actions</h5>
						<table class="table">
							<tr>
								<td><i class="fa fa-tv"></i></td>
								<td><a href="<c:url value="/website/1000/design" />">Design</a></td>
								<td><span class="badge btn-danger">3</span></td>
							</tr>
							<tr>
								<td>
									<span class="fa-stack">
										<i class="fa fa-tv fa-stack-1x"></i>
										<i class="fa fa-check fa-stack-1x text-success"></i>
									</span>
								</td>
								<td><a href="<c:url value="/website/1000/reviewdesign" />">Review Design</a></td>
								<td><i class="fa fa-check text-success"></i></td>
							</tr>
							<tr>
								<td><i class="fa fa-clone"></i></td>
								<td><a href="<c:url value="/website/1000/content" />">Write Content</a></td>
								<td><i class="fa fa-ban"></i></td>
							</tr>
							<tr>
								<td>
									<span class="fa-stack">
										<i class="fa fa-clone fa-stack-1x"></i>
										<i class="fa fa-check fa-stack-1x text-success"></i>
									</span>
								</td>
								<td><a href="<c:url value="/website/1000/reviewcontent" />">Review Content</a></td>
								<td><span class="badge btn-danger">3</span></td>
							</tr>
							<tr>
								<td><i class="fa fa-globe"></i></td>
								<td><a href="<c:url value="/website/1000/golive" />">Go Live</a></td>
								<td><i class="fa fa-ban"></i></td>
							</tr>
						</table>
						<h5>Live Status</h5>
						<table class="table">
							<tr>
								<td><i class="fa fa-cube"></i></td>
								<td>Businesse</td>
								<td><i class="fa fa-file-powerpoint-o"></i></td>
								<td>Pages: 10</td>
							</tr>
							<tr>
								<td><i class="light-success"></i></td>
								<td><strong class="text-success">Online</strong></td>
								<td><i class="fa fa-link"></i></td>
								<td><a href="https://www.google.com/" target="_blank">Link</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

		</div> <!-- /.row -->
	</div> <!-- /.container-fluid -->
</body>
</html>
