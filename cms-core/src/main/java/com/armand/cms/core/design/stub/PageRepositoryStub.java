package com.armand.cms.core.design.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.armand.cms.core.conf.cms.FeedType;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.design.model.ExternalPage;
import com.armand.cms.core.design.model.FeedPage;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;
import com.armand.cms.core.conf.cms.Icon;
import com.armand.cms.core.localization.model.LocalTextType;

@Repository
public class PageRepositoryStub implements PageRepository {
	
	private List<Page> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		CmsPage cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1000);
		cmsPage.setWebsiteViewId(1000);
		cmsPage.setUrl("home");
		cmsPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
		list.add(cmsPage);
		
		cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1001);
		cmsPage.setWebsiteViewId(1000);
		cmsPage.setUrl("about_us");
		cmsPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
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
