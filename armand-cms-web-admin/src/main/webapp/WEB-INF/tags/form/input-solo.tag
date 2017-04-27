<%@ tag body-content="scriptless"%>
<%@ attribute name="id" type="java.lang.String" required="true"%>
<%@ attribute name="field" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>
<%@ attribute name="placeholder" type="java.lang.String" required="true"%>

<input type="text" class="form-control" id="${id}" placeholder="${placeholder}" 
		data-group="${group}" data-field="true" value="{{${field}}}">