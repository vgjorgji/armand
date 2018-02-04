<%@ tag body-content="scriptless"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="cancelUrl" type="java.lang.String" required="false"%>
<%@ attribute name="cancelScroll" type="java.lang.String" required="false"%>
<%@ attribute name="resetUrl" type="java.lang.String" required="false"%>
<%@ attribute name="resetScroll" type="java.lang.String" required="false"%>
<%@ attribute name="saveUrl" type="java.lang.String" required="false"%>
<%@ attribute name="saveScroll" type="java.lang.String" required="false"%>
<%@ attribute name="deleteUrl" type="java.lang.String" required="false"%>
<%@ attribute name="deleteScroll" type="java.lang.String" required="false"%>
<%@ attribute name="spinnerLocation" type="java.lang.String" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
	<div class="col-md-offset-3 col-md-6">
		<c:if test="${not empty cancelUrl}">
			<button type="button" class="btn btn-default" id="cancel"
					data-url="${cancelUrl}" 
					data-method="GET" 
					<c:if test="${not empty spinnerLocation}">
						data-spinner="true"
						data-spinner-location="${spinnerLocation}"
					</c:if>
					<c:if test="${not empty cancelScroll}">
						data-scroll="${cancelScroll}"
					</c:if>
					>
				Cancel
			</button>
		</c:if>
		<c:if test="${not empty resetUrl}">
			<button type="button" class="btn btn-default" id="reset"
					data-url="${resetUrl}" 
					data-method="GET" 
					<c:if test="${not empty spinnerLocation}">
						data-spinner="true"
						data-spinner-location="${spinnerLocation}"
					</c:if>
					<c:if test="${not empty resetScroll}">
						data-scroll="${resetScroll}"
					</c:if>
					>
				Reset
			</button>
		</c:if>
		<c:if test="${not empty saveUrl}">
			<button type="submit" class="btn btn-primary" id="submit"
					data-url="${saveUrl}" 
					data-method="POST" 
					data-json="true"
					data-group="${group}"
					<c:if test="${not empty spinnerLocation}">
						data-spinner="true"
					</c:if>
					<c:if test="${not empty saveScroll}">
						data-scroll="${saveScroll}"
					</c:if>
					>
				Save
			</button>
		</c:if>
		<c:if test="${not empty deleteUrl}">
			<button type="submit" class="btn btn-danger pull-right" id="delete"
					data-url="${deleteUrl}" 
					data-method="POST" 
					data-json="true"
					data-group="${group}"
					<c:if test="${not empty spinnerLocation}">
						data-spinner="true"
					</c:if>
					<c:if test="${not empty deleteScroll}">
						data-scroll="${deleteScroll}"
					</c:if>
					>
				Delete
			</button>
		</c:if>
	</div>
</div>