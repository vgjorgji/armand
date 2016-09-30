<%@ tag body-content="scriptless" %>
<%@ attribute name="hashTags" type="com.vcms.hashtag.model.HashTags" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="vcms" uri="http://www.vcms.com/tags/vcms" %>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<div class="tags">
	<c:forEach items="${hashTags.models}" var="hashTag">
		<a href="#" class="label cms-color-text-background">#<vcms:localText value="${hashTag.name}" /></a>
	</c:forEach>
</div>
