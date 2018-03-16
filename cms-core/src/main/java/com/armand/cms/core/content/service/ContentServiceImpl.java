package com.armand.cms.core.content.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.armand.cms.core.conf.Component;
import com.armand.cms.core.content.model.ContactInfoItemRepository;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.ContentModelRepository;
import com.armand.cms.core.content.model.FeedItemRepository;
import com.armand.cms.core.content.model.FooterItemRepository;
import com.armand.cms.core.content.model.HeaderItemRepository;
import com.armand.cms.core.content.model.HighlightItemRepository;
import com.armand.cms.core.content.model.JumbotronItemRepository;
import com.armand.cms.core.content.model.LinkItemRepository;
import com.armand.cms.core.content.model.MediaItemRepository;
import com.armand.cms.core.content.model.ParagraphItemRepository;
import com.armand.cms.core.content.model.TitleItemRepository;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.website.model.WebsiteViewType;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

  private final ContactInfoItemRepository contactInfoItemRepository;
  private final FeedItemRepository feedItemRepository;
  private final FooterItemRepository footerItemRepository;
  private final HeaderItemRepository headerItemRepository;
  private final HighlightItemRepository highlightItemRepository;
  private final JumbotronItemRepository jumbotronItemRepository;
  private final LinkItemRepository linkItemRepository;
  private final NavigationService navigationService;
  private final MediaItemRepository mediaItemRepository;
  private final ParagraphItemRepository paragraphItemRepository;
  private final TitleItemRepository titleItemRepository;

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
    repositoryMap.put(Component.Medias, mediaItemRepository);
    repositoryMap.put(Component.Paragraphs, paragraphItemRepository);
    repositoryMap.put(Component.Titles, titleItemRepository);
  }

  @Override
  public List<ContentModel> getContentModels(long websiteId, WebsiteViewType websiteViewType, DesignComponent designComponent) {
    List<ContentModel> result;
    if (Component.Navigation == designComponent.getComponent()) {
      result = new ArrayList<>(navigationService.getCompleteNavigationForWebsite(websiteId, websiteViewType));
    } else {
      ContentModelRepository repository = repositoryMap.get(designComponent.getComponent());
      if (repository != null) {
        result = repository.getModelsForDesignComponent(designComponent);
      } else {
        result = Collections.emptyList();
      }
    }
    return result;
  }

}
