package com.vcms.user.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	ROOT, 
	Administrator, 
	Reviewer, 
	Designer, 
	ContentWriter, 
	CMSMember, 
	Member,
	Visitor;
	
	@Override
	public String getAuthority() {
		return "ROLE_" + name();
	}
}
