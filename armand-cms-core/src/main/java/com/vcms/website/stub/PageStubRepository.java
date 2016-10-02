package com.vcms.website.stub;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.vcms.localization.model.Language;
import com.vcms.localization.model.LocalText;
import com.vcms.localization.model.LocalTextType;
import com.vcms.utils.Utils;
import com.vcms.website.model.CmsPage;
import com.vcms.website.model.PageRepository;

@Repository
public class PageStubRepository implements PageRepository {
	
	@Override
	public CmsPage getCmsPage(long websiteViewId, String url) {
		if (StringUtils.equals("home", url)) {
			return createHomePage();
		}
		return null;
	}
	
	private CmsPage createHomePage() {
		CmsPage page = Utils.createStubDbModel(new CmsPage(), 1000);
		page.setWebsiteViewId(1000);
		page.setUrl("home");
		page.setTitle(new LocalText(LocalTextType.Small));
		page.getTitle().addText(Language.English, "Home");
		page.getTitle().addText(Language.Macedonian, "Почетна");
		//page.getLayout().setTop(true);
		//page.getLayout().setRight(true);
		//page.getLayout().setBottom(true);
		return page;
	}

}
