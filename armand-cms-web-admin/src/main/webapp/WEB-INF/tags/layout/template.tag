<%@ tag body-content="scriptless" %>
<%@ attribute name="title" type="java.lang.String" required="true" %>
<%@ attribute name="select" type="java.lang.String" required="true" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="global" tagdir="/WEB-INF/tags/global"%>

<!DOCTYPE html>
<html lang="en">
<global:head title="${title}" />

<body>
	<global:navigation select="${select}" />
	
	<div class="main-wrap">
		<jsp:doBody />
	</div>
</body>