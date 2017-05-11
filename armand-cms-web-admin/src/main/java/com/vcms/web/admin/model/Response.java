package com.vcms.web.admin.model;

import java.util.HashMap;
import java.util.Map;

public class Response {
	
	private String redirect;
	private String clickElement;
	private Map<String, Fragment> fragments = new HashMap<>();
	private Map<String, Message> messages = new HashMap<>();
	private Map<String, Snippet> snippets = new HashMap<>();
	
	public String getRedirect() {
		return redirect;
	}
	
	public void redirect(String redirect) {
		this.redirect = redirect;
	}

	public String getClickElement() {
		return clickElement;
	}

	public void setClickElement(String clickElement) {
		this.clickElement = clickElement;
	}

	public Fragment fragmentMain() {
		return fragment("fragment-main").replaceId("main");
	}
	
	public Fragment fragmentDetails() {
		return fragment("fragment-details").replaceId("details");
	}
	
	public Fragment fragmentLvl1() {
		return fragment("fragment-lvl-1").replaceId("lvl-1");
	}
	
	public Fragment fragmentLvl2() {
		return fragment("fragment-lvl-2").replaceId("lvl-2");
	}
	
	public Fragment fragmentLvl3() {
		return fragment("fragment-lvl-3").replaceId("lvl-3");
	}
	
	public Fragment fragment(String fragmentId) {
		Fragment fragment = null;
		if (fragments.containsKey(fragmentId)) {
			fragment = fragments.get(fragmentId);
		} else {
			fragment = new Fragment(fragmentId);
			fragments.put(fragmentId, fragment);
		}
		return fragment;
	}
	
	public Map<String, Fragment> getFragments() {
		return fragments;
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
