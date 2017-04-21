package com.vcms.content.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.conf.cms.Component;
import com.vcms.content.model.ContentModel;
import com.vcms.content.model.MainNavItem;
import com.vcms.content.model.MainNavItemRepository;
import com.vcms.content.model.NavItem;
import com.vcms.content.model.NavItemRepository;
import com.vcms.content.model.SubNavItem;
import com.vcms.content.model.SubNavItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.utils.Utils;

@Service
public class NavigationServiceImpl implements NavigationService {
	
	@Autowired
	private MainNavItemRepository mainNavItemRepository;
	
	@Autowired
	private NavItemRepository navItemRepository;
	
	@Autowired
	private SubNavItemRepository subNavItemRepository;

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		if (!Component.Navigation.equals(designComponent.getComponent())) {
			return Collections.emptyList();
		}
		
		// load from DB
		List<MainNavItem> mainNavItems = mainNavItemRepository.getModels(designComponent.getId());
		List<NavItem> navItems = navItemRepository.getModels(designComponent.getId());
		List<SubNavItem> subNavItems = subNavItemRepository.getModels(designComponent.getId());
		
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
		List<ContentModel> result = new ArrayList<>(mainNavItems.size());
		for (MainNavItem item : mainNavItems) {
			result.add(item);
		}
		return result;
	}
	
}
