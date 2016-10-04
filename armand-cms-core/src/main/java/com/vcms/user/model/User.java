package com.vcms.user.model;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;

public class User extends HistoryModel {
	
	private String username;
	private String password;
	private boolean enabled;
	
	private LocalText firstName;
	private LocalText lastName;
	private String email;
	private String phone;
	private Language language;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public LocalText getFirstName() {
		return firstName;
	}

	public void setFirstName(LocalText firstName) {
		this.firstName = firstName;
	}

	public LocalText getLastName() {
		return lastName;
	}

	public void setLastName(LocalText lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
}
