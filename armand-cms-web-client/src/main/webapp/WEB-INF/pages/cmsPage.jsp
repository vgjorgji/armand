
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="vapi" uri="http://www.vcms.com/tags/vapi"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<!-- Title -->
		<title>
			${website.name}
			<c:if test="${not page.title.isEmpty()}">
			 | <vcms:localText value="${page.title}" />
			</c:if>
		</title>
		
		<!-- css -->
		<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-3.3.6.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-theme-3.3.6.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/fontawesome.min.css"/>" type="text/css" />
		<link rel="stylesheet" href="<c:url value="/static/css/site.css"/>" type="text/css" />
		
		<!-- font -->
		<c:if test="${websiteView.font eq 'PtSansNarrow'}">
			<link rel="stylesheet" href="<c:url value="/static/css/font-ptsansnarrow.css"/>" type="text/css" />
		</c:if>
		
		<!-- package css -->
		<c:if test="${website.cmsPackage eq 'BASIC'}">
			<link rel="stylesheet" href="<c:url value="/static/css/cmspackage-basic.css"/>" type="text/css" />
		</c:if>
		<c:if test="${website.cmsPackage eq 'DYNAMIC'}">
			<link rel="stylesheet" href="<c:url value="/static/css/cmspackage-dynamic.css"/>" type="text/css" />
		</c:if>
		<c:if test="${website.cmsPackage eq 'BUSINESS'}">
			<link rel="stylesheet" href="<c:url value="/static/css/cmspackage-business.css"/>" type="text/css" />
		</c:if>
		
		<style type="text/css">
			.cms-color-text {
				color: ${websiteView.color.textHex} !important;
			}
			.cms-color-background {
				background-image: none !important;
				background-color: ${websiteView.color.backgroundHex} !important;
			}
			.cms-color-text-background {
				color: ${websiteView.color.backgroundHex} !important;
			}
			.cms-color-select:hover .glyphicon,
			.cms-color-select:hover .fa,
			a:hover,
			.open>a {
				background-image: none !important;
				background-color: ${websiteView.selectColor.backgroundHex} !important;
				color: ${websiteView.selectColor.textHex} !important;
			}
			.cms-color-select:hover .highlight-text {
				border-color: ${websiteView.selectColor.backgroundHex} !important;
			}
			
			html, body {
			    background-color: ${websiteView.style.backgroundHex};
			}
			h1, h2, .cms-color-h1, .cms-color-h1 a {
				color: ${websiteView.style.header1Hex};
			}
			h3, h4, h5, .cms-color-h3, .cms-color-h3 a {
				color: ${websiteView.style.header3Hex};
			}
			p, .cms-color-p, .cms-color-p a  {
				color: ${websiteView.style.paragraphHex};
			}
			input, .cms-color-input, .cms-color-input a  {
				color: ${websiteView.style.inputHex};
			}
		</style>
		
		<!-- Scripts -->
		<script type="text/javascript" src="<c:url value="/static/js/jquery-1.12.1.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min-3.3.6.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/static/js/site.js"/>"></script>
	</head>

	<body>
		<!-- Header -->
		<div class="header-position">
			<c:if test="${not empty pageDesign.getHeaderComponents()}">
				<c:forEach items="${pageDesign.getHeaderComponents()}" var="designComponent">
					<div class="${designComponent.getCssClass()}">
						<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
					</div>
				</c:forEach>
			</c:if>
		</div>
		
		<!-- Top Row -->
		<c:if test="${pageDesign.layout.top and not empty pageDesign.getTopComponents()}">
			<c:forEach items="${pageDesign.getTopComponents()}" var="designComponent">
				<div class="design-component ${designComponent.getCssClass()}" style="background-color: ${designComponent.backgroundColor.hex}">
					<div class="container">
						<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
					</div>
				</div>
			</c:forEach>
		</c:if>
		
		<!-- Main Content background -->
		<div style="background-color: ${pageDesign.getCenterComponentsColor().hex}">
		
			<!-- Main Content -->
			<div class="container">
				<div class="row">
			
					<!-- Left Column -->
					<c:if test="${pageDesign.layout.left}">
						<div class="col-md-4">
							<c:forEach items="${pageDesign.getLeftComponents()}" var="designComponent">
								<div class="design-component ${designComponent.getCssClass()}">
									<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
								</div>
							</c:forEach>
						</div>
					</c:if>
					
					<!-- Center -->
					<div class="${pageDesign.layout.getCenterColumnCss()}">
						<c:forEach items="${pageDesign.getCenterComponents()}" var="designComponent">
							<div class="design-component ${designComponent.getCssClass()}">
								<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
							</div>
						</c:forEach>
					</div>
					
					<!-- Right Column -->
					<c:if test="${pageDesign.layout.right}">
						<div class="col-md-4">
							<c:forEach items="${pageDesign.getRightComponents()}" var="designComponent">
								<div class="design-component ${designComponent.getCssClass()}">
									<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
								</div>
							</c:forEach>
						</div>
					</c:if>
				
				</div>
			</div>
		</div>
		
		<!-- Bottom -->
		<c:if test="${pageDesign.layout.bottom and not empty pageDesign.getBottomComponents()}">
			<div class="container">
				<c:forEach items="${pageDesign.getBottomComponents()}" var="designComponent">
					<div class="design-component ${designComponent.getCssClass()}" style="background-color: ${designComponent.backgroundColor.hex}">
						<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
					</div>
				</c:forEach>
			</div>
		</c:if>
		
		<!-- Footer -->
		<div class="footer-position">
			<c:forEach items="${pageDesign.getFooterComponents()}" var="designComponent">
				<div class="${designComponent.getCssClass()}">
					<vapi:designComponent website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
				</div>
			</c:forEach>
		</div>
	</body>

</html>

