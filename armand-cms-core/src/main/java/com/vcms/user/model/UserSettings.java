package com.vcms.user.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vcms.localization.model.Language;
import com.vcms.utils.Utils;
import com.vcms.website.model.Website;

public class UserSettings implements UserDetails {
	
	private static final long serialVersionUID = 8749204172625676869L;
	public static final Language DEFAULT_LANGUAGE = Language.English;
	public static final Set<Role> DEFAULT_ROLES = Utils.asSet(Role.Visitor);
	
	// identifiers
	private Visitor visitor;
	private User user;
	
	// select
	private long selectedWebsiteId = -1;
	private WebsiteUser selectedWebsiteUser = null;
	
	// resolve
	private Language language = DEFAULT_LANGUAGE;
	private Set<Role> roles = DEFAULT_ROLES;
	
	public long getId() {
		return hasUser() ? user.getId() : -1;
	}

	public boolean hasUser() {
		return user != null;
	}
	
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

	public long getSelectedWebsiteId() {
		return selectedWebsiteId;
	}
	
	public void setSelectedWebsiteId(Website selectedWebsite) {
		if (selectedWebsite != null) {
			this.selectedWebsiteId = selectedWebsite.getId();
		} else {
			this.selectedWebsiteId = -1;
		}
	}

	public WebsiteUser getSelectedWebsiteUser() {
		return selectedWebsiteUser;
	}

	public void setSelectedWebsiteUser(WebsiteUser selectedWebsiteUser) {
		this.selectedWebsiteUser = selectedWebsiteUser;
	}

	public Language getLanguage() {
		return language;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isVisitor() {
		return roles.contains(Role.Visitor);
	}
	
	@Override
	public String getUsername() {
		return hasUser() ? user.getUsername() : null;
	}
	
	@Override
	public String getPassword() {
		return hasUser() ? user.getPassword() : null;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("AUTHENTICATED"));
	}

	@Override
	public boolean isEnabled() {
		return hasUser() ? user.isEnabled() : false;
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
