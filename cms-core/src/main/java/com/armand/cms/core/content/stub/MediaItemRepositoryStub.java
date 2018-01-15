package com.armand.cms.core.content.stub;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.content.model.MediaItem;
import com.armand.cms.core.content.model.MediaItemRepository;
import com.armand.cms.core.design.model.DesignComponent;

@Repository
public class MediaItemRepositoryStub implements MediaItemRepository {

  @Override
  public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
    return Collections.emptyList();
  }

  @Override
  public List<MediaItem> getModels(long designComponentId) {
    return null;
  }

}
