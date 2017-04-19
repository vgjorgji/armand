package com.vcms.website.stub;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.utils.StubUtils;
import com.vcms.website.model.WebsiteViewRepository;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewType;

@Repository
public class WebsiteViewStubRepository implements WebsiteViewRepository {

	private List<WebsiteView> list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		WebsiteView websiteView = StubUtils.createStubDbModel(new WebsiteView(), list.size() + 1000);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Design);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		list.add(websiteView);
		
		websiteView = StubUtils.createStubDbModel(new WebsiteView(), list.size() + 1000);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Content);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		list.add(websiteView);
		
		websiteView = StubUtils.createStubDbModel(new WebsiteView(), list.size() + 1000);
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Live);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		list.add(websiteView);
	}
	
	@Override
	public WebsiteView getWebsiteView(long websiteViewId) {
		for (WebsiteView websiteView : list) {
			if (websiteView.getId() == websiteViewId) {
				return websiteView;
			}
		}
		return null;
	}

	@Override
	public WebsiteView getWebsiteView(long websiteId, WebsiteViewType viewType) {
		for (WebsiteView websiteView : list) {
			if (websiteView.getWebsiteId() == websiteId && websiteView.getViewType() == viewType) {
				return websiteView;
			}
		}
		return null;
	}
	
	@Override
	public void save(WebsiteView websiteView) {
		if (websiteView.getId() == 0) {
			websiteView.setId(list.size() + 1000L);
			list.add(websiteView);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId() == websiteView.getId()) {
					list.set(i, websiteView);
					break;
				}
			}
		}
	}
	
}
