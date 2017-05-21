<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/dashboard" var="pageUrl"/>

<template:main title="Demo Website" 
		selectGlobal="website" 
		selectSide="dashboard"
		loadUrl="${pageUrl}/load">
		
	<jsp:attribute name="fragmentMain">
		<div>
			<a href="<c:url value="/website/${userSettings.selectedWebsiteId}/publish" />" class="btn btn-danger pull-right">
				<i class="fa fa-globe"></i>Publish
			</a>
			<h2 class="page-header">Dashboard</h2>
		</div>

		<!-- Actions -->
		<div class="row">
			<!-- Design -->
			<div class="col-md-3">
				<div class="panel panel-default tile-sum">
					<div class="panel-body">
						<a href="#" class="text-gray">
							<i class="fa fa-paint-brush fa-4x"></i>
						</a>
						<h1 class="text-gray">24</h1>
						<h4>Designer</h4>
						<small>Pages changed</small>
					</div>
				</div>
			</div>
			<!-- Review Design -->
			<div class="col-md-3">
				<div class="panel panel-default tile-sum">
					<div class="panel-body disabled">
						<a href="#" class="text-gray">
							<i class="fa fa-delicious fa-4x"></i>
						</a>
						<h1 class="text-gray">1</h1>
						<h4>Design Reviewer</h4>
						<small>Pages to review</small>
					</div>
				</div>
			</div>
			<!-- Write Content -->
			<div class="col-md-3">
				<div class="panel panel-default tile-sum">
					<div class="panel-body">
						<a href="#" class="text-gray">
							<i class="fa fa-pencil-square-o fa-4x"></i>
						</a>
						<h1 class="text-gray">0</h1>
						<h4>Writer</h4>
						<small>Pages content changed</small>
					</div>
				</div>
			</div>
			<!-- Review Content -->
			<div class="col-md-3">
				<div class="panel panel-default tile-sum">
					<div class="panel-body">
						<a href="#" class="text-gray">
							<i class="fa fa-magic fa-4x"></i>
						</a>
						<h1 class="text-gray">242</h1>
						<h4>Content Reviewer</h4>
						<small>Pages content to review</small>
					</div>
				</div>
			</div>
		</div><!-- /.row -->
		
		<!-- Website + Company -->
		<div class="row">
		
			{{#website}}
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body form-horizontal">
						<div class="form-group">
							<label class="col-md-3 control-label">Name</label>
							<div class="col-md-9">
								<p class="form-control-static">{{name}}</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">URL</label>
							<div class="col-md-9">
								<p class="form-control-static">
									<a href="http://{{baseUrl}}" target="_blank">
										<i class="fa fa-globe"></i>{{baseUrl}}
									</a>
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">CMS Package</label>
							<div class="col-md-9">
								<p class="form-control-static">
									<i class="{{cmsPackage.cssClass}}"></i>
									<em><strong>{{cmsPackage.id}}</strong></em>
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Languages</label>
							<div class="col-md-9">
								<p class="form-control-static">
									{{#languages}}
										<i class="{{cssClass}}"></i>{{id}} <br/>
									{{/languages}}
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Status</label>
							<div class="col-md-9">
								<p class="form-control-static">
									<i class="{{status.cssClass}}"></i>
									<strong class="text-success">{{status.id}}</strong>
								</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Expiry Date</label>
							<div class="col-md-9">
								<p class="form-control-static {{../countdown.type.cssClass}}">
									<i class="fa fa-clock-o"></i>{{../countdown.duration}}
								</p>
							</div>
						</div>
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md-6 -->
			{{/website}}
			
			<!-- Company -->
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body form-horizontal">
						<div class="form-group">
							<label class="col-md-3 control-label">Company</label>
							<div class="col-md-9">
								<p class="form-control-static">Demo</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Address 1</label>
							<div class="col-md-9">
								<p class="form-control-static">XXX</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Address 2</label>
							<div class="col-md-9">
								<p class="form-control-static">no. 242</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Phone 1</label>
							<div class="col-md-9">
								<p class="form-control-static">+389-2-2424-888</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Phone 2</label>
							<div class="col-md-9">
								<p class="form-control-static"></p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<p class="form-control-static">demo@email.com</p>
							</div>
						</div>
						<hr/>
						<div class="form-group">
							<label class="col-md-3 control-label">Contact User</label>
							<div class="col-md-9">
								<p class="form-control-static">Lastname Firstname</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Phone</label>
							<div class="col-md-9">
								<p class="form-control-static">+389-70-424-888</p>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<p class="form-control-static">contact.user@email.com</p>
							</div>
						</div>
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md -->
			
		</div><!-- /.row -->
	</jsp:attribute>
</template:main>