<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="fieldValues" type="java.lang.String" required="false"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="options" type="java.lang.String" required="true"%>
<%@ attribute name="optionValue" type="java.lang.String" required="false"%>
<%@ attribute name="optionText" type="java.lang.String" required="false"%>
<%@ attribute name="label" type="java.lang.String" required="true"%>
<%@ attribute name="labelClass" type="java.lang.String" required="false"%>
<%@ attribute name="controlClass" type="java.lang.String" required="false"%>
<%@ attribute name="multi" type="java.lang.Boolean" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
	<label class="col-md-${empty labelClass ? '3' : labelClass} control-label" for="${id}">${label}</label>
	<div class="col-md-${empty controlClass ? '6' : controlClass}">
		<select class="form-control" id="${id}" data-group="${group}"
				data-field="true" ${multi ? 'multiple' : ''}
				<c:if test="${empty fieldValues}"> data-selected="{{${field}}}" </c:if>
				<c:if test="${not empty fieldValues}"> data-selected="{{#${field}}}{{${fieldValues}}},{{/${field}}}"</c:if>>
{{#${options}}}
	<option value="{{${empty optionValue ? 'this' : optionValue}}}">
		{{${empty optionText ? (empty optionValue ? 'this' : optionValue) : optionText}}}
	</option>
{{/${options}}}
		</select>
	</div>
</div>