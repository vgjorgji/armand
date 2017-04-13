<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<layout:template title="Demo Website" select="website">
	<jsp:body>
		<website:navigation select="dashboard" />
			
		<div class="main">
			<div>
				<a href="<c:url value="/website/1000/golive" />" class="btn btn-danger pull-right">
					<i class="fa fa-globe"></i>Go Live
				</a>
				<h2 class="page-header">Dashboard</h2>
			</div>
	
			<!-- Actions -->
			<div class="row">
				<!-- Design -->
				<div class="col-md-3">
					<div class="panel panel-default tile-sum">
						<div class="panel-body">
							<a href="#"><i class="fa fa-paint-brush fa-4x"></i></a>
							<h1>24</h1>
							<h4>Designer</h4>
							<small>Pages changed</small>
						</div>
					</div>
				</div>
				<!-- Review Design -->
				<div class="col-md-3">
					<div class="panel panel-default tile-sum">
						<div class="panel-body disabled">
							<a href="#"><i class="fa fa-delicious fa-4x"></i></a>
							<h1>1</h1>
							<h4>Design Reviewer</h4>
							<small>Pages to review</small>
						</div>
					</div>
				</div>
				<!-- Write Content -->
				<div class="col-md-3">
					<div class="panel panel-default tile-sum">
						<div class="panel-body">
							<a href="#"><i class="fa fa-pencil-square-o fa-4x"></i></a>
							<h1>0</h1>
							<h4>Writer</h4>
							<small>Pages content changed</small>
						</div>
					</div>
				</div>
				<!-- Review Content -->
				<div class="col-md-3">
					<div class="panel panel-default tile-sum">
						<div class="panel-body">
							<a href="#"><i class="fa fa-magic fa-4x"></i></a>
							<h1>242</h1>
							<h4>Content Reviewer</h4>
							<small>Pages content to review</small>
						</div>
					</div>
				</div>
			</div><!-- /.row -->
			
			<!-- Website + Company -->
			<div class="row">
			
				<!-- Website -->
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body form-horizontal">
							<div class="form-group">
								<label class="col-md-3 control-label">Name</label>
								<div class="col-md-9">
									<p class="form-control-static">Demo Website</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">URL</label>
								<div class="col-md-9">
									<p class="form-control-static">
										<a href="https://www.google.com/" target="_blank">
											<i class="fa fa-globe"></i>www.therealwebsiteurl.com
										</a>
									</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">CMS Package</label>
								<div class="col-md-9">
									<p class="form-control-static">
										<i class="fa fa-star"></i><em><strong>Business</strong></em>
									</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Languages</label>
								<div class="col-md-9">
									<p class="form-control-static">
										<i class="flag flag-usa"></i>English <br/><i class="flag flag-macedonia"></i>Macedonian
									</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Status</label>
								<div class="col-md-9">
									<p class="form-control-static">
										<i class="fa light-success"></i><strong class="text-success">Online</strong>
									</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Expiry Date</label>
								<div class="col-md-9">
									<p class="form-control-static">
										23.05.2019 (1 year 2 months 29 days)
									</p>
								</div>
							</div>
						</div>
					</div> <!-- /.panel -->
				</div> <!-- /.col-md-6 -->
				
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
		</div> <!-- /.main -->
	</jsp:body>
</layout:template>