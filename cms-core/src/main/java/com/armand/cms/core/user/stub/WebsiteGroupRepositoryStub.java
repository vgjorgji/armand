package com.armand.cms.core.user.stub;

import java.util.Collection;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.user.model.WebsiteGroup;
import com.armand.cms.core.user.model.WebsiteGroupRepository;

@Repository
public class WebsiteGroupRepositoryStub
    extends HistoryModelRepositoryStub<WebsiteGroup>
    implements WebsiteGroupRepository {

  @PostConstruct
  public void init() {
    WebsiteGroup websiteUser = new WebsiteGroup();
    websiteUser.setWebsiteId(1000);
    websiteUser.setName("Group Masters");
    websiteUser.setMaster(true);
    saveModel(websiteUser);

    websiteUser = new WebsiteGroup();
    websiteUser.setWebsiteId(1000);
    websiteUser.setName("Group Users");
    saveModel(websiteUser);

    websiteUser = new WebsiteGroup();
    websiteUser.setWebsiteId(1001);
    websiteUser.setName("Group Masters");
    websiteUser.setMaster(true);
    saveModel(websiteUser);
  }

  @Override
  public Fetch<WebsiteGroup> getGroupsForWebsites(Collection<Long> websiteIds) {
    Fetch<WebsiteGroup> fetch = new Fetch<>();
    for (WebsiteGroup websiteGroup : getAllModels().getModels()) {
      if (websiteIds.contains(websiteGroup.getWebsiteId())) {
        fetch.put(websiteGroup.getId(), websiteGroup);
      }
    }
    return fetch;
  }

  @Override
  protected long getParentId(WebsiteGroup model, String parentField) {
    return model.getWebsiteId();
  }

  @Override
  protected boolean searchModel(WebsiteGroup model, String query) {
    String text = model.getId()
        + "%" + model.getName();
    return text.contains(query);
  }

}
