package com.armand.cms.web.admin.model;

import org.springframework.util.StringUtils;

import lombok.Getter;

@Getter
public enum Page {

  OverviewDashboard(PageConst.OverviewDashboard),

  AdminDashboard(PageConst.AdminDashboard),
  AdminUsers(PageConst.AdminUsers),
  AdminCompanies(PageConst.AdminCompanies),
  AdminWebsites(PageConst.AdminWebsites),
  AdminWebsitesGroups(PageConst.AdminWebsitesGroups),

  WebsitesDashboard(PageConst.WebsitesDashboard),

  WebsiteDashboard(PageConst.WebsiteDashboard, "/website/dashboard"),
  WebsiteAdmin(PageConst.WebsiteAdmin, "/website/admin"),
  WebsiteDesign(PageConst.WebsiteDesign, "/website/design"),
  WebsiteDesignReview(PageConst.WebsiteDesignPreview, "/website/design_review"),
  WebsiteContent(PageConst.WebsiteContent, "/website/content"),
  WebsiteContentReview(PageConst.WebsiteContentReview, "/website/content_review"),

  WebsiteAdminSite(PageConst.WebsiteAdminSite, "/website/admin/site"),
  WebsiteAdminUsers(PageConst.WebsiteAdminUsers, "/website/admin/users"),

  WebsiteDesignTheme(PageConst.WebsiteDesignTheme, "/website/design/theme"),
  WebsiteDesignNavigation(PageConst.WebsiteDesignNavigation, "/website/design/navigation"),
  WebsiteDesignPages(PageConst.WebsiteDesignPages, "/website/design/pages"),
  WebsiteDesignPreview(PageConst.WebsiteDesignPreview, "/website/design/preview"),;

  private String url;
  private String view;

  Page(String url) {
    this(url, url);
  }

  Page(String url, String view) {
    this.url = url;
    this.view = "page" + StringUtils.replace(view, "-", "_");
  }

}
