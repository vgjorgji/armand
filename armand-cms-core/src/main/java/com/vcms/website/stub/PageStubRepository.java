package com.vcms.website.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.FeedType;
import com.vcms.conf.cms.Icon;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.StubUtils;
import com.vcms.website.model.CmsPage;
import com.vcms.website.model.ExternalPage;
import com.vcms.website.model.FeedPage;
import com.vcms.website.model.Page;
import com.vcms.website.model.PageRepository;

@Repository
public class PageStubRepository implements PageRepository {
	
	private List<Page> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		CmsPage cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1000);
		cmsPage.setWebsiteViewId(1000);
		cmsPage.setUrl("home");
		cmsPage.setTitle(StubUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
		list.add(cmsPage);
		
		cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1001);
		cmsPage.setWebsiteViewId(1000);
		cmsPage.setUrl("about_us");
		cmsPage.setTitle(StubUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
		list.add(cmsPage);
		
		ExternalPage externalPage = StubUtils.createStubDbModel(new ExternalPage(), 1002);
		externalPage.setWebsiteViewId(1000);
		externalPage.setIcon(Icon.Facebook);
		externalPage.setUrl("https://www.facebook.com/");
		list.add(externalPage);
		
		FeedPage feedPage = StubUtils.createStubDbModel(new FeedPage(), 1003);
		feedPage.setWebsiteViewId(1000);
		feedPage.setUrl("gallery");
		feedPage.setFeedType(FeedType.Aricle);
		list.add(externalPage);
	}
	
	@Override
	public ExternalPage getExternalPage(long websiteViewId, String url) {
		for (Page page : list) {
			if (page instanceof ExternalPage && StringUtils.equals(page.getUrl(), url)) {
				return (ExternalPage) page;
			}
		}
		return null;
	}

	@Override
	public CmsPage getCmsPage(long websiteViewId, String url) {
		for (Page page : list) {
			if (page instanceof CmsPage && StringUtils.equals(page.getUrl(), url)) {
				return (CmsPage) page;
			}
		}
		return null;
	}
	
	@Override
	public FeedPage getFeedPage(long websiteViewId, String url, FeedType feedType) {
		for (Page page : list) {
			if (page instanceof FeedPage && StringUtils.equals(page.getUrl(), url)
					&& ((FeedPage) page).getFeedType() == feedType) {
				return (FeedPage) page;
			}
		}
		return null;
	}

}
