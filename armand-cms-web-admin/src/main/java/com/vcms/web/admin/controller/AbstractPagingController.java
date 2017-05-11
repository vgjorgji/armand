package com.vcms.web.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingSearch;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.Fragment;

public abstract class AbstractPagingController<T extends DbModel> extends AbstractTableController<T> {
	
	@RequestMapping(value = "/paging/reset", method = RequestMethod.GET)
	public Response pagingReset() {
		Paging<T> pagingResult = getDbModelRepository().getPagingModels(new PagingSearch());
		return createReponse(pagingResult);
	}
	
	
	@RequestMapping(value = "/paging/search", method = RequestMethod.GET)
	public Response pagingSearch(@RequestParam String query, @RequestParam int size) {
		PagingSearch pagingSearch = new PagingSearch();
		pagingSearch.setQuery(query);
		pagingSearch.setSize(size);
		Paging<T> paging = getDbModelRepository().getPagingModels(pagingSearch);
		return createReponse(paging);
	}
	
	
	@RequestMapping(value = "/paging/previous", method = RequestMethod.GET)
	public Response pagingPrevious(@RequestParam String query, @RequestParam int size, @RequestParam int page) {
		PagingSearch pagingSearch = new PagingSearch();
		pagingSearch.setQuery(query);
		pagingSearch.setSize(size);
		pagingSearch.setPage(page - 1);
		Paging<T> pagingResult = getDbModelRepository().getPagingModels(pagingSearch);
		return createReponse(pagingResult);
	}
	
	
	@RequestMapping(value = "/paging/page", method = RequestMethod.GET)
	public Response pagingPage(@RequestParam String query, @RequestParam int size, @RequestParam int page) {
		PagingSearch pagingSearch = new PagingSearch();
		pagingSearch.setQuery(query);
		pagingSearch.setSize(size);
		pagingSearch.setPage(page);
		Paging<T> pagingResult = getDbModelRepository().getPagingModels(pagingSearch);
		return createReponse(pagingResult);
	}
	
	
	@RequestMapping(value = "/paging/next", method = RequestMethod.GET)
	public Response pagingNext(@RequestParam String query, @RequestParam int size, @RequestParam int page) {
		PagingSearch pagingSearch = new PagingSearch();
		pagingSearch.setQuery(query);
		pagingSearch.setSize(size);
		pagingSearch.setPage(page + 1);
		Paging<T> pagingResult = getDbModelRepository().getPagingModels(pagingSearch);
		return createReponse(pagingResult);
	}
	
	
	protected Response createReponse(Paging<T> paging) {
		Response response = new Response();
		Fragment fragment = getFragment(response);
		fragment.data().add("paging", paging);
		return response;
	}
	
	protected abstract Fragment getFragment(Response response);
	
}
