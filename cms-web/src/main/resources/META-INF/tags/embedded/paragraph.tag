<%@ tag body-content="scriptless" %>
<%@ attribute name="paragraph" type="com.vcms.content.model.Paragraph" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="paragraph">
	<c:if test="${empty paragraph.media}">
		<div class="row">
			<div class="col-md-12 ${paragraph.align.textCssClass}">
				<vcms:localText value="${paragraph.text}" />
			</div>
		</div>
	</c:if>
	
	<c:if test="${not empty paragraph.media}">
		<c:choose>
			<c:when test="${paragraph.layout eq 'TextRightMediaLeft'}">
				<div class="row">
					<div class="col-md-6">
						<e:media media="${paragraph.media}" />
					</div>
					<div class="col-md-6 ${paragraph.align.textCssClass}">
						<vcms:localText value="${paragraph.text}" />
						<e:link link="${paragraph.link}" />
					</div>
				</div>
			</c:when>
			<c:when test="${paragraph.layout eq 'TextLeftMediaRight'}">
				<div class="row">
					<div class="col-md-6 ${paragraph.align.textCssClass}">
						<vcms:localText value="${paragraph.text}" />
						<e:link link="${paragraph.link}" />
					</div>
					<div class="col-md-6">
						<e:media media="${paragraph.media}" />
					</div>
				</div>
			</c:when>
			<c:when test="${paragraph.layout eq 'TextBottomMediaTop'}">
				<div class="row">
					<div class="col-md-12">
						<e:media media="${paragraph.media}" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 ${paragraph.align.textCssClass}">
						<vcms:localText value="${paragraph.text}" />
						<e:link link="${paragraph.link}" />
					</div>
				</div>
			</c:when>
			<c:when test="${paragraph.layout eq 'TextTopMediaBottom'}">
				<div class="row">
					<div class="col-md-12 ${paragraph.align.textCssClass}">
						<vcms:localText value="${paragraph.text}" />
						<e:link link="${paragraph.link}" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<e:media media="${paragraph.media}" />
					</div>
				</div>
			</c:when>
			<c:when test="${paragraph.layout eq 'TextInFrontMediBehind'}">
				<div class="row">
					<div class="col-md-12 media-behind ${paragraph.align.textCssClass}">
						<e:media media="${paragraph.media}" />
						<vcms:localText value="${paragraph.text}" />
						<e:link link="${paragraph.link}" />
					</div>
				</div>
			</c:when>
		</c:choose>
	</c:if>
</div>

