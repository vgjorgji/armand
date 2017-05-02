<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="label" type="java.lang.String" required="true"%>
<%@ attribute name="labelClass" type="java.lang.String" required="false"%>
<%@ attribute name="controlClass" type="java.lang.String" required="false"%>

<div class="form-group">
	<label class="col-md-${empty labelClass ? '3' : labelClass} control-label" for="${id}">${label}</label>
	<div class="col-md-${empty controlClass ? '6' : controlClass}">
		<div class="checkbox">
			<label>
				<input type="checkbox" id="${id}"
						data-group="${group}" data-field="true" data-selected="{{${field}}}">
			</label>
		</div>
	</div>
</div>