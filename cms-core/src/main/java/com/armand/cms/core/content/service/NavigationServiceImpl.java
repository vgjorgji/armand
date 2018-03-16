package com.armand.cms.core.content.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.armand.cms.core.content.model.MainNavItem;
import com.armand.cms.core.content.model.MainNavItemRepository;
import com.armand.cms.core.content.model.NavItem;
import com.armand.cms.core.content.model.NavItemRepository;
import com.armand.cms.core.content.model.SubNavItem;
import com.armand.cms.core.content.model.SubNavItemRepository;
import com.armand.cms.core.persist.model.PagingSearch;
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
  public List<MainNavItem> getCompleteNavigationForWebsite(long websiteId, WebsiteViewType websiteViewType) {
    // load from DB
    PagingSearch searchAll = new PagingSearch();
    searchAll.setSize(Integer.MAX_VALUE);
    List<MainNavItem> mainNavItems = mainNavItemRepository.getPagingModels(searchAll, websiteId, websiteViewType).getFetch().getModels();
    List<NavItem> navItems = navItemRepository.getPagingModels(searchAll, websiteId, websiteViewType).getFetch().getModels();
    List<SubNavItem> subNavItems = subNavItemRepository.getPagingModels(searchAll, websiteId, websiteViewType).getFetch().getModels();

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

    // result
    return mainNavItems;
  }

}
