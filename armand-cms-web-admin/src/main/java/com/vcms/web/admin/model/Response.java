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
	
	public void redirect(String redirect) {
		this.redirect = redirect;
	}
	
	public String getSubmitForm() {
		return submitForm;
	}
	
	public void submitForm(String submitForm) {
		this.submitForm = submitForm;
	}
	
	public Template mainTemplate() {
		return template("template-main", "main");
	}
	
	public Template template(String templateId, String replaceId) {
		Template template = null;
		if (templates.containsKey(templateId)) {
			template = templates.get(templateId);
		} else {
			template = new Template(templateId, replaceId);
			templates.put(templateId, template);
		}
		return template;
	}
	
	public Map<String, Template> getTemplates() {
		return templates;
	}

	public Message message(String messageId) {
		Message message = null;
		if (messages.containsKey(messageId)) {
			message = messages.get(messageId);
		} else {
			message = new Message();
			messages.put(messageId, message);
		}
		return message;
	}
	
	public Map<String, Message> getMessages() {
		return messages;
	}
	
	public Snippet snippet(String snippetId) {
		Snippet snippet = null;
		if (snippets.containsKey(snippetId)) {
			snippet = snippets.get(snippetId);
		} else {
			snippet = new Snippet();
			snippets.put(snippetId, snippet);
		}
		return snippet;
	}
	
	public Map<String, Snippet> getSnippets() {
		return snippets;
	}
}
