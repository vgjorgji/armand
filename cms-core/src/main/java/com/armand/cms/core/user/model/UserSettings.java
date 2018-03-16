package com.armand.cms.core.user.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.utils.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSettings implements UserDetails {

  private static final long serialVersionUID = 8749204172625676869L;
  public static final Language DEFAULT_LANGUAGE = Language.English;
  public static final Set<Role> DEFAULT_ROLES = Utils.asSet(Role.Visitor);

  // identifiers
  private Visitor visitor;
  private User user;

  // select
  private long selectedWebsiteId = -1;
  private long selectedWebsiteUserId = -1;

  // shortcuts
  private String selectedWebsiteName = "";
  private long selectedWebsiteViewIdDesign = -1;
  private long selectedWebsiteViewIdContent = -1;
  private long selectedWebsiteViewIdLive = -1;

  // resolve
  private Language language = DEFAULT_LANGUAGE;
  private Set<Role> roles = DEFAULT_ROLES;


  public long getId() {
    return hasUser() ? user.getId() : -1;
  }

  public boolean hasUser() {
    return user != null;
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
    return hasUser() && user.isEnabled();
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

  public String toStringUser() {
    if (hasUser()) {
      return user.getId() + " - " + user.getLastName() + " " + user.getFirstName();
    } else {
      return visitor.getRemoteAddress();
    }
  }


}
