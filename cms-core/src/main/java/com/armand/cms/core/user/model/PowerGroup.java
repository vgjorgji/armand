package com.armand.cms.core.user.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.armand.cms.core.conf.CmsPackage;
import com.armand.cms.core.utils.Pair;
import com.armand.cms.core.utils.Utils;

public enum PowerGroup {
  Roots(Arrays.asList(
      new Pair<>(
          CmsPackage.Basic,
          Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer,
              Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member)),
      new Pair<>(
          CmsPackage.Dynamic,
          Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer,
              Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member)),
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.ROOT, Role.Administrator, Role.Designer, Role.DesignReviewer,
              Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member))
  )),

  Administrators(Arrays.asList(
      new Pair<>(
          CmsPackage.Basic,
          Utils.asSet(Role.Administrator, Role.CMSMember)),
      new Pair<>(
          CmsPackage.Dynamic,
          Utils.asSet(Role.Administrator, Role.Writer, Role.WriteReviewer, Role.CMSMember)),
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.Administrator, Role.Designer, Role.DesignReviewer,
              Role.Writer, Role.WriteReviewer, Role.CMSMember, Role.Member))
  )),

  Reviewers(Arrays.asList(
      new Pair<>(
          CmsPackage.Dynamic,
          Utils.asSet(Role.WriteReviewer, Role.CMSMember)),
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.DesignReviewer, Role.WriteReviewer, Role.CMSMember, Role.Member))
  )),

  Designers(Arrays.asList(
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.Designer, Role.Writer, Role.CMSMember, Role.Member))
  )),

  Writers(Arrays.asList(
      new Pair<>(
          CmsPackage.Dynamic,
          Utils.asSet(Role.Writer, Role.CMSMember)),
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.Writer, Role.CMSMember, Role.Member))
  )),

  Members(Arrays.asList(
      new Pair<>(
          CmsPackage.Business,
          Utils.asSet(Role.Member))
  ));


  /**
   * Map: CmsPackage -> List of Roles.
   */
  private Map<CmsPackage, Set<Role>> cmsPackageRoles;

  /**
   * Constructor.
   */
  PowerGroup(List<Pair<CmsPackage, Set<Role>>> pairs) {
    cmsPackageRoles = new HashMap<>();
    for (Pair<CmsPackage, Set<Role>> pair : pairs) {
      cmsPackageRoles.put(pair.getKey(), pair.getValue());
    }
  }

  public Set<Role> getRolesForCmsPackage(CmsPackage cmsPackage) {
    return cmsPackageRoles.get(cmsPackage);
  }
}
