package com.vcms.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.vcms.user.model.UserSettings;
import com.vcms.user.model.Visitor;

public class VisitorFilter extends AnonymousAuthenticationFilter {
	
	private static final String VISITOR_SESSION_ATTRIBUTE = "SPRING_SECURITY_VISITOR";
	private static final String USERSETTINGS_SESSION_ATTRIBUTE = "userSettings";
	
	private WebAuthenticationDetailsSource webAuthenticationDetailsSource = new WebAuthenticationDetailsSource();
	private String key;

	public VisitorFilter(String key) {
		super(key);
		this.key = key;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		HttpServletRequest request = (HttpServletRequest) req;
		
		// no authentication
		if (authentication == null) {
			
			// find/create visitor settings
			UserSettings visitorSettings = getFromSession(request);
			if (visitorSettings == null) {
				visitorSettings = createVisitorSettings(request);
				putInSession(request, visitorSettings);
			}
			
			// set authentication
			authentication = createVisitorAuthentication(request, visitorSettings);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		} else {
			// has authentication, merge visitor
			UserSettings visitorSettings = getFromSession(request);
			if (visitorSettings != null) {
				UserSettings userSettings = (UserSettings) authentication.getPrincipal();
				userSettings.setVisitor(visitorSettings.getVisitor());
				removeFromSession(request);
				exposeInSession(request, userSettings);
			}
		}
		
		chain.doFilter(req, res);
	}
	
	private UserSettings createVisitorSettings(HttpServletRequest request) {
		// visitor
		Visitor visitor = new Visitor();
		visitor.setStartDate(new Date());
		visitor.setRemoteAddress(request.getRemoteAddr());
		visitor.setRemoteHost(request.getRemoteHost());
		visitor.setSessionId(request.getSession().getId());   // session creation
		
		// user settings for visitor
		UserSettings userSettings = new UserSettings();
		userSettings.setVisitor(visitor);
		return userSettings;
	}
	
	private Authentication createVisitorAuthentication(HttpServletRequest request, UserSettings userSettings) {
		AnonymousAuthenticationToken auth = new AnonymousAuthenticationToken(key, userSettings, getAuthorities());
		auth.setDetails(webAuthenticationDetailsSource.buildDetails(request));
		return auth;
	}
	
	private UserSettings getFromSession(HttpServletRequest request) {
		return (UserSettings) request.getSession().getAttribute(VISITOR_SESSION_ATTRIBUTE);
	}
	
	private void putInSession(HttpServletRequest request, UserSettings visitorSettings) {
		request.getSession().setAttribute(VISITOR_SESSION_ATTRIBUTE, visitorSettings);
	}
	
	private void exposeInSession(HttpServletRequest request, UserSettings userSettings) {
		request.getSession().setAttribute(USERSETTINGS_SESSION_ATTRIBUTE, userSettings);
	}
	
	private void removeFromSession(HttpServletRequest request) {
		request.getSession().removeAttribute(VISITOR_SESSION_ATTRIBUTE);
	}

}
