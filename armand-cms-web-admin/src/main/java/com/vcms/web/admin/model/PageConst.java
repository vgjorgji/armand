package com.vcms.web.admin.model;

public interface PageConst {
	
	String Overview = "/overview";
	String Admin = "/admin";
	String Websites = "/websites";
	String Website = "/website/{websiteId}";
	
	String OverviewDashboard = Overview + "/dashboard";
	
	String AdminDashboard = Admin + "/dashboard";
	
	String WebsitesDashboard = Websites + "/dashboard";
	
	String WebsiteDashboard = Website + "/dashboard";
	String WebsiteDesign = Website + "/design";
	String WebsiteDesignReview = Website + "/design-review";
	String WebsiteContent = Website + "/content";
	String WebsiteContentReview = Website + "/content-review";
	
	String WebsiteDesignTheme = WebsiteDesign + "/theme";
	String WebsiteDesignNavigation = WebsiteDesign + "/navigation";
	String WebsiteDesignPages = WebsiteDesign + "/pages";
	String WebsiteDesignPreview = WebsiteDesign + "/preview";

}
