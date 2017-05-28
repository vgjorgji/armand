package com.vcms.web.admin.controller;

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
import com.vcms.web.admin.model.tree.MainNode;
import com.vcms.web.admin.model.tree.Node;
import com.vcms.web.admin.model.tree.SubNode;

public abstract class AbstractTreeController<M extends DbModel, N extends DbModel, S extends DbModel> 
		extends AbstractPagingController<MainNode> {
	
	@RequestMapping(value = "/tree/node/add", method = RequestMethod.GET)
	public abstract Response addMainNode();
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/edit", method = RequestMethod.GET)
	public abstract Response editMainNode(@PathVariable long mainNodeId);
	
	@RequestMapping(value = "/tree/node/save", method = RequestMethod.POST)
	public abstract Response saveMainNode(@RequestBody M mainNode);
	
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/add", method = RequestMethod.GET)
	public abstract Response addNode(@PathVariable long mainNodeId);
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/edit", method = RequestMethod.GET)
	public abstract Response editNode(@PathVariable long mainNodeId, @PathVariable long nodeId);
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/save", method = RequestMethod.POST)
	public abstract Response saveNode(@PathVariable long mainNodeId, @RequestBody N node);
	
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/add", method = RequestMethod.GET)
	public abstract Response addSubNode(@PathVariable long mainNodeId, 
			@PathVariable long nodeId);
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/{subNodeId}/edit", method = RequestMethod.GET)
	public abstract Response editSubNode(@PathVariable long mainNodeId, 
			@PathVariable long nodeId,
			@PathVariable long subNodeId);
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/save", method = RequestMethod.POST)
	public abstract Response saveSubNode(@PathVariable long mainNodeId,
			@PathVariable long nodeId,
			@RequestBody S subNode);
	
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/delete", method = RequestMethod.POST)
	public Response deleteMainNode(@PathVariable long mainNodeId) {
		getMainNodeRepository().deleteModel(mainNodeId);
		Response response = new Response();
		response.fragmentMainNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/delete", method = RequestMethod.POST)
	public Response deleteNode(@PathVariable long nodeId) {
		getNodeRepository().deleteModel(nodeId);
		Response response = new Response();
		response.fragmentNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	@RequestMapping(value = "/tree/node/{mainNodeId}/{nodeId}/{subNodeId}/delete", method = RequestMethod.POST)
	public Response deleteSubNode(@PathVariable long subNodeId) {
		getSubNodeRepository().deleteModel(subNodeId);
		Response response = new Response();
		response.fragmentSubNode().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	
	@RequestMapping(value = "/tree/cancel", method = RequestMethod.GET)
	public Response cancel() {
		Response response = new Response();
		response.fragmentMainNode().hide();
		response.fragmentNode().hide();
		response.fragmentSubNode().hide();
		return response;
	}
	
	
	@Override
	protected Paging<MainNode> getPagingModels(PagingSearch pagingSearch) {
		// page main-nodes
		Paging<M> mainNodePaging = getMainNodeRepository().getPagingModels(pagingSearch);
		
		// fetch nodes and sub-nodes
		Fetch<M> mainNodesFetch = mainNodePaging.getFetch();
		Fetch<N> nodesFetch = getNodeRepository().getModels(mainNodesFetch.listIds(), null);
		Fetch<S> subNodesFetch = getSubNodeRepository().getModels(nodesFetch.listIds(), null);
		
		// clone paging with different models
		Paging<MainNode> paging = new Paging<>();
		paging.setPage(mainNodePaging.getPage());
		paging.setPageCount(mainNodePaging.getPageCount());
		paging.setSize(mainNodePaging.getSize());
		paging.setModelsStart(mainNodePaging.getModelsStart());
		paging.setModelsEnd(mainNodePaging.getModelsEnd());
		paging.setModelsCount(mainNodePaging.getModelsCount());
		paging.setQuery(mainNodePaging.getQuery());
		Fetch<MainNode> pagingFetch = new Fetch<>(mainNodesFetch.size());
		paging.setFetch(pagingFetch);
		
		// main nodes
		for (M mainNodeModel : mainNodesFetch.getModels()) {
			MainNode mainNode = createMainNode(mainNodeModel);
			pagingFetch.put(mainNode.getId(), mainNode);
			
			// nodes
			for (N nodeModel : nodesFetch.getModels()) {
				if (mainNode.getId() == getNodeParentId(nodeModel)) {
					Node node = createNode(nodeModel);
					mainNode.addNode(node);
					
					// sub nodes
					for (S subNodeModel : subNodesFetch.getModels()) {
						if (node.getId() == getSubNodeParentId(subNodeModel)) {
							node.addSubNode(createSubNode(subNodeModel));
						}
					}
				}
			}
		}

		// result
		return paging;
	}
	

	protected abstract MainNode createMainNode(M mainNodeModel);

	protected abstract long getNodeParentId(N nodeModel);

	protected abstract Node createNode(N nodeModel);

	protected abstract long getSubNodeParentId(S subNodeModel);

	protected abstract SubNode createSubNode(S subNodeModel);

	
	protected abstract DbModelRepository<M> getMainNodeRepository();
	
	protected abstract DbModelRepository<N> getNodeRepository();
	
	protected abstract DbModelRepository<S> getSubNodeRepository();
	
}
