package com.vcms.web.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.user.model.User;
import com.vcms.web.admin.controller.AbstractTreeController;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.Fragment;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@RestController(value = Controller.AdminWebsitesGroups)
@RequestMapping(value = PageConst.AdminWebsitesGroups)
public class WebsitesGroupsController extends AbstractTreeController<User> {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		List<Website> allWebsites = websiteRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentMain().data().add("allWebsites", allWebsites);
		return response;
	}

	@Override
	public Response add() {
		User user = new User();
		Response response = new Response();
		response.fragmentDetails().data()
				.add("user", user)
				.add("languages", Language.values());
		return response;
	}
	
	@Override
	public Response edit(@PathVariable long modelId) {
		User user = null;
		if (modelId < 1) {
			user = new User();
		} else {
//			user = userRepository.getModel(modelId);
		}
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("user", user)
				.add("languages", Language.values());
		return response;
	}
	
	@Override
	public Response save(@RequestBody User user) {
//		userRepository.saveModel(user);
		Response response = new Response();   // if there are errors then call edit
		response.fragmentDetails().hide();
		response.setClickElement("table-search");
		return response;
	}
	
	@Override
	protected Fragment getFragment(Response response) {
		return response.fragmentMain();
	}

	@Override
	protected DbModelRepository<User> getDbModelRepository() {
		return null;// userRepository;
	}

}