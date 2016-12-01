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
		
		<h2 class="page-header">Websites</h2>
		<a href="#" class="btn btn-success pull-right"><i class="fa fa-plus"></i> Add</a>
	
		<div class="row">
			
			<div class="col-md-2 website-teaser">
				<div class="thumbnail">
					<div class="caption">
						<div class="website-name">
							<img src="http://placehold.it/26x26" alt="Website Logo">
							<h4 class="inline"><a href="#">Website Name</a></h4>
						</div>
						<table class="table">
							<tr>
								<td><i class="fa fa-building"></i></td>
								<td colspan="3">Company Name</td>
							</tr>
							<tr>
								<td><i class="fa fa-cube"></i></td>
								<td>Businesse</td>
								<td><i class="fa fa-file-powerpoint-o"></i></td>
								<td>Pages: 10</td>
							</tr>
							<tr>
								<td><i class="fa fa-leaf"></i></td>
								<td>Online</td>
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
