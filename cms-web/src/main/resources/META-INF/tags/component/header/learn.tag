<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<nav class="navbar navbar-default cms-color-background" role="navigation">
	<div class="container">
	
		<!-- Web site Name -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-header-${designComponent.id}">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand cms-color-text" href="<c:url value="/" />">${website.name}</a>
		</div>
		
		<div class="navbar-collapse collapse" id="navbar-header-${designComponent.id}" style="height: 1px;">
			<ul class="nav navbar-nav">
			
				<!-- Notifications -->
				<c:if test="${website.cmsPackage.optionNotification}">
					<li class="dropdown auto-expand">
						<a href="#" class="dropdown-toggle cms-color-text" data-toggle="dropdown">
							<i class="fa fa-list"></i><span>Notifications</span><span class="badge btn-danger">1</span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="courses.html">Note 1</a>
							</li>
							<li>
								<a href="courses.html">Note 2</a>
							</li>
						</ul>
					</li>
				</c:if>
				
				<!-- Login -->
				<c:if test="${website.cmsPackage.optionLogin}">
					<li class="dropdown">
						<a href="login.html" class="cms-color-text">
							<i class="fa fa-user"></i><span>Login</span>
						</a>
					</li>
				</c:if>
				
				<!-- Languages -->
				<c:if test="${website.cmsPackage.optionLanguage}">
					<li class="dropdown auto-expand">
						<a href="#" class="dropdown-toggle cms-color-text" data-toggle="dropdown">
							<i class="fa fa-globe"></i><span>${website.primaryLanguage}</span>
						</a>
						<ul class="dropdown-menu">
							<c:forEach items="${website.languages}" var="language">
								<li>
									<a href="#">
										<span><i class="flag ${language.flagCss}"></i><span>${language}</span></span>
									</a>
								</li>
							</c:forEach>
						</ul>
					</li>
				</c:if>
				
				<!-- Search -->
				<c:if test="${website.cmsPackage.optionSearch}">
					<li class="search-form">
						<form>
							<input type="text" class="search-text" name="s" placeholder="Search...">
							<button type="submit" class="search-submit">
								<p class="fa fa-search"></p>
							</button>
						</form>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>