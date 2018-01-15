<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.FeedDesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="learn" uri="http://www.vcms.com/tags/component/feed/learn" %>


<div class="row">
	<c:forEach items="${designComponent.contentModels}" var="feedItem">
		<div class="${designComponent.itemsLayout.cssClass}">
			<c:choose>
				<c:when test="${feedItem.page.feedType eq 'Aricle'}">
					<learn:article website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Album'}">
					<learn:album website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Event'}">
					<learn:event website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Survey'}">
					<learn:survey website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Quiz'}">
					<learn:quiz website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Research'}">
					<learn:research website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'PublicProcurement'}">
					<learn:publicProcurement website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Project'}">
					<learn:project website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
				<c:when test="${feedItem.page.feedType eq 'Partner'}">
					<learn:partner website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" feedItem="${feedItem}" />
				</c:when>
			</c:choose>
		</div>
	</c:forEach>
</div>
