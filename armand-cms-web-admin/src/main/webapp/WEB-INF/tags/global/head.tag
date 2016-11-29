<%@ tag body-content="scriptless" %>
<%@ attribute name="title" type="java.lang.String" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- css -->
<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-3.3.6.min.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/static/css/bootstrap-theme-3.3.6.min.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/static/css/fontawesome.min.css"/>" type="text/css" />
<link rel="stylesheet" href="<c:url value="/static/css/site.css"/>" type="text/css" />

<!-- Scripts -->
<script type="text/javascript" src="<c:url value="/static/js/jquery-1.12.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min-3.3.6.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/site.js"/>"></script>

<!-- Title -->
<title>${title}</title>
</head>