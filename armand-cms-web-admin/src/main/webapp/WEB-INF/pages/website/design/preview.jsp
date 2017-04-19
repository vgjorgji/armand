<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<c:url value="/website/${userSettings.selectedWebsiteId}/design/preview" var="pageUrl"/>

<layout:template title="Demo Website | Design | Preview" 
		selectGlobal="website"
		selectSide="design"
		selectSideSub="preview"
		loadUrl="${pageUrl}/load">
		
	<jsp:body>
		<h2 class="page-header">Preview</h2>

		<!-- Actions -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						&nbsp;
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
		
		<!-- ??? -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						&nbsp;
					</div>
				</div> <!-- /.panel -->
			</div> <!-- /.col-md-12 -->
		</div><!-- /.row -->
	</jsp:body>
</layout:template>