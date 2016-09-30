<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.design.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="row">
	<c:forEach items="${designComponent.contentModels}" var="mediaItem">
		<div class="${designComponent.itemsLayout.cssClass}">
			<e:media media="${mediaItem.media}" />
		</div>
	</c:forEach>
</div>