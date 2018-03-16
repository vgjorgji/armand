package com.armand.cms.web.admin.controller.website;

import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.design.model.Page;
import com.armand.cms.core.design.model.PageRepository;
import com.armand.cms.core.persist.model.DbModelRepository;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.user.model.UserSettings;
import com.armand.cms.core.user.service.UserSettingsProvider;
import com.armand.cms.core.website.model.WebsiteViewType;
import com.armand.cms.web.admin.controller.AbstractTreeController;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;
import com.armand.cms.web.admin.model.tree.MainNode;
import com.armand.cms.web.admin.model.tree.Node;
import com.armand.cms.web.admin.model.tree.SubNode;
import lombok.RequiredArgsConstructor;

@RestController(value = Controller.WebsiteDesignNavigation)
@RequestMapping(value = PageConst.WebsiteDesignNavigation)
@RequiredArgsConstructor
public class DesignNavigationController extends AbstractTreeController<MainNavItem, NavItem, SubNavItem> {

  private final MainNavItemRepository mainNavItemRepository;
  private final NavItemRepository navItemRepository;
  private final SubNavItemRepository subNavItemRepository;
  private final PageRepository pageRepository;

  @Override
  public Response addMainNode() {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // node
    MainNavItem item = new MainNavItem();
    item.setWebsiteViewId(userSettings.getSelectedWebsiteViewIdDesign());

    // response
    Response response = new Response();
    response.fragmentNode().data()
        .add("mainNavItem", item)
        .add("pages", pages);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response editMainNode(@PathVariable long mainNodeId) {
    // models
    MainNavItem item = getMainNodeRepository().getModel(mainNodeId);
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // response
    Response response = new Response();
    response.fragmentNode().data()
        .add("mainNavItem", item)
        .add("pages", pages);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response saveMainNode(@RequestBody MainNavItem mainNode) {
    getMainNodeRepository().saveModel(mainNode);
    Response response = new Response();   // if there are errors then call edit
    response.fragmentNode().hide();
    response.setClickElement("table-search");
    return response;
  }


  @Override
  public Response addNode(@PathVariable long mainNodeId) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // node
    NavItem navItem = new NavItem();
    navItem.setMainNavItemId(mainNodeId);

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // response
    Response response = new Response();
    response.fragmentNode().data()
        .add("navItem", navItem)
        .add("pages", pages);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response editNode(@PathVariable long mainNodeId, @PathVariable long nodeId) {
    // models
    NavItem navItem = getNodeRepository().getModel(nodeId);
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // response
    Response response = new Response();
    response.fragmentNode().data()
        .add("navItem", navItem)
        .add("pages", pages);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response saveNode(@PathVariable long mainNodeId, @RequestBody NavItem node) {
    getNodeRepository().saveModel(node);
    Response response = new Response();   // if there are errors then call edit
    response.fragmentNode().hide();
    response.setClickElement("table-search");
    return response;
  }


  @Override
  public Response addSubNode(@PathVariable long mainNodeId,
                             @PathVariable long nodeId) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // sub node
    SubNavItem subNavItem = new SubNavItem();
    subNavItem.setNavItemId(nodeId);

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // response
    Response response = new Response();
    response.fragmentNode().hide();
    response.fragmentSubNode().data()
        .add("subNavItem", subNavItem)
        .add("pages", pages);
    return response;
  }

  @Override
  public Response editSubNode(@PathVariable long mainNodeId,
                              @PathVariable long nodeId,
                              @PathVariable long subNodeId) {
    // models
    SubNavItem subNavItem = getSubNodeRepository().getModel(subNodeId);
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    // pages
    Fetch<Page> pages = pageRepository.getModels(
        Collections.singletonList(userSettings.getSelectedWebsiteViewIdDesign()), null);

    // response
    Response response = new Response();
    response.fragmentNode().hide();
    response.fragmentSubNode().data()
        .add("subNavItem", subNavItem)
        .add("pages", pages);
    return response;
  }

  @Override
  public Response saveSubNode(@PathVariable long mainNodeId,
                              @PathVariable long nodeId,
                              @RequestBody SubNavItem subNode) {
    getSubNodeRepository().saveModel(subNode);
    Response response = new Response();   // if there are errors then call edit
    response.fragmentSubNode().hide();
    response.setClickElement("table-search");
    return response;
  }


  @Override
  protected MainNode createMainNode(MainNavItem mainNodeModel) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    MainNode mainNode = new MainNode();
    mainNode.setId(mainNodeModel.getId());
    mainNode.setIcon(mainNodeModel.getLink().getIcon());
    mainNode.setTitle("Title: " + mainNodeModel.getLink().getText().getText(userSettings.getLanguage())
        + ", URL: " + mainNodeModel.getLink().getUrl());
    return mainNode;
  }

  @Override
  protected long getNodeParentId(NavItem nodeModel) {
    return nodeModel.getMainNavItemId();
  }

  @Override
  protected Node createNode(NavItem nodeModel) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    Node node = new Node();
    node.setId(nodeModel.getId());
    node.setIcon(nodeModel.getLink().getIcon());
    node.setTitle("Title: " + nodeModel.getLink().getText().getText(userSettings.getLanguage())
        + ", URL: " + nodeModel.getLink().getUrl());
    return node;
  }

  @Override
  protected long getSubNodeParentId(SubNavItem subNodeModel) {
    return subNodeModel.getNavItemId();
  }

  @Override
  protected SubNode createSubNode(SubNavItem subNodeModel) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();

    SubNode subNode = new SubNode();
    subNode.setId(subNodeModel.getId());
    subNode.setIcon(subNodeModel.getLink().getIcon());
    subNode.setTitle("Title: " + subNodeModel.getLink().getText().getText(userSettings.getLanguage())
        + ", URL: " + subNodeModel.getLink().getUrl());
    return subNode;
  }


  @Override
  protected Paging<MainNavItem> searchPagingModels(PagingSearch pagingSearch) {
    UserSettings userSettings = UserSettingsProvider.getCurrentUser();
    return mainNavItemRepository.getPagingModels(pagingSearch, userSettings.getSelectedWebsiteId(), WebsiteViewType.Design);
  }


  @Override
  protected DbModelRepository<MainNavItem> getMainNodeRepository() {
    return mainNavItemRepository;
  }

  @Override
  protected DbModelRepository<NavItem> getNodeRepository() {
    return navItemRepository;
  }

  @Override
  protected DbModelRepository<SubNavItem> getSubNodeRepository() {
    return subNavItemRepository;
  }

  @Override
  protected Fragment getFragment(Response response) {
    return response.fragmentMain();
  }

}
