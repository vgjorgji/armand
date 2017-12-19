package com.armand.cms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.controller.AbstractTreeController;
import com.armand.cms.web.admin.model.PageConst;
import com.vcms.conf.cms.Icon;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Fetch;
import com.vcms.user.model.PowerGroup;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.user.model.WebsiteGroup;
import com.vcms.user.model.WebsiteGroupRepository;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;
import com.armand.cms.web.admin.model.tree.MainNode;
import com.armand.cms.web.admin.model.tree.Node;
import com.armand.cms.web.admin.model.tree.SubNode;
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
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public Response addMainNode() {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	public Response editMainNode(@PathVariable long mainNodeId) {
		throw new UnsupportedOperationException("This operation is not supported");
	}

	@Override
	public Response saveMainNode(@RequestBody Website mainNode) {
		throw new UnsupportedOperationException("This operation is not supported");
	}
	
	@Override
	public Response deleteMainNode(@PathVariable long modelId) {
		throw new UnsupportedOperationException("This operation is not supported");
	}
	

	@Override
	public Response addNode(@PathVariable long mainNodeId) {
		// node
		WebsiteGroup websiteGroup = new WebsiteGroup();
		websiteGroup.setWebsiteId(mainNodeId);
		
		// response
		Response response = new Response();
		response.fragmentNode().data().add("websiteGroup", websiteGroup);
		response.fragmentSubNode().hide();
		return response;
	}

	@Override
	public Response editNode(@PathVariable long mainNodeId, @PathVariable long nodeId) {
		// models
		WebsiteGroup websiteGroup = getNodeRepository().getModel(nodeId);

		// response
		Response response = new Response();
		response.fragmentNode().data().add("websiteGroup", websiteGroup);
		response.fragmentSubNode().hide();
		return response;
	}

	@Override
	public Response saveNode(@PathVariable long mainNodeId, @RequestBody WebsiteGroup node) {
		getNodeRepository().saveModel(node);
		Response response = new Response();   // if there are errors then call edit
		response.fragmentNode().hide();
		response.setClickElement("table-search");
		return response;
	}


	@Override
	public Response addSubNode(@PathVariable long mainNodeId, 
			@PathVariable long nodeId) {
		// models
		Fetch<User> allUsers = userRepository.getAllModels();
		
		// sub node
		WebsiteUser websiteUser = new WebsiteUser();
		websiteUser.setWebsiteId(mainNodeId);
		websiteUser.setWebsiteGroupId(nodeId);
		
		// response
		Response response = new Response();
		response.fragmentNode().hide();
		response.fragmentSubNode().data()
				.add("allUsers", allUsers.getModels())
				.add("allLanguages", Language.values())
				.add("powerGroups", PowerGroup.values())
				.add("websiteUser", websiteUser);
		return response;
	}

	@Override
	public Response editSubNode(@PathVariable long mainNodeId, 
			@PathVariable long nodeId,
			@PathVariable long subNodeId) {
		// models
		Fetch<User> allUsers = userRepository.getAllModels();
		WebsiteUser websiteUser = getSubNodeRepository().getModel(subNodeId);

		// response
		Response response = new Response();
		response.fragmentNode().hide();
		response.fragmentSubNode().data()
				.add("allUsers", allUsers.getModels())
				.add("allLanguages", Language.values())
				.add("powerGroups", PowerGroup.values())
				.add("websiteUser", websiteUser);
		return response;
	}

	@Override
	public Response saveSubNode(@PathVariable long mainNodeId, 
			@PathVariable long nodeId, 
			@RequestBody WebsiteUser subNode) {
		getSubNodeRepository().saveModel(subNode);
		Response response = new Response();   // if there are errors then call edit
		response.fragmentSubNode().hide();
		response.setClickElement("table-search");
		return response;
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
		subNode.setTitle(subNodeModel.getPowerGroup().name());
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
