package com.vcms.web.admin.model;

public enum Page {
	
	OverviewDashboard(PageConst.OverviewDashboard),
	
	AdminDashboard(PageConst.AdminDashboard),
	
	WebsitesDashboard(PageConst.WebsitesDashboard),
	
	WebsiteDashboard(PageConst.WebsiteDashboard, "/website/dashboard"),
	WebsiteAdmin(PageConst.WebsiteAdmin, "/website/admin"),
	WebsiteDesign(PageConst.WebsiteDesign, "/website/design"),
	WebsiteDesignReview(PageConst.WebsiteDesignPreview, "/website/design-review"),
	WebsiteContent(PageConst.WebsiteContent, "/website/content"),
	WebsiteContentReview(PageConst.WebsiteContentReview, "/website/content-review"),
	
	WebsiteAdminSite(PageConst.WebsiteAdminSite, "/website/admin/site"),
	WebsiteAdminUsers(PageConst.WebsiteAdminUsers, "/website/admin/users"),
	
	WebsiteDesignTheme(PageConst.WebsiteDesignTheme, "/website/design/theme"),
	WebsiteDesignNavigation(PageConst.WebsiteDesignNavigation, "/website/design/navigation"),
	WebsiteDesignPages(PageConst.WebsiteDesignPages, "/website/design/pages"),
	WebsiteDesignPreview(PageConst.WebsiteDesignPreview, "/website/design/preview"),
	;
	
	private String url;
	private String view;
	
	private Page(String url) {
		this(url, url);
	}
	
	private Page(String url, String view) {
		this.url = url;
		this.view = view;
	}

	public String getUrl() {
		return url;
	}

	public String getView() {
		return view;
	}
}
