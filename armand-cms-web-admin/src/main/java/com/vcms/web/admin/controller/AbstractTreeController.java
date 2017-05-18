package com.vcms.web.admin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcms.persist.model.DbModel;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Fetch;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingSearch;
import com.vcms.web.admin.model.response.Response;
import com.vcms.web.admin.model.tree.Tree;

public abstract class AbstractTreeController<T, M extends DbModel, N extends DbModel, S extends DbModel> 
		extends AbstractPagingController<T> {
	
	@RequestMapping(value = "/main-node/add", method = RequestMethod.GET)
	public abstract Response addMainNode();
	
	@RequestMapping(value = "/main-node/edit/{modelId}", method = RequestMethod.GET)
	public abstract Response editMainNode(@PathVariable long mainNodeId);
	
	@RequestMapping(value = "/main-node/save", method = RequestMethod.POST)
	public abstract Response saveMainNode(@RequestBody M mainNode);
	
	
	@RequestMapping(value = "/node/add", method = RequestMethod.GET)
	public abstract Response addNode();
	
	@RequestMapping(value = "/node/edit/{modelId}", method = RequestMethod.GET)
	public abstract Response editNode(@PathVariable long nodeId);
	
	@RequestMapping(value = "/node/save", method = RequestMethod.POST)
	public abstract Response saveNode(@RequestBody N node);
	
	
	@RequestMapping(value = "/sub-node/add", method = RequestMethod.GET)
	public abstract Response addSubNode();
	
	@RequestMapping(value = "/sub-node/edit/{modelId}", method = RequestMethod.GET)
	public abstract Response editSubNode(@PathVariable long subNodeId);
	
	@RequestMapping(value = "/sub-node/save", method = RequestMethod.POST)
	public abstract Response saveSubNode(@RequestBody S subNode);
	
	
	@RequestMapping(value = "/main-node/delete/{modelId}", method = RequestMethod.POST)
	public Response deleteMainNode(@PathVariable long modelId) {
		getMainNodeRepository().deleteModel(modelId);
		Response response = new Response();
		response.fragmentMainNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	@RequestMapping(value = "/node/delete/{modelId}", method = RequestMethod.POST)
	public Response deleteNode(@PathVariable long modelId) {
		getNodeRepository().deleteModel(modelId);
		Response response = new Response();
		response.fragmentNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	@RequestMapping(value = "/sub-node/delete/{modelId}", method = RequestMethod.POST)
	public Response deleteSubNode(@PathVariable long modelId) {
		getSubNodeRepository().deleteModel(modelId);
		Response response = new Response();
		response.fragmentSubNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	
	@RequestMapping(value = "/cancel", method = RequestMethod.GET)
	public Response cancel() {
		Response response = new Response();
		response.fragmentMainNode().hide();
		response.fragmentNode().hide();
		response.fragmentSubNode().hide();
		return response;
	}
	
	
	@Override
	protected Paging<T> getPagingModels(PagingSearch pagingSearch) {
		// page main-nodes
		Paging<M> mainNodePaging = getMainNodeRepository().getPagingModels(pagingSearch);
		
		// fetch nodes and sub-nodes
		Fetch<M> mainNodesFetch = mainNodePaging.getFetch();
		Fetch<N> nodesFetch = getNodeRepository().getModels(mainNodesFetch.listIds(), null);
		Fetch<S> subNodesFetch = getSubNodeRepository().getModels(nodesFetch.listIds(), null);
		
		// construct tree
		Tree tree = new Tree();
		// TODO create the tree
		
		Paging<T> paging = new Paging<>();
		// TODO clone the mainNodePaging
		
		// TODO convert tree to paging
		return paging;
	}
	

	protected abstract DbModelRepository<M> getMainNodeRepository();
	
	protected abstract DbModelRepository<N> getNodeRepository();
	
	protected abstract DbModelRepository<S> getSubNodeRepository();
	
}
