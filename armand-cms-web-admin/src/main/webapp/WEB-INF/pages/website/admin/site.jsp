<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="form" tagdir="/WEB-INF/tags/form"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/admin/site" var="pageUrl"/>

<layout:template title="Demo Website | Admin | Website" 
		selectGlobal="website"
		selectSide="admin"
		selectSideSub="site"
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Website</h2>

		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
			
				<div class="panel panel-default">
					<div class="panel-body">
						{{#website}}
						<form class="form-horizontal">
							<form:hidden id="id" field="id" group="website" />
							<form:input id="name" field="name" group="website" label="Name" />
							<form:input id="baseUrl" field="baseUrl" group="website" label="Base URL" />
							<form:select id="cmsPackage" field="cmsPackage.id" group="website"
								options="cmsPackages" optionsField="id" label="CMS Package" />
							<form:select id="languages" field="languages" group="website"
								options="allLanguages" optionsField="id" multi="true" label="Languages" />
							<form:input id="expiryDate" field="expiryDate" group="website" label="Expiry Date" />
							<form:buttons pageUrl="${pageUrl}" group="website" />
						</form>
						{{/website}}
					</div>
				</div> <!-- /.panel -->
				
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
	</jsp:body>
</layout:template>