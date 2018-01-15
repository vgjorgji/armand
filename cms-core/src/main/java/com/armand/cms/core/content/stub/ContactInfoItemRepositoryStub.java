package com.armand.cms.core.content.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.armand.cms.core.conf.Component;
import com.armand.cms.core.content.model.ContactInfoItem;
import com.armand.cms.core.content.model.ContactInfoItemRepository;
import com.armand.cms.core.content.model.ContentModel;
import com.armand.cms.core.design.model.DesignComponent;
import com.armand.cms.core.localization.model.Language;
import com.armand.cms.core.localization.model.LocalText;
import com.armand.cms.core.localization.model.LocalTextType;
import com.armand.cms.core.utils.StubUtils;

@Repository
public class ContactInfoItemRepositoryStub implements ContactInfoItemRepository {

  @Override
  public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
    if (!Component.ContactInfos.equals(designComponent.getComponent())) {
      return Collections.emptyList();
    }
    return createResultList(new ArrayList<>());
  }

  @Override
  public List<ContactInfoItem> getModels(long designComponentId) {
    return createResultList(new ArrayList<>());
  }

  @SuppressWarnings("unchecked")
  private <T extends ContentModel> List<T> createResultList(List<T> list) {
    // footer
    ContactInfoItem contactInfo = StubUtils.createStubDbModel(new ContactInfoItem(), 1000);
    contactInfo.setLongitude(41.636513);
    contactInfo.setLatitude(22.467497);
    contactInfo.setAddress1(new LocalText(LocalTextType.Normal));
    contactInfo.getAddress1().addText(Language.English, "Coast 8th September, nr. 149");
    contactInfo.getAddress1().addText(Language.Macedonian, "Кеј 8-ми Септември, бр. 149");
    contactInfo.setAddress2(new LocalText(LocalTextType.Normal));
    contactInfo.getAddress2().addText(Language.English, "2420, Radovish, Macedonia");
    contactInfo.getAddress2().addText(Language.Macedonian, "2420, Радовиш, Македонија");
    contactInfo.setPhone1("+1 800 254 5478");
    contactInfo.setPhone2("+1 800 587 47895");
    contactInfo.setEmail("info@email.com");
    list.add((T) contactInfo);

    // result
    return list;
  }

}
