<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/design/theme" var="pageUrl"/>

<layout:template title="Demo Website | Design | Theme" 
		selectGlobal="website"
		selectSide="design"
		selectSideSub="theme"
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Theme</h2>

		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
			
				<div class="panel panel-default">
					<div class="panel-body">
						{{#websiteView}}
						<form class="form-horizontal">
							<form:hidden id="id" field="id" group="websiteView" />
							<input type="hidden" id="id" data-group="websiteView" data-field="true" value="{{id}}" />
							<form:select id="style" field="style" group="websiteView"
								options="styles" label="Style" />
							<form:select id="color" field="color" group="websiteView"
								options="modernColors" label="Color" />
							<form:select id="selectColor" field="selectColor" group="websiteView" 
								options="modernColors" label="Select Color" />
							<form:select id="font" field="font" group="websiteView"
								options="fonts" label="Font" />
							<div class="form-group">
								<div class="col-md-offset-3 col-md-6">
									<button type="button" class="btn btn-default" id="reset"
											data-url="${pageUrl}/load" 
											data-method="GET" 
											data-spinner="true"
											data-spinner-location="#submit">
										Reset
									</button>
									<button type="submit" class="btn btn-primary" id="submit"
											data-url="${pageUrl}/save" 
											data-method="POST" 
											data-json="true"
											data-group="websiteView"
											data-spinner="true">
										Save
									</button>
								</div>
							</div>
						</form>
						{{/websiteView}}
					</div>
				</div> <!-- /.panel -->
				
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
	</jsp:body>
</layout:template>