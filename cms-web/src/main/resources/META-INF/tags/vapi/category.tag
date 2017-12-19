<%@ tag body-content="scriptless" %>
<%@ attribute name="category" type="com.vcms.classify.model.Category" required="true" %>

<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<span class="cms-label" 
		style="background-color: ${category.color.backgroundHex}; color: ${category.color.textHex}">
	<vcms:localText value="${category.name}" />
</span>

