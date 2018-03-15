package com.armand.cms.core.content.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.armand.cms.core.conf.Component;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.utils.Utils;
import com.armand.cms.core.website.model.WebsiteViewType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NavigationServiceImpl implements NavigationService {

  private final MainNavItemRepository mainNavItemRepository;
  private final NavItemRepository navItemRepository;
  private final SubNavItemRepository subNavItemRepository;

  @Override
  public List<ContentModel> getCompleteNavigationForWebsite(long websiteId, WebsiteViewType websiteViewType) {
    // load from DB
    List<MainNavItem> mainNavItems = mainNavItemRepository.getModels(websiteId, websiteViewType);
    List<NavItem> navItems = navItemRepository.getModels(websiteId, websiteViewType);
    List<SubNavItem> subNavItems = subNavItemRepository.getModels(websiteId, websiteViewType);

    // map models
    Map<Long, MainNavItem> mainNavItemsMap = Utils.mapList(mainNavItems);
    Map<Long, NavItem> navItemsMap = Utils.mapList(navItems);

    // link models
    for (SubNavItem subNavItem : subNavItems) {
      NavItem navItem = navItemsMap.get(subNavItem.getNavItemId());
      if (navItem != null) {
        navItem.getSubNavItems().add(subNavItem);
      }
    }
    for (NavItem navItem : navItems) {
      MainNavItem mainNavItem = mainNavItemsMap.get(navItem.getMainNavItemId());
      if (mainNavItem != null) {
        mainNavItem.getNavItems().add(navItem);
      }
    }

    // copy to result list
    return new ArrayList<>(mainNavItems);
  }

}
