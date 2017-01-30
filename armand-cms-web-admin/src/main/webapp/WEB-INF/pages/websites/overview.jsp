<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>
<%@ taglib prefix="websites" tagdir="/WEB-INF/tags/websites"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Websites" />

<body>
	<global:navigation select="websites" />
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 sidebar">
				<websites:navigation select="overview" />
			</div>
			
			<div class="col-md-10 col-md-offset-2 main">
				<div>
					<a href="#" class="btn btn-success pull-right"><i class="fa fa-plus"></i>Add</a>
					<h2 class="page-header">Websites</h2>
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
								<div>
									<h5>Actions</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-3">
											<i class="fa fa-tv"></i>
											<a href="<c:url value="/website/1000/design" />">Design</a>
										</td>
										<td class="col-md-3">
											<span class="badge btn-primary">3</span>
										</td>
										<td class="col-md-3">
											<i class="fa fa-delicious"></i>
											<a href="<c:url value="/website/1000/reviewdesign" />">Review</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
									</tr>
									<tr>
										<!-- <td class="no-access"><i class="fa fa-pencil-square-o"></i><a href="<c:url value="/website/1000/content" />">Write Content</a></td>  -->
										<td class="col-md-3 no-access">
											<i class="fa fa-pencil-square-o"></i>
											<span>Content</span>
										</td>
										<td class="col-md-3 no-access">
											<i class="fa fa-ban"></i>
										</td>
										<td class="col-md-3">
											<i class="fa fa-magic"></i>
											<a href="<c:url value="/website/1000/reviewcontent" />">Review</a>
										</td>
										<td class="col-md-3">
											<span class="badge btn-primary">99</span>
										</td>
									</tr>
								</table>
								<div>
									<a href="https://www.google.com/" target="_blank" class="pull-right">
										<i class="fa fa-globe"></i>www.therealwebsiteurl.com
									</a>
									<h5>Live</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-5"><i class="fa light-success"></i><strong class="text-success">Online</strong></td>
										<td class="col-md-4"><i class="fa fa-star"></i><em>Business</em></td>
										<td class="col-md-3"><i class="fa fa-file-powerpoint-o"></i>10</td>
									</tr>
								</table>
								<h5>Reports</h5>
								<table class="table last">
									<tr>
										<td>Active</td>
										<td><i class="fa fa-user text-success"></i>20</td>
										<td><i class="fa fa-eye"></i>1h 20min</td>
										<td><i class="fa fa-eye-slash"></i>20min</td>
									</tr>
									<tr>
										<td>Visits</td>
										<td><i class="fa fa-user"></i>59</td>
										<td><i class="fa fa-users"></i>1.250</td>
										<td><i class="fa fa-clock-o"></i>25 %</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					
					<div class="col-md-2 website-teaser">
						<div class="thumbnail">
							<div class="caption">
								<img src="http://placehold.it/52x52" class="website-logo" alt="Website Logo">
								<div class="website-name">
									<small>Company Name</small>
									<a href="<c:url value="/website/1000/overview" />">Website Name</a>
								</div>
								<div>
									<span class="btn btn-primary btn-xs pull-right disabled"><i class="fa fa-globe"></i>Go Live</span>
									<h5>Actions</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-3">
											<i class="fa fa-tv"></i>
											<a href="<c:url value="/website/1000/design" />">Design</a>
										</td>
										<td class="col-md-3">
											<span class="badge btn-danger">3</span>
										</td>
										<td class="col-md-3">
											<i class="fa fa-delicious"></i>
											<a href="<c:url value="/website/1000/reviewdesign" />">Review</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
									</tr>
									<tr>
										<td class="col-md-3 no-access">
											<i class="fa fa-pencil-square-o"></i>
											<span>Content</span>
										</td>
										<td class="col-md-3 no-access">
											<i class="fa fa-ban"></i>
										</td>
										<td class="col-md-3">
											<i class="fa fa-magic"></i>
											<a href="<c:url value="/website/1000/reviewcontent" />">Review</a>
										</td>
										<td class="col-md-3">
											<span class="badge btn-primary">99</span>
										</td>
									</tr>
								</table>
								<div>
									<a href="https://www.google.com/" target="_blank" class="pull-right">
										<i class="fa fa-globe"></i>www.therealwebsiteurl.com
									</a>
									<h5>Live</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-5"><i class="fa light-warning"></i><strong class="text-warning">Construction</strong></td>
										<td class="col-md-4"><i class="fa fa-cubes"></i><em>Dynamic</em></td>
										<td class="col-md-3"><i class="fa fa-file-powerpoint-o"></i>0</td>
									</tr>
								</table>
								<h5>Reports</h5>
								<table class="table last">
									<tr>
										<td>Active</td>
										<td><i class="fa fa-user text-success"></i>20</td>
										<td><i class="fa fa-eye"></i>1h 20min</td>
										<td><i class="fa fa-eye-slash"></i>20min</td>
									</tr>
									<tr>
										<td>Visits</td>
										<td><i class="fa fa-user"></i>59</td>
										<td><i class="fa fa-users"></i>1.250</td>
										<td><i class="fa fa-clock-o"></i>25 %</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					
					<div class="col-md-2 website-teaser">
						<div class="thumbnail">
							<div class="caption">
								<img src="http://placehold.it/52x52" class="website-logo" alt="Website Logo">
								<div class="website-name">
									<small>Company Name</small>
									<a href="<c:url value="/website/1000/overview" />">Website Name</a>
								</div>
								<div>
									<a href="<c:url value="/website/1000/golive" />" class="btn btn-primary btn-xs pull-right"><i class="fa fa-globe"></i>Go Live</a>
									<h5>Actions</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-3">
											<i class="fa fa-tv"></i>
											<a href="<c:url value="/website/1000/design" />">Design</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
										<td class="col-md-3">
											<i class="fa fa-delicious"></i>
											<a href="<c:url value="/website/1000/reviewdesign" />">Review</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
									</tr>
									<tr>
										<td class="col-md-3">
											<i class="fa fa-pencil-square-o"></i>
											<a href="<c:url value="/website/1000/content" />">Content</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
										<td class="col-md-3">
											<i class="fa fa-magic"></i>
											<a href="<c:url value="/website/1000/reviewcontent" />">Review</a>
										</td>
										<td class="col-md-3">
											<i class="fa fa-check text-success"></i>
										</td>
									</tr>
								</table>
								<div>
									<a href="https://www.google.com/" target="_blank" class="pull-right">
										<i class="fa fa-globe"></i>www.therealwebsiteurl.com
									</a>
									<h5>Live</h5>
								</div>
								<table class="table">
									<tr>
										<td class="col-md-5"><i class="fa light-danger"></i><strong class="text-danger">Offline</strong></td>
										<td class="col-md-4"><i class="fa fa-cube"></i><em>Basic</em></td>
										<td class="col-md-3"><i class="fa fa-file-powerpoint-o"></i>2</td>
									</tr>
								</table>
								<h5>Reports</h5>
								<table class="table last">
									<tr>
										<td>Active</td>
										<td><i class="fa fa-user text-success"></i>20</td>
										<td><i class="fa fa-eye"></i>1h 20min</td>
										<td><i class="fa fa-eye-slash"></i>20min</td>
									</tr>
									<tr>
										<td>Visits</td>
										<td><i class="fa fa-user"></i>59</td>
										<td><i class="fa fa-users"></i>1.250</td>
										<td><i class="fa fa-clock-o"></i>25 %</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					
				</div> <!-- /.row -->
			</div> <!-- /.right menu -->
			
		</div>
	</div> <!-- /.container-fluid -->
</body>
</html>
