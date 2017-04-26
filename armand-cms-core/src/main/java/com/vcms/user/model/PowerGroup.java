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
					CmsPackage.Basic, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer, 
							Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Dynamic, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer, 
							Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
					Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer, 
							Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member))
			)),
	
	Administrators(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Basic, 
					Utils.asSet(Role.Administrator, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Dynamic, 
					Utils.asSet(Role.Administrator, Role.Writer, Role.WriteReviewer, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
					Utils.asSet(Role.Administrator, Role.Designer, Role.DesignReviewer, 
							Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member))
			)),
	
	Reviewers(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Dynamic, 
					Utils.asSet(Role.WriteReviewer, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
					Utils.asSet(Role.DesignReviewer, Role.WriteReviewer, Role.CMSMember, Role.Member))
			)),
	
	Designers(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
					Utils.asSet(Role.Designer, Role.Writer, Role.CMSMember, Role.Member))
			)),
	
	Writers(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Dynamic, 
					Utils.asSet(Role.Writer, Role.CMSMember)),
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
					Utils.asSet(Role.Writer, Role.CMSMember, Role.Member))
			)),
	
	Members(Arrays.asList(
			new ImmutablePair<CmsPackage, Set<Role>>(
					CmsPackage.Business, 
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
