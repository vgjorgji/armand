package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.content.model.ContentModel;
import com.vcms.content.model.Title;
import com.vcms.content.model.TitleItem;
import com.vcms.content.model.TitleItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.TextUtils;

@Repository
public class TitleItemRepositoryStub implements TitleItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		List<ContentModel> result = new ArrayList<>();
		if (designComponent.getId() == 1005) {
			result.add(createTitleItem("Gallery", "Галерија"));
		} else if (designComponent.getId() == 1007) {
			result.add(createTitleItem("News", "Новости"));
		} else if (designComponent.getId() == 1009) {
			result.add(createTitleItem("Popular", "Популарни"));
		} else if (designComponent.getId() == 1012) {
			result.add(createTitleItem("How to find us", "Како да не најдете"));
		}
		return result;
	}

	@Override
	public List<TitleItem> getModels(long designComponentId) {
		return null;
	}
	
	private TitleItem createTitleItem(String enText, String mkText) {
		TitleItem titleItem = new TitleItem();
		titleItem.setTitle(createTitle(enText, mkText));
		return titleItem;
	}
	
	private Title createTitle(String enText, String mkText) {
		Title title = new Title();
		title.setText(TextUtils.createLocalText(LocalTextType.Normal, enText, mkText));
		return title;
	}
	
}
