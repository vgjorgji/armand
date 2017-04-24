<%@ tag body-content="scriptless"%>
<%@ attribute name="pageUrl" type="java.lang.String" required="true"%>
<%@ attribute name="group" type="java.lang.String" required="true"%>

<div class="form-group">
	<div class="col-md-offset-3 col-md-6">
		<button type="button" class="btn btn-default" id="reset"
				data-url="${pageUrl}/load" 
				data-method="GET" 
				data-spinner="true"
				data-spinner-location="#submit">
			Reset
		</button>
		<button type="submit" class="btn btn-primary" id="submit"
				data-url="${pageUrl}/save" 
				data-method="POST" 
				data-json="true"
				data-group="${group}"
				data-spinner="true">
			Save
		</button>
	</div>
</div>