package com.armand.cms.core.design.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.conf.FeedType;
import com.armand.cms.core.conf.Icon;
import com.armand.cms.core.design.model.CmsPage;
import com.armand.cms.core.design.model.ExternalPage;
import com.armand.cms.core.design.model.FeedPage;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.utils.TextUtils;

@Repository
public class PageRepositoryStub
    extends HistoryModelRepositoryStub<Page>
    implements PageRepository {

  @PostConstruct
  public void init() {
    CmsPage cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1000);
    cmsPage.setWebsiteViewId(1000);
    cmsPage.setUrl("home");
    cmsPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "Home", "Почетна"));
    saveModel(cmsPage);

    cmsPage = StubUtils.createStubDbModel(new CmsPage(), 1001);
    cmsPage.setWebsiteViewId(1000);
    cmsPage.setUrl("about_us");
    cmsPage.setTitle(TextUtils.createLocalText(LocalTextType.Small, "About us", "За нас"));
    saveModel(cmsPage);

    ExternalPage externalPage = StubUtils.createStubDbModel(new ExternalPage(), 1002);
    externalPage.setWebsiteViewId(1000);
    externalPage.setIcon(Icon.Facebook);
    externalPage.setUrl("https://www.facebook.com/");
    saveModel(externalPage);

    FeedPage feedPage = StubUtils.createStubDbModel(new FeedPage(), 1003);
    feedPage.setWebsiteViewId(1000);
    feedPage.setUrl("gallery");
    feedPage.setFeedType(FeedType.Article);
    saveModel(feedPage);
  }

  @Override
  public ExternalPage getExternalPage(long websiteViewId, String url) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof ExternalPage && page.getUrl().equals(url)) {
        return (ExternalPage) page;
      }
    }
    return null;
  }

  @Override
  public CmsPage getCmsPage(long websiteViewId, String url) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof CmsPage && page.getUrl().equals(url)) {
        return (CmsPage) page;
      }
    }
    return null;
  }

  @Override
  public FeedPage getFeedPage(long websiteViewId, String url, FeedType feedType) {
    for (Page page : getAllModels().getModels()) {
      if (page instanceof FeedPage && page.getUrl().equals(url)
          && ((FeedPage) page).getFeedType() == feedType) {
        return (FeedPage) page;
      }
    }
    return null;
  }

  @Override
  protected long getParentId(Page model, String parentField) {
    return model.getWebsiteViewId();
  }
}
