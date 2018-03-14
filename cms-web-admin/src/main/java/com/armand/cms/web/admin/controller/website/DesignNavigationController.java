package com.armand.cms.web.admin.controller.website;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.conf.Icon;
import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.persist.model.DbModelRepository;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.model.PagingSearch;
import com.armand.cms.core.user.model.PowerGroup;
import com.armand.cms.core.user.model.User;
import com.armand.cms.core.user.model.WebsiteGroup;
import com.armand.cms.core.user.model.WebsiteUser;
import com.armand.cms.core.website.model.Website;
import com.armand.cms.web.admin.controller.AbstractTreeController;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;
import com.armand.cms.web.admin.model.tree.MainNode;
import com.armand.cms.web.admin.model.tree.Node;
import com.armand.cms.web.admin.model.tree.SubNode;
import lombok.RequiredArgsConstructor;

@RestController(value = Controller.AdminWebsitesGroups)
@RequestMapping(value = PageConst.AdminWebsitesGroups)
@RequiredArgsConstructor
public class DesignNavigationController extends AbstractTreeController<MainNavItem, NavItem, SubNavItem> {

  private final MainNavItemRepository mainNavItemRepository;
  private final NavItemRepository navItemRepository;
  private final SubNavItemRepository subNavItemRepository;

  @Override
  public Response addMainNode() {
    // find the Navigation Design component


    // node
    MainNavItem item = new MainNavItem();
    item.setDesignComponentId(mainNodeId);

    // response
    Response response = new Response();
    response.fragmentNode().data().add("mainNavItem", item);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response editMainNode(@PathVariable long mainNodeId) {
    // models
    MainNavItem item = navItemRepository.getModel(nodeId);

    // response
    Response response = new Response();
    response.fragmentNode().data().add("mainNavItem", item);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response saveMainNode(@RequestBody MainNavItem mainNode) {
    throw new UnsupportedOperationException("This operation is not supported");
  }

  @Override
  public Response deleteMainNode(@PathVariable long modelId) {
    throw new UnsupportedOperationException("This operation is not supported");
  }


  @Override
  public Response addNode(@PathVariable long mainNodeId) {
    // node
    WebsiteGroup websiteGroup = new WebsiteGroup();
    websiteGroup.setWebsiteId(mainNodeId);

    // response
    Response response = new Response();
    response.fragmentNode().data().add("websiteGroup", websiteGroup);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response editNode(@PathVariable long mainNodeId, @PathVariable long nodeId) {
    // models
    WebsiteGroup websiteGroup = getNodeRepository().getModel(nodeId);

    // response
    Response response = new Response();
    response.fragmentNode().data().add("websiteGroup", websiteGroup);
    response.fragmentSubNode().hide();
    return response;
  }

  @Override
  public Response saveNode(@PathVariable long mainNodeId, @RequestBody WebsiteGroup node) {
    getNodeRepository().saveModel(node);
    Response response = new Response();   // if there are errors then call edit
    response.fragmentNode().hide();
    response.setClickElement("table-search");
    return response;
  }


  @Override
  public Response addSubNode(@PathVariable long mainNodeId,
                             @PathVariable long nodeId) {
    // models
    Fetch<User> allUsers = userRepository.getAllModels();

    // sub node
    WebsiteUser websiteUser = new WebsiteUser();
    websiteUser.setWebsiteId(mainNodeId);
    websiteUser.setWebsiteGroupId(nodeId);
    websiteUser.setBiography(LocalText.rich());
    websiteUser.setJobPosition(LocalText.small());

    // response
    Response response = new Response();
    response.fragmentNode().hide();
    response.fragmentSubNode().data()
        .add("allUsers", allUsers.getModels())
        .add("languages", Language.values())
        .add("powerGroups", PowerGroup.values())
        .add("websiteUser", websiteUser);
    return response;
  }

  @Override
  public Response editSubNode(@PathVariable long mainNodeId,
                              @PathVariable long nodeId,
                              @PathVariable long subNodeId) {
    // models
    Fetch<User> allUsers = userRepository.getAllModels();
    WebsiteUser websiteUser = getSubNodeRepository().getModel(subNodeId);

    // response
    Response response = new Response();
    response.fragmentNode().hide();
    response.fragmentSubNode().data()
        .add("allUsers", allUsers.getModels())
        .add("languages", Language.values())
        .add("powerGroups", PowerGroup.values())
        .add("websiteUser", websiteUser);
    return response;
  }

  @Override
  public Response saveSubNode(@PathVariable long mainNodeId,
                              @PathVariable long nodeId,
                              @RequestBody WebsiteUser subNode) {
    getSubNodeRepository().saveModel(subNode);
    Response response = new Response();   // if there are errors then call edit
    response.fragmentSubNode().hide();
    response.setClickElement("table-search");
    return response;
  }


  @Override
  protected MainNode createMainNode(Website mainNodeModel) {
    MainNode mainNode = new MainNode();
    mainNode.setId(mainNodeModel.getId());
    mainNode.setTitle(mainNodeModel.getName());
    return mainNode;
  }

  @Override
  protected long getNodeParentId(WebsiteGroup nodeModel) {
    return nodeModel.getWebsiteId();
  }

  @Override
  protected Node createNode(WebsiteGroup nodeModel) {
    Node node = new Node();
    node.setId(nodeModel.getId());
    node.setTitle(nodeModel.getName());
    node.setIcon(nodeModel.isMaster() ? Icon.UserSecret : null);
    return node;
  }

  @Override
  protected long getSubNodeParentId(WebsiteUser subNodeModel) {
    return subNodeModel.getWebsiteGroupId();
  }

  @Override
  protected SubNode createSubNode(WebsiteUser subNodeModel) {
    SubNode subNode = new SubNode();
    subNode.setId(subNodeModel.getId());
    subNode.setTitle("Power Group: " + subNodeModel.getPowerGroup().name() + ", User: " + subNodeModel.getUserId());
    return subNode;
  }


  @Override
  protected Paging<MainNavItem> searchPagingModels(PagingSearch pagingSearch) {
    return null;
  }


  @Override
  protected DbModelRepository<Website> getMainNodeRepository() {
    return websiteRepository;
  }

  @Override
  protected DbModelRepository<WebsiteGroup> getNodeRepository() {
    return websiteGroupRepository;
  }

  @Override
  protected DbModelRepository<WebsiteUser> getSubNodeRepository() {
    return websiteUserRepository;
  }

  @Override
  protected Fragment getFragment(Response response) {
    return response.fragmentMain();
  }

}
