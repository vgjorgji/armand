package com.vcms.user.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.utils.Utils;

public enum PowerGroup {
	Roots(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BASIC, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Reviewer, Role.Designer, Role.ContentWriter,
							Role.CMSMember, Role.Member)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.DYNAMIC, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Reviewer, Role.Designer, Role.ContentWriter,
							Role.CMSMember, Role.Member)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Reviewer, Role.Designer, Role.ContentWriter,
							Role.CMSMember, Role.Member))
			)),
	
	Administrators(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BASIC, 
					Utils.asSet(Role.Administrator, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.DYNAMIC, 
					Utils.asSet(Role.Administrator, Role.Reviewer, Role.ContentWriter, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.Administrator, Role.Reviewer, Role.Designer, Role.ContentWriter, Role.CMSMember,
							Role.Member))
			)),
	
	Reviewers(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.DYNAMIC, 
					Utils.asSet(Role.Reviewer, Role.ContentWriter, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.Reviewer, Role.Designer, Role.ContentWriter, Role.CMSMember, Role.Member))
			)),
	
	Designers(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.Designer, Role.ContentWriter, Role.CMSMember, Role.Member))
			)),
	
	ContentWriters(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.DYNAMIC, 
					Utils.asSet(Role.ContentWriter, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.ContentWriter, Role.CMSMember, Role.Member))
			)),
	
	Members(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.BUSINESS, 
					Utils.asSet(Role.Member))
			));
	
	
	/** Map: CmsPackage -> List of Roles. */
	private Map<CmsPackage, Set<Role>> cmsPackageRoles;
	
	/**
	 * Constructor.
	 */
	private PowerGroup(List<ImmutablePair<CmsPackage, Set<Role>>> pairs) {
		cmsPackageRoles = new HashMap<>();
		for (ImmutablePair<CmsPackage, Set<Role>> pair : pairs) {
			cmsPackageRoles.put(pair.getKey(), pair.getValue());
		}
	}
	
	public Set<Role> getRolesForCmsPackage(CmsPackage cmsPackage) {
		return cmsPackageRoles.get(cmsPackage);
	}
}
