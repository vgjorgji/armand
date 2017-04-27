<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="submitUrl" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="spinnerLocation" type="java.lang.String" required="false"%>
<%@ attribute name="label" type="java.lang.String" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<button type="submit" class="btn btn-default" id="${id}"
		data-url="${submitUrl}" 
		data-method="POST" 
		data-json="true"
		data-group="${group}"
		<c:if test="${not empty spinnerLocation}">
			data-spinner="true"
			data-spinner-location="${spinnerLocation}"
		</c:if>>
	${label}
</button>