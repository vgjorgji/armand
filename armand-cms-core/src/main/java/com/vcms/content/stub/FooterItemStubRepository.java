package com.vcms.content.stub;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.Icon;
import com.vcms.content.model.FooterItem;
import com.vcms.content.model.FooterItemRepository;
import com.vcms.design.model.DesignComponent;
import com.vcms.design.model.ExternalPage;
import com.vcms.persist.model.ContentModel;
import com.vcms.utils.StubUtils;

@Repository
public class FooterItemStubRepository implements FooterItemRepository {

	@Override
	public List<ContentModel> getModelsForDesignComponent(DesignComponent designComponent) {
		List<ContentModel> footer = new ArrayList<>();

		// facebook
		FooterItem footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		ExternalPage page = new ExternalPage();
		page.setIcon(Icon.Facebook);
		page.setUrl("https://www.facebook.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// twitter
		footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		page = new ExternalPage();
		page.setIcon(Icon.Twitter);
		page.setUrl("https://www.twitter.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// youtube
		footerItem = StubUtils.createStubDbModel(new FooterItem(), 1000);
		page = new ExternalPage();
		page.setIcon(Icon.Youtube);
		page.setUrl("https://www.youtube.com/");
		footerItem.setPage(page);
		footer.add(footerItem);
		
		// result
		return footer;
	}

	@Override
	public List<FooterItem> getModels(long designComponentId) {
		return null;
	}

}
