package com.vcms.web.admin.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingSearch;
import com.vcms.web.admin.model.response.Response;

public abstract class AbstractTableController<T extends DbModel> extends AbstractPagingController<T> {
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public abstract Response add();
	
	
	@RequestMapping(value = "/edit/{modelId}", method = RequestMethod.GET)
	public abstract Response edit(@PathVariable long modelId);
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public abstract Response save(@RequestBody T user);
	
	
	@RequestMapping(value = "/delete/{modelId}", method = RequestMethod.POST)
	public Response delete(@PathVariable long modelId) {
		getDbModelRepository().deleteModel(modelId);
		Response response = new Response();
		response.fragmentDetails().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public Response cancel() {
		Response response = new Response();
		response.fragmentDetails().hide();
		return response;
	}
	
	
	@Override
	protected Paging<T> getPagingModels(PagingSearch pagingSearch) {
		return getDbModelRepository().getPagingModels(pagingSearch);
	}
	
	protected abstract DbModelRepository<T> getDbModelRepository();
	
}
