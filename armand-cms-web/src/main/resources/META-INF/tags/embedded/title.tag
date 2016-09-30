<%@ tag body-content="scriptless" %>
<%@ attribute name="title" type="com.vcms.content.model.Title" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>


<div class="${title.align.textCssClass}">
	<h1><vcms:localText value="${title.text}" /></h1>
</div>