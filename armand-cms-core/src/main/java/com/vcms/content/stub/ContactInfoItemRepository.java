package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import com.vcms.content.model.ContactInfoItem;
import com.vcms.content.model.ContentRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.persist.model.ContentModel;
import com.vcms.utils.StubUtils;

public class ContactInfoItemRepository implements ContentRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		List<ContentModel> result = new ArrayList<>();

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
		result.add(contactInfo);

		// result
		return result;
	}
	
}
