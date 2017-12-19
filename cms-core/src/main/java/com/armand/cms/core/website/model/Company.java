package com.armand.cms.core.website.model;

import com.armand.cms.core.persist.model.HistoryModel;

public class Company extends HistoryModel {

	private long contactUserId;
	private String name;
	private String address1;
	private String address2;
	private String phone1;
	private String phone2;
	private String email;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getPhone1() {
		return phone1;
	}
	
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public String getPhone2() {
		return phone2;
	}
	
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactUserId() {
		return contactUserId;
	}

	public void setContactUserId(long contactUserId) {
		this.contactUserId = contactUserId;
	}
	
}
