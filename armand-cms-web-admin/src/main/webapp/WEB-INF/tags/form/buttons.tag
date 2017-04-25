<%@ tag body-content="scriptless"%>
<%@ attribute name="pageUrl" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="spinnerLocation" type="java.lang.String" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
	<div class="col-md-offset-3 col-md-6">
		<button type="button" class="btn btn-default" id="reset"
				data-url="${pageUrl}/load" 
				data-method="GET" 
				<c:if test="${not empty spinnerLocation}">
					data-spinner="true"
					data-spinner-location="${spinnerLocation}"
				</c:if>>
			Reset
		</button>
		<button type="submit" class="btn btn-primary" id="submit"
				data-url="${pageUrl}/save" 
				data-method="POST" 
				data-json="true"
				data-group="${group}"
				<c:if test="${not empty spinnerLocation}">
					data-spinner="true"
				</c:if>>
			Save
		</button>
	</div>
</div>