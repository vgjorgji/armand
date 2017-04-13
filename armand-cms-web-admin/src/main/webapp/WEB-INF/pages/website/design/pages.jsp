<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>

<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="website" tagdir="/WEB-INF/tags/website"%>

<layout:template title="Demo Website | Design | Pages" select="website">
	<jsp:body>
		<website:navigation select="design" selectSub="pages" />
			
		<div class="main">
			<h2 class="page-header">Pages</h2>
	
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
			
		</div> <!-- /.main -->
	</jsp:body>
</layout:template>