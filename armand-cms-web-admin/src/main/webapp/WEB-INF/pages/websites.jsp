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
		<div class="row">
			
			<div class="col-md-2">
				<div class="thumbnail">
					<p>Company Name</p>
					<img src="http://placehold.it/185x185" alt="Website Logo">
					<div class="caption">
						<h4>Website Name</h4>
						<table class="table">
							<tbody>
								<tr>
									<td><a href="#">Edit</a></td>
									<td><i class="fa fa-circle text-success"></i></td>
								</tr>
								<tr>
									<td><a href="#">Design</a></td>
									<td><i class="fa fa-circle text-success"></i></td>
								</tr>
								<tr>
									<td><a href="#">Review Design</a></td>
									<td><i class="fa fa-circle text-warning"></i></td>
								</tr>
								<tr>
									<td><a href="#">Write Content</a></td>
									<td><i class="fa fa-circle text-danger"></i></td>
								</tr>
								<tr>
									<td><a href="#">Review Content</a></td>
									<td><i class="fa fa-circle text-danger"></i></td>
								</tr>
								<tr>
									<td><a href="#">Go Live!</a></td>
									<td><i class="fa fa-circle text-danger"></i></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div> <!-- /.row -->
	</div> <!-- /.container-fluid -->
</body>
</html>
