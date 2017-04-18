<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<c:url value="/website/${userSettings.selectedWebsiteId}" var="baseUrl"/>

<layout:template title="Demo Website | Design | Theme" 
		selectGlobal="website"
		selectSide="design"
		selectSideSub="theme"
		loadUrl="${baseUrl}/design/theme/load">
		
	<jsp:body>
		<h2 class="page-header">Theme</h2>

		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
					
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-md-3 control-label">Style</label>
								<div class="col-md-6">
									<select class="form-control" id="style"
											data-group="websiteView" data-field="true">
										{{#styles}}<option>{{.}}</option>{{/styles}}
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Color</label>
								<div class="col-md-6">
									<select class="form-control" id="color"
											data-group="websiteView" data-field="true">
										{{#modernColors}}<option>{{.}}</option>{{/modernColors}}
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Select Color</label>
								<div class="col-md-6">
									<select class="form-control" id="selectColor"
											data-group="websiteView" data-field="true">
										{{#modernColors}}<option>{{.}}</option>{{/modernColors}}
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-3 control-label">Font</label>
								<div class="col-md-6">
									<select class="form-control" id="font"
											data-group="websiteView" data-field="true">
										{{#fonts}}<option>{{.}}</option>{{/fonts}}
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-3 col-md-6">
									<button type="button" class="btn btn-default"
											data-url="${baseUrl}/design/theme/reset" 
											data-method="GET" 
											data-spinner="true"
											data-spinner-location="#submit">
										Reset
									</button>
									<button type="submit" class="btn btn-primary" id="submit"
											data-url="${baseUrl}/design/theme/save" 
											data-method="POST" 
											data-json="true"
											data-group="websiteView"
											data-spinner="true">
										Save
									</button>
								</div>
							</div>
							<p id="formResult"></p>
						</form>
						
					</div>
				</div> <!-- /.panel -->
				
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
	</jsp:body>
</layout:template>