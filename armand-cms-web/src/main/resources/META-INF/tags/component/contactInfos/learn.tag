<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.design.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<div class="row">
	<c:forEach items="${designComponent.contentModels}" var="contactInfoItem">
		<div class="${designComponent.itemsLayout.cssClass}">
			<div class="contactInfo">
				<div class="map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2981.890742874909!2d${contactInfoItem.latitude}!3d${contactInfoItem.longitude}!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zNDHCsDM4JzExLjQiTiAyMsKwMjgnMDMuMiJF!5e0!3m2!1sen!2sus!4v1459983644082"
						width="100%" height="450" style="border: none;">
					</iframe>
				</div>
		
				<div class="contact">
					<div class="contact-part">
						<i class="fa fa-home cms-color-text-background"></i>
						<div>
							<p>
								<vcms:localText value="${contactInfoItem.address1}" />
								<br>
								<vcms:localText value="${contactInfoItem.address2}" />
							</p>
						</div>
					</div>
		
					<div class="contact-part">
						<i class="fa fa-phone cms-color-text-background"></i>
						<div>
							<p>
								${contactInfoItem.phone1}<br>${contactInfoItem.phone2}
							</p>
						</div>
					</div>
		
					<div class="contact-part">
						<i class="fa fa-envelope cms-color-text-background"></i>
						<div>
							<p>
								<a href="mailto:${contactInfoItem.email}">${contactInfoItem.email}</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>