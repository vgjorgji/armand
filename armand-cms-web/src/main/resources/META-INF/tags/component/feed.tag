<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="feed" uri="http://www.vcms.com/tags/component/feed"%>


<c:choose>
	<c:when test="${designComponent.componentStyle eq 'Learn'}">
		<feed:learn website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
</c:choose>
