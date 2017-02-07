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
						<div class="panel panel-default tile-sum">
							<div class="panel-body">
								<a href="#"><i class="fa fa-paint-brush fa-5x"></i></a>
								<h1>24</h1>
								<h4>Designer</h4>
								<small>Pages changed</small>
							</div>
						</div>
					</div>
					<!-- Review Design -->
					<div class="col-md-3">
						<div class="panel panel-default tile-sum">
							<div class="panel-body">
								<a href="#"><i class="fa fa-delicious fa-5x"></i></a>
								<h1 class="text-light-gray">0</h1>
								<h4>Design Reviewer</h4>
								<small>Pages to review</small>
							</div>
						</div>
					</div>
					<!-- Write Content -->
					<div class="col-md-3">
						<div class="panel panel-default tile-sum">
							<div class="panel-body">
								<a href="#"><i class="fa fa-pencil-square-o fa-5x"></i></a>
								<h1>3</h1>
								<h4>Writer</h4>
								<small>Pages content changed</small>
							</div>
						</div>
					</div>
					<!-- Review Content -->
					<div class="col-md-3">
						<div class="panel panel-default tile-sum">
							<div class="panel-body">
								<a href="#"><i class="fa fa-magic fa-5x"></i></a>
								<h1>242</h1>
								<h4>Content Reviewer</h4>
								<small>Pages content to review</small>
							</div>
						</div>
					</div>
				</div><!-- /.row -->
				
				<!-- Website Info -->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<dl class="dl-horizontal col-md-6">
									<dt>Name</dt>
									<dd>Demo</dd>
									<dt>URL</dt>
									<dd>
										<a href="https://www.google.com/" target="_blank">
											<i class="fa fa-globe"></i>www.therealwebsiteurl.com
										</a>
									</dd>
									<dt>CMS Package</dt>
									<dd><i class="fa fa-star"></i><em><strong>Business</strong></em></dd>
									<dt>Languages</dt>
									<dd><i class="flag flag-usa"></i>English <br/><i class="flag flag-macedonia"></i>Macedonian</dd>
									<dt>Status</dt>
									<dd><i class="fa light-success"></i><strong class="text-success">Online</strong></dd>
									<dt>Expiry Date</dt>
									<dd>23.05.2019</dd>
								</dl>
								<div class="col-md-6">
									<dl class="dl-horizontal">
										<dt>Company</dt>
										<dd>Demo</dd>
										<dt>Address 1</dt>
										<dd>XXX</dd>
										<dt>Address 2</dt>
										<dd>no. 242</dd>
										<dt>Phone 1</dt>
										<dd>+389-2-2424-888</dd>
										<dt>Phone 2</dt>
										<dd></dd>
										<dt>Email</dt>
										<dd>demo@email.com</dd>
									</dl>
									<dl class="dl-horizontal">
										<dt>Contact User</dt>
										<dd>Lastname Firstname</dd>
										<dt>Phone</dt>
										<dd>+389-70-424-888</dd>
										<dt>Email</dt>
										<dd>contact.user@email.com</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
				</div> </div><!-- /.row -->
			</div> <!-- /.right menu -->
			
		</div>
	</div> <!-- /.container-fluid -->
</body>
</html>
