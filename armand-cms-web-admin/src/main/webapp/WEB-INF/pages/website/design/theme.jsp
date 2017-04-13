<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<layout:template title="Demo Website | Design | Theme" select="website">
	<jsp:body>
		<website:navigation select="design" selectSub="theme" />
			
		<div class="main">
			<h2 class="page-header">Theme</h2>
	
			<!-- Actions -->
			<div class="row">
				<div class="col-md-12">
					<form:form action="/" modelAttribute="b">
						<div class="panel panel-default">
							<div class="panel-body form-horizontal">
								<div class="form-group">
									<label class="col-md-3 control-label">Style</label>
									<div class="col-md-6">
										<form:select path="style" cssClass="form-control">
											<form:options items="${['Black','BlackModern','BlackLight']}" />
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Color</label>
									<div class="col-md-6">
										<form:select path="color" cssClass="form-control">
											<form:options items="${['Turquoise','GreenSea']}" />
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Select Color</label>
									<div class="col-md-6">
										<form:select path="selectColor" cssClass="form-control">
											<form:options items="${['Turquoise','GreenSea']}" />
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Font</label>
									<div class="col-md-6">
										<form:select path="font" cssClass="form-control">
											<form:options items="${['Default','PtSansNarrow']}" />
										</form:select>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<button type="button" class="btn btn-default">Cancel</button>
										<button type="submit" class="btn btn-primary">Preview</button>
									</div>
								</div>
							</div>
						</div> <!-- /.panel -->
					</form:form>
				</div> <!-- /.col-md-12 -->
			</div><!-- /.row -->
			
			<!-- ??? -->
			<div class="row">
				<div class="col-md-12">
					<form:form action="/" modelAttribute="b">
						<div class="panel panel-default">
							<div class="panel-body form-horizontal">
								<div class="form-group">
									<label class="col-md-3 control-label">Style</label>
									<div class="col-md-6">
										<p class="form-control-static">This is text for preview.</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Color</label>
									<div class="col-md-6">
										<p class="form-control-static">This is text for preview.</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Select Color</label>
									<div class="col-md-6">
										<p class="form-control-static">This is text for preview.</p>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Font</label>
									<div class="col-md-6">
										<p class="form-control-static">This is text for preview.</p>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-offset-3 col-md-6">
										<button type="button" class="btn btn-default">Cancel</button>
										<button type="submit" class="btn btn-success">Save</button>
									</div>
								</div>
							</div>
						</div> <!-- /.panel -->
					</form:form>
				</div> <!-- /.col-md-12 -->
			</div><!-- /.row -->
			
		</div> <!-- /.main -->
	</jsp:body>
</layout:template>