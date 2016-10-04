<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="row">
	<c:forEach items="${designComponent.contentModels}" var="titleItem">
		<div class="${designComponent.itemsLayout.cssClass}">
			<e:title title="${titleItem.title}" />
		</div>
	</c:forEach>
</div>
