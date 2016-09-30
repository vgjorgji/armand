<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.design.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.FeedDesignComponent" required="true" %>
<%@ attribute name="feedItem" type="com.vcms.content.model.FeedItem" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="vapi" uri="http://www.vcms.com/tags/vapi" %>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="feed feed-album">
	<a href="<c:url value="${feedItem.link.url}" /> " class="img-wrap">
		<e:media media="${feedItem.media}" />
		<c:if test="${designComponent.feedItemLayout.categories}">
			<c:forEach items="${feedItem.categories.models}" var="category">
				<vapi:category category="${category}" />
			</c:forEach>
		</c:if>
		<c:if test="${true}">
			<h3 class="cms-color-text"><vcms:localText value="${feedItem.title}" /></h3>
		</c:if>
	</a>
	
	<c:if test="${designComponent.feedItemLayout.text}">
		<p><vcms:localText value="${feedItem.infoText}" /> </p>
	</c:if>
	
	<c:if test="${designComponent.feedItemLayout.link || designComponent.feedItemLayout.hashTags}">
		<div class="row">
			<c:if test="${designComponent.feedItemLayout.link and not designComponent.feedItemLayout.hashTags}">
				<div class="col-md-12">
					<e:link link="${feedItem.link}" />
				</div>
			</c:if>
			<c:if test="${not designComponent.feedItemLayout.link and designComponent.feedItemLayout.hashTags}">
				<div class="col-md-12">
					<vapi:hashTags hashTags="${feedItem.hashTags}" />
				</div>
			</c:if>
			<c:if test="${designComponent.feedItemLayout.link and designComponent.feedItemLayout.hashTags}">
				<div class="col-md-6">
					<e:link link="${feedItem.link}" />
				</div>
				<div class="col-md-6">
					<vapi:hashTags hashTags="${feedItem.hashTags}" />
				</div>
			</c:if>
		</div>
	</c:if>
	
	<c:if test="${designComponent.feedItemLayout.stats}">
		<hr />
		<ul class="stats cms-color-p">
			<li>
				<i class="fa fa-clock-o"></i>
				<vcms:localDuration value="${feedItem.changedDate}" />
			</li>
			<li>
				<i class="fa fa-calendar"></i>
				<vcms:localDate value="${feedItem.changedDate}" />
			</li>
			<li>
				<i class="fa fa-comment"></i>
				${feedItem.comments.getSize()} Comments
			</li>
			<li>
				<i class="fa fa-eye"></i>
				1.128 views
			</li>
		</ul>
		<ul class="stats cms-color-p">
			<li>
				<i class="fa fa-globe"></i>
				<span><vcms:localText value="${feedItem.location}" /></span>
			</li>
		</ul>
	</c:if>
	
</div>