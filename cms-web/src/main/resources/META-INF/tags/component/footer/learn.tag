<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="footer-wrap cms-color-text cms-color-background">
	<div class="container">
		<div class="col-md-6 footer-left">
			<ul>
				<c:forEach items="${designComponent.contentModels}" var="footerItem">
					<li> <e:link link="${footerItem.link}" /> </li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-6 footer-right">
			© 2016 ${website.name}. All Rights Reserved | Design by <a href="mailto:vlatko.gmk@gmail.com">Vlado Gjorgjiev</a>
		</div>
	</div>
</div>