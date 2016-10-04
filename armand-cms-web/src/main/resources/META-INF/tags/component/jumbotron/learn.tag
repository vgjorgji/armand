<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div id="jumbotron-${designComponent.id}" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<c:forEach items="${designComponent.contentModels}" varStatus="status">
			<li data-target="#jumbotron-${designComponent.id}" data-slide-to="${status.index}" 
					<c:if test="${status.index eq 0}"> class="active" </c:if>>
			</li>
		</c:forEach>
	</ol>

	<!-- Wrapper for slides -->
	<div class="carousel-inner" role="listbox">
		<c:forEach items="${designComponent.contentModels}" var="jumbItem" varStatus="status">
			<div class="item <c:if test="${status.index eq 0}"> active </c:if>">
				<div class="img-wrap">
					<e:media media="${jumbItem.paragraph.media}" />
				</div>
				<div class="carousel-caption ${jumbItem.paragraph.align.textCssClass}">
					<c:if test="${not jumbItem.title.text.isEmpty()}">
						<h3 class="cms-color-text ${jumbItem.title.align.textCssClass}">
							<vcms:localText value="${jumbItem.title.text}" />
						</h3>
					</c:if>
					<c:if test="${not jumbItem.paragraph.text.isEmpty()}">
						<p class="cms-color-text ${jumbItem.paragraph.align.textCssClass}">
							<vcms:localText value="${jumbItem.paragraph.text}" />
						</p>
					</c:if>
					<c:if test="${not empty jumbItem.paragraph.link}">
						<div class="${jumbItem.paragraph.align.floatCssClass}">
							<e:link link="${jumbItem.paragraph.link}" />
						</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
</div>