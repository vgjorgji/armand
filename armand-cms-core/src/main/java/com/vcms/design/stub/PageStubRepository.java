package com.vcms.design.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.design.model.CmsPage;
import com.vcms.design.model.PageRepository;
import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.Utils;

@Repository
public class PageStubRepository implements PageRepository {

	private CmsPage page;
	
	@PostConstruct
	public void init() {
		page = Utils.createStubDbModel(new CmsPage(), 1000);
		page.setWebsiteViewId(1000);
		page.setUrl("home");
		page.getLayout().setTop(true);
		page.getLayout().setRight(true);
		page.getLayout().setBottom(true);
		page.setTitle(new LocalText(LocalTextType.Small));
		page.getTitle().addText(Language.English, "Home");
		page.getTitle().addText(Language.Macedonian, "Почетна");
	}
	
	@Override
	public CmsPage getCmsPage(long websiteViewId, String name) {
		page.clearDesignComponents();
		return page;
	}

}
