package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.Icon;
import com.vcms.content.model.ContentModel;
import com.vcms.content.model.HighlightItem;
import com.vcms.content.model.HighlightItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.StubUtils;

@Repository
public class HighlightItemStubRepository implements HighlightItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		List<ContentModel> highlights = new ArrayList<>();

		// 1
		HighlightItem highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1000);
		highlightItem.setIcon(Icon.Education);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Education");
		highlightItem.getTitle().addText(Language.Macedonian, "Образование");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 2
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1001);
		highlightItem.setIcon(Icon.Heart);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Support");
		highlightItem.getTitle().addText(Language.Macedonian, "Подршка");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 3
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1002);
		highlightItem.setIcon(Icon.Star);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Guarantee");
		highlightItem.getTitle().addText(Language.Macedonian, "Гаранција");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// 4
		highlightItem = StubUtils.createStubDbModel(new HighlightItem(), 1003);
		highlightItem.setIcon(Icon.Like);
		highlightItem.setTitle(new LocalText(LocalTextType.Small));
		highlightItem.getTitle().addText(Language.English, "Reliability");
		highlightItem.getTitle().addText(Language.Macedonian, "Веродостојност");
		highlightItem.setText(new LocalText(LocalTextType.Small));
		highlightItem.getText().addText(Language.English,
				"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque explicabo.");
		highlightItem.getText().addText(Language.Macedonian,
				"Содржина на македонски јазик. Оваа е обичен текст за да поплни место и да се добие изглед.");
		highlights.add(highlightItem);

		// result
		return highlights;
	}

	@Override
	public List<HighlightItem> getModels(long designComponentId) {
		return null;
	}

}
