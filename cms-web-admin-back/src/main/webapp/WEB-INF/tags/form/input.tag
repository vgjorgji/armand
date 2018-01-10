<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="label" type="java.lang.String" required="true"%>
<%@ attribute name="type" type="java.lang.String" required="false"%>
<%@ attribute name="labelClass" type="java.lang.String" required="false"%>
<%@ attribute name="controlClass" type="java.lang.String" required="false"%>

<div class="form-group">
	<label class="col-md-${empty labelClass ? '3' : labelClass} control-label" for="${id}">${label}</label>
	<div class="col-md-${empty controlClass ? '6' : controlClass}">
		<input type="${empty type ? 'text' : type}" class="form-control" id="${id}" placeholder="${label}" 
				data-group="${group}" data-field="true" value="{{${field}}}">
	</div>
</div>