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
							<h5 class="text-gray">Live</h5>
							<span>
								<i class="{{status.cssClass}}"></i>
								<span>{{status.id}}</span>
							</span>
							<span>
								<i class="{{cmsPackage.cssClass}}"></i>
								<span><em>{{cmsPackage.id}}</em></span>
							</span>
							<span>
								<i class="fa fa-file-powerpoint-o"></i>
								<span>X</span>
							</span>
						</div>
						<div class="second">
							<h5 class="text-gray">Actions</h5>
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
							<h5 class="text-gray">Active</h5>
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
							<h5 class="text-gray">Visits</h5>
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
			
	</jsp:body>
</layout:template>
