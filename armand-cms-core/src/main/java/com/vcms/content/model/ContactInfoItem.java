package com.vcms.content.model;

import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.ContentModel;

public class ContactInfoItem extends ContentModel {
	
	private double longitude;
	private double latitude;
	private LocalText address1;
	private LocalText address2;
	private String phone1;
	private String phone2;
	private String email;
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public LocalText getAddress1() {
		return address1;
	}

	public void setAddress1(LocalText address1) {
		this.address1 = address1;
	}

	public LocalText getAddress2() {
		return address2;
	}

	public void setAddress2(LocalText address2) {
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
	
}
