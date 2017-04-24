package com.vcms.design.stub;

import org.springframework.stereotype.Repository;

import com.vcms.design.model.PageDesign;
import com.vcms.design.model.PageDesignRepository;

@Repository
public class PageDesignRepositoryStub implements PageDesignRepository {

	@Override
	public PageDesign getPageDesign(long pageId) {
		PageDesign pageDesign = null;
		if (pageId == 1000) {
			pageDesign = new PageDesign();
			pageDesign.setPageId(pageId);
			pageDesign.getLayout().setTop(true);
			pageDesign.getLayout().setRight(true);
			pageDesign.getLayout().setBottom(true);
			
		} else if (pageId == 1001) {
			pageDesign = new PageDesign();
			pageDesign.setPageId(pageId);
			pageDesign.getLayout().setTop(true);
			pageDesign.getLayout().setBottom(true);
		}
		return pageDesign;
	}
	
}
