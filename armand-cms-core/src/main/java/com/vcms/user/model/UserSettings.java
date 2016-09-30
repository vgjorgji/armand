package com.vcms.user.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vcms.localization.model.Language;
import com.vcms.website.model.Website;

public class UserSettings implements UserDetails {
	
	private static final long serialVersionUID = 8749204172625676869L;
	
	private Visitor visitor;
	private User user;
	private List<UserGroup> groups = Collections.emptyList();
	
	// selecting
	private Website selectedWebsite;
	private UserWebsite selectedUserWebsite;
	
	// resolving
	private Set<Role> roles = Visitor.DEFAULT_ROLES;
	private Language language = Visitor.DEFAULT_LANGUAGE;
	
	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<UserGroup> groups) {
		this.groups = groups;
	}
	
	public Website getSelectedWebsite() {
		return selectedWebsite;
	}

	public void setSelectedWebsite(Website selectedWebsite) {
		this.selectedWebsite = selectedWebsite;
	}

	public UserWebsite getSelectedUserWebsite() {
		return selectedUserWebsite;
	}

	public void setSelectedUserWebsite(UserWebsite userWebsite) {
		selectedUserWebsite = userWebsite;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	/**
	 * Settings resolving.
	 */
	public void resolveSettings() {
		resolveRoles();
		resolveLanguage();
	}
	
	private void resolveRoles() {
		roles = null;
		if (selectedUserWebsite != null) {
			roles = selectedUserWebsite.getUserRolesForWebsite();
		}
		
		// fall-back
		if (CollectionUtils.isEmpty(roles)) {
			roles = Visitor.DEFAULT_ROLES;
		}
	}

	private void resolveLanguage() {
		language = null;
		if (selectedUserWebsite != null) {
			language = selectedUserWebsite.getUserLanguageForWebsite();
		}

		// fall-back
		if (language == null) {
			language = Visitor.DEFAULT_LANGUAGE;
		}
	}
	

	@Override
	public String getUsername() {
		return user != null ? user.getUsername() : null;
	}
	
	@Override
	public String getPassword() {
		return user != null ? user.getPassword() : null;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public boolean isVisitor() {
		return roles.contains(Role.Visitor);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(Role.values());
	}

	@Override
	public boolean isEnabled() {
		return user != null ? user.isEnabled() : false;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

}
