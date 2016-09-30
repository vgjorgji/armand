package com.vcms.user.model;

import java.util.List;
import java.util.Set;

import com.vcms.localization.model.LocalText;
import com.vcms.persist.model.HistoryModel;
import com.vcms.utils.Utils;

public class User extends HistoryModel {
	
	public static final Set<Role> DEFAULT_ROLES = Utils.asSet(Role.CMSMember, Role.Member);

	private String username;
	private String password;
	private boolean enabled;
	
	private LocalText firstName;
	private LocalText lastName;
	private String email;
	
	private List<UserWebsite> userWebsites;
	
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

	public List<UserWebsite> getUserWebsites() {
		return userWebsites;
	}

	public void setUserWebsites(List<UserWebsite> userWebsites) {
		this.userWebsites = userWebsites;
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
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
