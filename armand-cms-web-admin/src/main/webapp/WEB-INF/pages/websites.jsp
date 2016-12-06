<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms"%>
<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="Websites" />

<body>
	<global:navigation select="websites" />
	
	<div class="container-fluid">

		<div>
			<a href="#" class="btn btn-success pull-right"><i class="fa fa-plus"></i>Add</a>
			<h2 class="form-header">Websites</h2>
			<hr />
		</div>

		<div class="row">
			
			<div class="col-md-2 website-teaser">
				<div class="thumbnail">
					<div class="caption">
						<img src="http://placehold.it/52x52" class="website-logo" alt="Website Logo">
						<div class="website-name">
							<small>Company Name</small>
							<a href="<c:url value="/website/1000" />">Website Name</a>
						</div>
						<table class="table">
							<tr>
								<td><i class="fa fa-cube"></i></td>
								<td>Businesse</td>
								<td><i class="fa fa-file-powerpoint-o"></i></td>
								<td>Pages: 10</td>
							</tr>
							<tr>
								<td><i class="light-success"></i></td>
								<td><strong class="text-success">Online</strong></td>
								<td><i class="fa fa-link"></i></td>
								<td><a href="https://www.google.com/" target="_blank">Link</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

		</div> <!-- /.row -->
	</div> <!-- /.container-fluid -->
</body>
</html>
