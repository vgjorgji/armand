package com.vcms.web.admin.model;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private String redirect;
	private String submitForm;
	private Map<String, Template> templates = new HashMap<>();
	private Map<String, Message> messages = new HashMap<>();
	private Map<String, Snippet> snippets = new HashMap<>();
	
	public String getRedirect() {
		return redirect;
	}
	
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
	public String getSubmitForm() {
		return submitForm;
	}
	
	public void setSubmitForm(String submitForm) {
		this.submitForm = submitForm;
	}
	
	public void setMainTemplateData(Object mainTemplateData) {
		addTemplate(new Template("main", mainTemplateData));
	}
	
	public void addTemplate(Template template) {
		templates.put(template.getId(), template);
	}
	
	public Map<String, Template> getTemplates() {
		return templates;
	}

	public void addMessage(String key, Message message) {
		messages.put(key, message);
	}
	
	public Map<String, Message> getMessages() {
		return messages;
	}
	
	public void addSnippet(String key, Snippet snippet) {
		snippets.put(key, snippet);
	}
	
	public Map<String, Snippet> getSnippets() {
		return snippets;
	}
}
