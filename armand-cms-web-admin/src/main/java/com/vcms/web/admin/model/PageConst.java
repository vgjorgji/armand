package com.vcms.web.admin.model;

public interface PageConst {
	
	String Overview = "/overview";
	String Admin = "/admin";
	String Websites = "/websites";
	String Website = "/website/{websiteId}";
	
	String OverviewDashboard = Overview + "/dashboard";
	
	String AdminDashboard = Admin + "/dashboard";
	String AdminUsers = Admin + "/users";
	String AdminCompanies = Admin + "/companies";
	
	String WebsitesDashboard = Websites + "/dashboard";
	
	String WebsiteDashboard = Website + "/dashboard";
	String WebsiteAdmin = Website + "/admin";
	String WebsiteDesign = Website + "/design";
	String WebsiteDesignReview = Website + "/design-review";
	String WebsiteContent = Website + "/content";
	String WebsiteContentReview = Website + "/content-review";
	
	String WebsiteAdminSite = WebsiteAdmin + "/site";
	String WebsiteAdminUsers = WebsiteAdmin + "/users";
	
	String WebsiteDesignTheme = WebsiteDesign + "/theme";
	String WebsiteDesignNavigation = WebsiteDesign + "/navigation";
	String WebsiteDesignPages = WebsiteDesign + "/pages";
	String WebsiteDesignPreview = WebsiteDesign + "/preview";

}
