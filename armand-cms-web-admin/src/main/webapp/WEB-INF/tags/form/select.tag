<%@ tag body-content="scriptless"%>
<%@ attribute name="controlClass" type="java.lang.String" required="false"%>
<%@ attribute name="labelClass" type="java.lang.String" required="false"%>
<%@ attribute name="label" type="java.lang.String" required="true"%>
<%@ attribute name="options" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>

<div class="form-group">
	<label class="col-md-${empty labelClass ? '3' : labelClass} control-label" for="${id}">${label}</label>
	<div class="col-md-${empty controlClass ? '6' : controlClass}">
		<select class="form-control" id="${id}" data-group="${group}"
				data-field="true" data-selected="{{${field}}}">
{{#${options}}}<option>{{.}}</option>{{/${options}}}
		</select>
	</div>
</div>