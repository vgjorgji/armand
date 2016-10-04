package com.vcms.website.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.utils.StubUtils;
import com.vcms.website.model.WebsiteVeiwRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@Repository
public class WebsiteViewStubRepository implements WebsiteVeiwRepository {

	private WebsiteView websiteView;
	
	@PostConstruct
	public void init() {
		websiteView = StubUtils.createStubDbModel(new WebsiteView(), 1000);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Live);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
	}
	
	@Override
	public WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType) {
		return websiteView;
	}
	
}
