package com.vcms.content.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcms.conf.cms.Component;
import com.vcms.content.model.ContactInfoItemRepository;
import com.vcms.content.model.ContentModel;
import com.vcms.content.model.ContentModelRepository;
import com.vcms.content.model.FeedItemRepository;
import com.vcms.content.model.FooterItemRepository;
import com.vcms.content.model.HeaderItemRepository;
import com.vcms.content.model.HighlightItemRepository;
import com.vcms.content.model.JumbotronItemRepository;
import com.vcms.content.model.LinkItemRepository;
import com.vcms.content.model.MediaItemRepository;
import com.vcms.content.model.ParagraphItemRepository;
import com.vcms.content.model.TitleItemRepository;
import com.vcms.design.model.DesignComponent;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private ContactInfoItemRepository contactInfoItemRepository;
	@Autowired
	private FeedItemRepository feedItemRepository;
	@Autowired
	private FooterItemRepository footerItemRepository;
	@Autowired
	private HeaderItemRepository headerItemRepository;
	@Autowired
	private HighlightItemRepository highlightItemRepository;
	@Autowired
	private JumbotronItemRepository jumbotronItemRepository;
	@Autowired
	private LinkItemRepository linkItemRepository;
	@Autowired
	private ContentModelRepository navigationService;
	@Autowired
	private MediaItemRepository mediaItemRepository;
	@Autowired
	private ParagraphItemRepository paragraphItemRepository;
	@Autowired
	private TitleItemRepository titleItemRepository;
	
	private Map<Component, ContentModelRepository> repositoryMap;
	
	@PostConstruct
	public void init() {
		repositoryMap = new HashMap<>();
		repositoryMap.put(Component.ContactInfos, contactInfoItemRepository);
		repositoryMap.put(Component.Feed, feedItemRepository);
		repositoryMap.put(Component.Footer, footerItemRepository);
		repositoryMap.put(Component.Header, headerItemRepository);
		repositoryMap.put(Component.Highlights, highlightItemRepository);
		repositoryMap.put(Component.Jumbotron, jumbotronItemRepository);
		repositoryMap.put(Component.Links, linkItemRepository);
		repositoryMap.put(Component.Navigation, navigationService);
		repositoryMap.put(Component.Medias, mediaItemRepository);
		repositoryMap.put(Component.Paragraphs, paragraphItemRepository);
		repositoryMap.put(Component.Titles, titleItemRepository);
	}
	
	@Override
	public List<ContentModel> getContentModels(DesignComponent designComponent) {
		ContentModelRepository repository = repositoryMap.get(designComponent.getComponent());
		if (repository != null) {
			return repository.getModelsForDesignComponent(designComponent);
		}
		return Collections.emptyList();
	}

}
