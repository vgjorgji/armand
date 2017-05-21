package com.vcms.website.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewRepository;
import com.vcms.website.model.WebsiteViewType;

@Repository
public class WebsiteViewRepositoryStub 
		extends HistoryModelRepositoryStub<WebsiteView>
		implements WebsiteViewRepository {

	@PostConstruct
	public void init() {
		WebsiteView websiteView = new WebsiteView();
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Design);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		saveModel(websiteView);
		
		websiteView = new WebsiteView();
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Content);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		saveModel(websiteView);
		
		websiteView = new WebsiteView();
		websiteView.setWebsiteId(1000);
		websiteView.setViewType(WebsiteViewType.Live);
		websiteView.setStyle(Style.BlackLight);
		websiteView.setColor(ModernColor.BelizeHole);
		websiteView.setSelectColor(ModernColor.Deseartured);
		websiteView.setFont(Font.PtSansNarrow);
		saveModel(websiteView);
	}
	
	@Override
	public WebsiteView getModel(long websiteId, WebsiteViewType viewType) {
		for (WebsiteView websiteView : getAllModels().getModels()) {
			if (websiteView.getWebsiteId() == websiteId && websiteView.getViewType() == viewType) {
				return websiteView;
			}
		}
		return null;
	}

	@Override
	protected void merge(WebsiteView current, WebsiteView model) {
		super.merge(current, model);
		model.setWebsiteId(current.getWebsiteId());
		model.setViewType(current.getViewType());
	}

}
