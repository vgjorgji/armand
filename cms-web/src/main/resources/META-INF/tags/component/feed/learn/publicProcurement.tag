<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.FeedDesignComponent" required="true" %>
<%@ attribute name="feedItem" type="com.vcms.content.model.FeedItem" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="vapi" uri="http://www.vcms.com/tags/vapi" %>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="feed feed-publicProcurement">
	Public Procurement
</div>