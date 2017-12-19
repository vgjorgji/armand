package com.armand.cms.web.conf;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Custom view resolver. 
 * It has some additional functionality regarding the standard spring view resolver:
 * - If the view is Redirect, then make the 'exposeModelAttributes' configurable through spring
 */
public class CustomViewResolver extends InternalResourceViewResolver {

	private boolean exposeModelAttributes = true;
	
	@Override
	protected View createView(String viewName, Locale locale) throws Exception {
		View createdView = super.createView(viewName, locale);
		if (createdView instanceof RedirectView) {
			RedirectView redirectView = (RedirectView) createdView;
			redirectView.setExposeModelAttributes(isExposeModelAttributes());
		}
		return createdView;
	}
	
	
	public boolean isExposeModelAttributes() {
		return exposeModelAttributes;
	}

	public void setExposeModelAttributes(boolean exposeModelAttributes) {
		this.exposeModelAttributes = exposeModelAttributes;
	}
}
