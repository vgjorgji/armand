<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<div class="row">
	<c:forEach items="${designComponent.contentModels}" var="highlightItem">
		<div class="${designComponent.itemsLayout.cssClass} highlight-item cms-color-select">
			<div class="highlight-text">
				<h3><vcms:localText value="${highlightItem.title}" /> </h3>
				<p><vcms:localText value="${highlightItem.text}" /></p>
			</div>
			<div class="highlight-icon">
				<span class="cms-color-text cms-color-background ${highlightItem.icon.cssClass}" aria-hidden="true"></span>
			</div>
		</div>
	</c:forEach>
</div>