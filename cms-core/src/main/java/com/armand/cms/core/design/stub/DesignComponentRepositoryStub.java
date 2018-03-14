package com.armand.cms.core.design.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.conf.Component;
import com.armand.cms.core.conf.ComponentStyle;
import com.armand.cms.core.conf.FeedType;
import com.armand.cms.core.conf.ItemsLayout;
import com.armand.cms.core.conf.SingleColor;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.design.model.DesignComponentRepository;
import com.armand.cms.core.design.model.FeedDesignComponent;
import com.armand.cms.core.design.model.FeedFilter;
import com.armand.cms.core.design.model.LayoutPosition;
import com.armand.cms.core.utils.StubUtils;
import com.armand.cms.core.website.model.WebsiteViewType;

@Repository
public class DesignComponentRepositoryStub implements DesignComponentRepository {

  @Override
  public List<DesignComponent> getDesignComponents(long pageId) {
    if (pageId == 1000) {
      return createHomePage(pageId);
    } else if (pageId == 1001) {
      return createAboutUsPage(pageId);
    }
    return Collections.emptyList();
  }

  private List<DesignComponent> createHomePage(long pageId) {
    List<DesignComponent> list = new ArrayList<>();

    // header + navigation
    addHeader(pageId, list);

    // jumbotron
    DesignComponent component = StubUtils.createStubDbModel(new DesignComponent(), 1002);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Jumbotron);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Header);
    component.setSortOrder(2);
    list.add(component);


    // paragraph container (about us)
    component = StubUtils.createStubDbModel(new DesignComponent(), 1003);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Paragraphs);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Top);
    component.setSortOrder(4);
    list.add(component);

    // highlights
    component = StubUtils.createStubDbModel(new DesignComponent(), 1004);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Highlights);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Top);
    component.setBackgroundColor(SingleColor.VeryLightGray);
    component.setItemsLayout(ItemsLayout.FourColumns);
    component.setSortOrder(3);
    list.add(component);

    // gallery title
    component = StubUtils.createStubDbModel(new DesignComponent(), 1005);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Titles);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Top);
    component.setSortOrder(3);
    list.add(component);

    // gallery
    FeedDesignComponent feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1006);
    feedComponent.setPageDesignId(pageId);
    feedComponent.setComponent(Component.Feed);
    feedComponent.setComponentStyle(ComponentStyle.Learn);
    feedComponent.setLayoutPosition(LayoutPosition.Top);
    feedComponent.setSortOrder(0);
    feedComponent.setFeedType(FeedType.Album);
    feedComponent.setFeedFilter(FeedFilter.Latest);
    feedComponent.setItemsLayout(ItemsLayout.TwoColumns);
    feedComponent.getFeedItemLayout().setTitleAsLink(false);
    feedComponent.getFeedItemLayout().setText(false);
    feedComponent.getFeedItemLayout().setLink(false);
    feedComponent.getFeedItemLayout().setHashTags(false);
    feedComponent.getFeedItemLayout().setStats(false);
    list.add(feedComponent);


    // CENTER: news latest title
    component = StubUtils.createStubDbModel(new DesignComponent(), 1007);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Titles);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Center);
    component.setBackgroundColor(SingleColor.VeryLightGray);
    component.setSortOrder(3);
    list.add(component);

    // news latest
    feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1008);
    feedComponent.setPageDesignId(pageId);
    feedComponent.setComponent(Component.Feed);
    feedComponent.setComponentStyle(ComponentStyle.Learn);
    feedComponent.setLayoutPosition(LayoutPosition.Center);
    feedComponent.setSortOrder(0);
    feedComponent.setFeedFilter(FeedFilter.Latest);
    feedComponent.setItemsLayout(ItemsLayout.OneColumn);
    feedComponent.getFeedItemLayout().setTitleAsLink(false);
    list.add(feedComponent);

    // news popular title
    component = StubUtils.createStubDbModel(new DesignComponent(), 1009);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Titles);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Right);
    component.setSortOrder(3);
    list.add(component);

    // news popular
    feedComponent = StubUtils.createStubDbModel(new FeedDesignComponent(), 1010);
    feedComponent.setPageDesignId(pageId);
    feedComponent.setComponent(Component.Feed);
    feedComponent.setComponentStyle(ComponentStyle.Learn);
    feedComponent.setLayoutPosition(LayoutPosition.Right);
    feedComponent.setSortOrder(0);
    feedComponent.setFeedFilter(FeedFilter.Popular);
    feedComponent.setItemsLayout(ItemsLayout.OneColumn);
    feedComponent.getFeedItemLayout().setLink(false);
    feedComponent.getFeedItemLayout().setText(false);
    feedComponent.getFeedItemLayout().setHashTags(false);
    feedComponent.getFeedItemLayout().setStats(false);
    list.add(feedComponent);


    // paragraph container (test)
    component = StubUtils.createStubDbModel(new DesignComponent(), 1011);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Paragraphs);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Bottom);
    component.setSortOrder(4);
    list.add(component);

    // news popular title
    component = StubUtils.createStubDbModel(new DesignComponent(), 1012);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Titles);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Bottom);
    component.setSortOrder(3);
    list.add(component);

    // contact info
    component = StubUtils.createStubDbModel(new DesignComponent(), 1013);
    component.setPageDesignId(pageId);
    component.setComponent(Component.ContactInfos);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Bottom);
    component.setSortOrder(38);
    list.add(component);

    // contact form
    component = StubUtils.createStubDbModel(new DesignComponent(), 1014);
    component.setPageDesignId(pageId);
    component.setComponent(Component.ContactForms);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Bottom);
    component.setSortOrder(39);
    list.add(component);

    // footer
    addFooter(pageId, list);

    // result
    return list;
  }


  private List<DesignComponent> createAboutUsPage(long pageId) {
    List<DesignComponent> list = new ArrayList<>();

    // header + navigation
    addHeader(pageId, list);

    // paragraph container (test)
    DesignComponent component = StubUtils.createStubDbModel(new DesignComponent(), 1016);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Paragraphs);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Center);
    component.setSortOrder(4);
    list.add(component);

    // footer
    addFooter(pageId, list);

    // result
    return list;
  }


  private void addHeader(long pageId, List<DesignComponent> list) {
    // header
    DesignComponent component = StubUtils.createStubDbModel(new DesignComponent(), 1000);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Header);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Header);
    component.setSortOrder(0);
    list.add(component);

    // navigation
    component = StubUtils.createStubDbModel(new DesignComponent(), 1001);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Navigation);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Header);
    component.setSortOrder(1);
    list.add(component);
  }

  private void addFooter(long pageId, List<DesignComponent> list) {
    // footer
    DesignComponent component = StubUtils.createStubDbModel(new DesignComponent(), 1015);
    component.setPageDesignId(pageId);
    component.setComponent(Component.Footer);
    component.setComponentStyle(ComponentStyle.Learn);
    component.setLayoutPosition(LayoutPosition.Footer);
    component.setSortOrder(40);
    list.add(component);
  }

  @Override
  public DesignComponent getNavigationComponentForWebsite(long websiteId, WebsiteViewType websiteViewType) {
    return null;
  }
}
