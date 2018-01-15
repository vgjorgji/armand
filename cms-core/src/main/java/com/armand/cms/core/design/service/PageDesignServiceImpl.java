package com.armand.cms.core.design.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.armand.cms.core.content.service.ContentService;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.design.model.DesignComponentRepository;
import com.armand.cms.core.design.model.PageDesign;
import com.armand.cms.core.design.model.PageDesignRepository;
import com.armand.cms.core.website.model.Website;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PageDesignServiceImpl implements PageDesignService {

  private final PageDesignRepository pageDesignRepository;
  private final DesignComponentRepository designComponentRepository;
  private final ContentService contentService;

  @Override
  public PageDesign getPageDesign(long pageId, Website website) {
    // get and check
    PageDesign pageDesign = pageDesignRepository.getPageDesign(pageId);
    if (pageDesign != null) {

      // load
      List<DesignComponent> designComponents = designComponentRepository.getDesignComponents(pageDesign.getPageId());

      // filter
      for (DesignComponent designComponent : designComponents) {
        if (website.getCmsPackage().isComponentSupported(designComponent.getComponent())) {

          // load content models
          designComponent.setContentModels(contentService.getContentModels(designComponent));
          pageDesign.addDesignComponent(designComponent);
        }
      }
    }

    // result
    return pageDesign;
  }

}
