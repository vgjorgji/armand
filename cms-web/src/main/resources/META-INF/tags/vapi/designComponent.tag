<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="component" uri="http://www.vcms.com/tags/component"%>


<c:choose>
	<%-- mandatory --%>
	<c:when test="${designComponent.component eq 'Header'}">
		<component:header website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Navigation'}">
		<component:navigation website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Footer'}">
		<component:footer website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	
	<%-- content --%>
	<c:when test="${designComponent.component eq 'Titles'}">
		<component:titles website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Paragraphs'}">
		<component:paragraphs website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Medias'}">
		<component:medias website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Links'}">
		<component:links website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	
	<%-- standard --%>
	<c:when test="${designComponent.component eq 'Jumbotron'}">
		<component:jumbotron website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Highlights'}">
		<component:highlights website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'ContactInfos'}">
		<component:contactInfos website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'ContactForms'}">
		<component:contactForms website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	<c:when test="${designComponent.component eq 'Feed'}">
		<component:feed website="${website}" websiteView="${websiteView}" page="${page}" designComponent="${designComponent}" />
	</c:when>
	
</c:choose>
<div class="clearfix"></div>
