package com.vcms.website.stub;

import java.util.HashMap;
import java.util.Map;

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

	private Map<String, WebsiteView> map = new HashMap<>();
	
	@PostConstruct
	public void init() {
		WebsiteView websiteView = StubUtils.createStubDbModel(new WebsiteView(), 1000);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Design);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		map.put(websiteView.getWebsiteId() + "-" + websiteView.getViewType(), websiteView);
		
		websiteView = StubUtils.createStubDbModel(new WebsiteView(), 1001);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Content);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		map.put(websiteView.getWebsiteId() + "-" + websiteView.getViewType(), websiteView);
		
		websiteView = StubUtils.createStubDbModel(new WebsiteView(), 1002);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Live);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		map.put(websiteView.getWebsiteId() + "-" + websiteView.getViewType(), websiteView);
	}
	
	@Override
	public WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType) {
		return map.get(websiteId + "-" + viewType);
	}
	
	@Override
	public boolean save(WebsiteView websiteView) {
		return true;
	}
	
}
