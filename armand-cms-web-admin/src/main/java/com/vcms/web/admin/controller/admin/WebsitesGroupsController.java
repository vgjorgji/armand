package com.vcms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.web.admin.controller.AbstractPagingController;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController(value = Controller.AdminWebsitesGroups)
@RequestMapping(value = PageConst.AdminWebsitesGroups)
public class WebsitesGroupsController extends AbstractPagingController<User> {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		return pagingReset();
	}

	@Override
	public Response add() {
		User user = new User();
		Response response = new Response();
		response.detailsTemplate().data()
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
			user = userRepository.getModel(modelId);
		}
		
		Response response = new Response();
		response.detailsTemplate().data()
				.add("user", user)
				.add("languages", Language.values());
		return response;
	}
	
	@Override
	public Response save(@RequestBody User user) {
		userRepository.saveModel(user);
		Response response = new Response();   // if there are errors then call edit
		response.detailsTemplate().show(false);
		response.setClickElement("table-search");
		return response;
	}

	@Override
	protected DbModelRepository<User> getDbModelRepository() {
		return userRepository;
	}

}