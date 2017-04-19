<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<c:url value="/websites/dashboard" var="pageUrl"/>

<layout:template title="Websites" 
		selectGlobal="websites" 
		selectSide="dashboard"
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<div>
			<a href="#" class="btn btn-success pull-right"><i class="fa fa-plus"></i>Add</a>
			<h2 class="page-header">Dashboard</h2>
		</div>

		{{#websites}}
		<!-- Website teaser -->
		<div class="website-teaser">
			<div class="panel panel-default">
				<div class="panel-body">
					<img src="http://placehold.it/52x52" class="website-logo" alt="Website Logo">
					<div class="website-url">
						<small>Company Name</small>
						<a href="{{baseUrl}}" target="_blank">
							<i class="fa fa-globe"></i>{{baseUrl}}
						</a>
					</div>
					<a href="<c:url value="/website/{{id}}/dashboard" />" class="website-name">
						{{name}}
					</a>
					<hr/>
					<div class="website-group">
						<div class="first">
							<h5>Live</h5>
							<span>
								<i class="fa light-success"></i>
								<span><strong class="text-success">{{status}}</strong></span>
							</span>
							<span>
								<i class="fa fa-star"></i>
								<span><em>{{cmsPackage}}</em></span>
							</span>
							<span>
								<i class="fa fa-file-powerpoint-o"></i>
								<span>X</span>
							</span>
						</div>
						<div class="second">
							<h5>Actions</h5>
							<a href="<c:url value="/website/{{id}}/design" />">
								<i class="fa fa-paint-brush"></i>
								<span>Designer</span>
								<i class="badge btn-primary">3</i>
							</a>
							<a href="<c:url value="/website/{{id}}/design-review" />">
								<i class="fa fa-delicious"></i>
								<span>Reviewer</span>
								<i class="fa fa-check text-success"></i>
							</a>
							<a href="<c:url value="/website/{{id}}/content" />">
								<i class="fa fa-pencil-square-o"></i>
								<span>Writer</span>
								<i class="badge btn-primary">2.243</i>
							</a>
							<a href="<c:url value="/website/{{id}}/content-review" />">
								<i class="fa fa-magic"></i>
								<span>Reviewer</span>
								<i class="badge btn-danger">99</i>
							</a>
						</div>
					</div>
					<hr/>
					<div class="website-group">
						<div class="first">
							<h5>Active</h5>
							<span>
								<i class="fa fa-user text-success"></i>
								<span>20</span>
							</span>
							<span>
								<i class="fa fa-eye"></i>
								<span>1h 20min</span>
							</span>
							<span>
								<i class="fa fa-eye-slash"></i>
								<span>20min</span>
							</span>
						</div>
						<div class="second">
							<h5>Visits</h5>
							<span>
								<i class="fa fa-user"></i>
								<span>59</span>
							</span>
							<span>
								<i class="fa fa-users"></i>
								<span>1.250</span>
							</span>
							<span>
								<i class="fa fa-clock-o"></i>
								<span>25 %</span>
							</span>
						</div>
					</div>
					
				</div>
			</div> <!-- /.panel -->
		</div> <!-- /.website-teaser -->
		{{/websites}}
			
			<!-- 
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
								<td class="col-md-3">
									<i class="fa fa-paint-brush"></i>
									<a href="<c:url value="/website/1000/design" />">Designer</a>
								</td>
								<td class="col-md-3">
									<span class="badge btn-danger">3</span>
								</td>
								<td class="col-md-3">
									<i class="fa fa-delicious"></i>
									<a href="<c:url value="/website/1000/reviewdesign" />">Reviewer</a>
								</td>
								<td class="col-md-3">
									<i class="fa fa-check text-success"></i>
								</td>
							</tr>
							<tr>
								<td class="col-md-3 no-access">
									<i class="fa fa-pencil-square-o"></i>
									<span>Writer</span>
								</td>
								<td class="col-md-3 no-access">
									<i class="fa fa-ban"></i>
								</td>
								<td class="col-md-3">
									<i class="fa fa-magic"></i>
									<a href="<c:url value="/website/1000/reviewcontent" />">Reviewer</a>
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
						<h5>Actions</h5>
						<table class="table">
							<tr>
								<td class="col-md-3">
									<i class="fa fa-paint-brush"></i>
									<a href="<c:url value="/website/1000/design" />">Designer</a>
								</td>
								<td class="col-md-3">
									<i class="fa fa-check text-success"></i>
								</td>
								<td class="col-md-3">
									<i class="fa fa-delicious"></i>
									<a href="<c:url value="/website/1000/reviewdesign" />">Reviewer</a>
								</td>
								<td class="col-md-3">
									<i class="fa fa-check text-success"></i>
								</td>
							</tr>
							<tr>
								<td class="col-md-3">
									<i class="fa fa-pencil-square-o"></i>
									<a href="<c:url value="/website/1000/content" />">Writer</a>
								</td>
								<td class="col-md-3">
									<i class="fa fa-check text-success"></i>
								</td>
								<td class="col-md-3">
									<i class="fa fa-magic"></i>
									<a href="<c:url value="/website/1000/reviewcontent" />">Reviewer</a>
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
			-->
			
	</jsp:body>
</layout:template>
