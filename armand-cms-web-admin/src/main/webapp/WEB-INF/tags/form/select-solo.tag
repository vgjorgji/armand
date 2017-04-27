<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="fieldValues" type="java.lang.String" required="false"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="options" type="java.lang.String" required="true"%>
<%@ attribute name="optionValue" type="java.lang.String" required="false"%>
<%@ attribute name="optionText" type="java.lang.String" required="false"%>
<%@ attribute name="multi" type="java.lang.Boolean" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<select class="form-control" id="${id}" data-group="${group}"
		data-field="true" ${multi ? 'multiple' : ''}
		<c:if test="${empty fieldValues}"> data-selected="{{${field}}}" </c:if>
		<c:if test="${not empty fieldValues}"> data-selected="{{#${field}}}{{${fieldValues}}},{{/${field}}}"</c:if>>
{{#${options}}}
	<option value="{{${empty optionValue ? '.' : optionValue}}}">
		{{${empty optionText ? (empty optionValue ? '.' : optionValue) : optionText}}}
	</option>
{{/${options}}}
</select>