package com.vcms.content.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vcms.conf.cms.Component;
import com.vcms.content.model.ContentModelRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.persist.model.ContentModel;

public class ContentService {
	
	@Autowired
	private ContentModelRepository contactInfoItemRepository;
	
	@Autowired
	private ContentModelRepository feedItemRepository;
	
	private Map<Component, ContentModelRepository> repositoryMap;
	
	@PostConstruct
	public void init() {
		repositoryMap = new HashMap<>();
		repositoryMap.put(Component.ContactInfos, contactInfoItemRepository);
		repositoryMap.put(Component.Feed, feedItemRepository);
	}
	
	public List<ContentModel> getContentModels(DesignComponent designComponent) {
		return repositoryMap.get(designComponent.getComponent()).getModelsForDesignComponent(designComponent);
	}

}
