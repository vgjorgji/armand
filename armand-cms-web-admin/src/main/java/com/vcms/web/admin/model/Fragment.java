package com.vcms.web.admin.model;

import java.util.Map;

public class Fragment {
	
	private String id;                // ID of HTML element containing the fragment
	private String replaceId;         // ID of HTML element to render the outcome fragment in
	private boolean show = true;
	private FragmentData fragmentData = new FragmentData();
	
	public Fragment() {
	}
	
	public Fragment(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getReplaceId() {
		return replaceId;
	}
	
	public Fragment replaceId(String replaceId) {
		this.replaceId = replaceId;
		return this;
	}

	public boolean isShow() {
		return show;
	}

	public Fragment show(boolean show) {
		this.show = show;
		return this;
	}

	public Map<String, Object> getData() {
		return fragmentData.getMap();
	}

	public FragmentData data() {
		return fragmentData;
	}

}
