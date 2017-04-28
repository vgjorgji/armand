package com.vcms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingSearch;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.web.admin.controller.AbstractPagingController;
import com.vcms.web.admin.controller.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController(value = Controller.AdminUsers)
@RequestMapping(value = PageConst.AdminUsers)
public class UsersController extends AbstractPagingController<User> {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Paging<User> paging = userRepository.getPagingModels(new PagingSearch());
		return createReponse(paging);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Response add() {
		User user = new User();
		Response response = new Response();
		response.template("template-details", "details").data().add("user", user);
		return response;
	}
	
	@RequestMapping(value = "/edit/{modelId}", method = RequestMethod.GET)
	public Response edit(@PathVariable long modelId) {
		User user = userRepository.getModel(modelId);
		Response response = new Response();
		response.template("template-details", "details").data().add("user", user);
		return response;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response save(@RequestBody User user) {
		userRepository.saveModel(user);
		return edit(user.getId());
	}


	@Override
	protected DbModelRepository<User> getDbModelRepository() {
		return userRepository;
	}

}