package com.armand.cms.core.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.HeaderItem;
import com.armand.cms.core.content.model.HeaderItemRepository;
import com.armand.cms.core.design.model.DesignComponent;

@Repository
public class HeaderItemRepositoryStub implements HeaderItemRepository {

  @Override
  public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
    return Collections.emptyList();
  }

  @Override
  public List<HeaderItem> getModels(long designComponentId) {
    return null;
  }

}
