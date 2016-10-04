<%@ tag body-content="scriptless" %>
<%@ attribute name="website" type="com.vcms.website.model.Website" required="true" %>
<%@ attribute name="websiteView" type="com.vcms.website.model.WebsiteView" required="true" %>
<%@ attribute name="page" type="com.vcms.website.model.Page" required="true" %>
<%@ attribute name="designComponent" type="com.vcms.design.model.DesignComponent" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="e" uri="http://www.vcms.com/tags/embedded" %>


<nav class="navbar" role="navigation">
	<div class="container">
	
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav cms-color-h1">
			
				<c:forEach items="${designComponent.contentModels}" var="mainNavItem">
					<li style="width: ${100.0 / designComponent.contentModels.size()}%"
							<c:if test="${not empty mainNavItem.navItems}"> class="dropdown auto-expand"</c:if>>
							
						<e:linkNormal link="${mainNavItem.link}" showCaret="${not empty mainNavItem.navItems}" />
						<c:if test="${not empty mainNavItem.navItems}">
							<ul class="dropdown-menu" role="menu">
							
								<c:forEach items="${mainNavItem.navItems}" var="navItem">
									<li <c:if test="${not empty navItem.subNavItems}"> class="dropdown-submenu"</c:if>>
									
										<e:linkNormal link="${navItem.link}" />
										<c:if test="${not empty navItem.subNavItems}"> 
											<ul class="dropdown-menu submenu" role="menu">
												<c:forEach items="${navItem.subNavItems}" var="subNavItem">
													<li>
														<e:linkNormal link="${subNavItem.link}" />
													</li>
												</c:forEach>
											</ul>
										</c:if>
										
									</li>
								</c:forEach>
								
							</ul>
						</c:if>
						
					</li>
				</c:forEach>
				
			</ul>
		</div>
		
	</div>
</nav>
