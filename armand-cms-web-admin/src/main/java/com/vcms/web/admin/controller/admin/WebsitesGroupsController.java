package com.vcms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.Icon;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Fetch;
import com.vcms.user.model.WebsiteGroup;
import com.vcms.user.model.WebsiteGroupRepository;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.web.admin.controller.AbstractTreeController;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.response.Fragment;
import com.vcms.web.admin.model.response.Response;
import com.vcms.web.admin.model.tree.MainNode;
import com.vcms.web.admin.model.tree.Node;
import com.vcms.web.admin.model.tree.SubNode;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController(value = Controller.AdminWebsitesGroups)
@RequestMapping(value = PageConst.AdminWebsitesGroups)
public class WebsitesGroupsController extends AbstractTreeController<Website, WebsiteGroup, WebsiteUser> {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private WebsiteGroupRepository websiteGroupRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;

	
	@Override
	public Response addMainNode() {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	public Response editMainNode(long mainNodeId) {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	public Response saveMainNode(Website mainNode) {
		throw new UnsupportedOperationException("This operation is not supported");
	}
	
	@Override
	public Response deleteMainNode(long modelId) {
		throw new UnsupportedOperationException("This operation is not supported");
	}
	

	@Override
	public Response addNode(long mainNodeId) {
		// main node
		Website website = getMainNodeRepository().getModel(mainNodeId);
		MainNode mainNode = createMainNode(website);
		
		// node
		Node node = new Node();
		
		// response
		Response response = new Response();
		response.fragmentNode().data()
				.add("mainNode", mainNode)
				.add("node", node);
		return response;
	}

	@Override
	public Response editNode(long mainNodeId, long nodeId) {
		Fetch<Website> allWebsites = getMainNodeRepository().getAllModels();
		WebsiteGroup websiteGroup = getNodeRepository().getModel(nodeId);

		// response
		Response response = new Response();
		response.fragmentNode().data()
				.add("allWebsites", allWebsites.getModels())
				.add("websiteGroup", websiteGroup);
		return response;
	}

	@Override
	public Response saveNode(long mainNodeId, WebsiteGroup node) {
		getNodeRepository().saveModel(node);
		Response response = new Response();   // if there are errors then call edit
		response.fragmentNode().hide();
		response.setClickElement("table-search");
		return response;
	}


	@Override
	public Response addSubNode(long mainNodeId, long nodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response editSubNode(long mainNodeId, long nodeId, long subNodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response saveSubNode(long mainNodeId, long nodeId, WebsiteUser subNode) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	protected MainNode createMainNode(Website mainNodeModel) {
		MainNode mainNode = new MainNode();
		mainNode.setId(mainNodeModel.getId());
		mainNode.setTitle(mainNodeModel.getName());
		return mainNode;
	}

	@Override
	protected long getNodeParentId(WebsiteGroup nodeModel) {
		return nodeModel.getWebsiteId();
	}

	@Override
	protected Node createNode(WebsiteGroup nodeModel) {
		Node node = new Node();
		node.setId(nodeModel.getId());
		node.setTitle(nodeModel.getName());
		node.setIcon(nodeModel.isMaster() ? Icon.UserSecret : null);
		return node;
	}

	@Override
	protected long getSubNodeParentId(WebsiteUser subNodeModel) {
		return subNodeModel.getWebsiteGroupId();
	}

	@Override
	protected SubNode createSubNode(WebsiteUser subNodeModel) {
		SubNode subNode = new SubNode();
		subNode.setId(subNodeModel.getId());
		subNode.setTitle("User");
		return subNode;
	}

	
	@Override
	protected DbModelRepository<Website> getMainNodeRepository() {
		return websiteRepository;
	}

	@Override
	protected DbModelRepository<WebsiteGroup> getNodeRepository() {
		return websiteGroupRepository;
	}

	@Override
	protected DbModelRepository<WebsiteUser> getSubNodeRepository() {
		return websiteUserRepository;
	}

	@Override
	protected Fragment getFragment(Response response) {
		return response.fragmentMain();
	}
	
}