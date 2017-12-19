package com.armand.cms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.controller.AbstractTableController;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;

@RestController(value = Controller.AdminUsers)
@RequestMapping(value = PageConst.AdminUsers)
public class UsersController extends AbstractTableController<User> {
	
	@Autowired
	private UserRepository userRepository;
	
	
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
			user = userRepository.getModel(modelId);
		}
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("user", user)
				.add("languages", Language.values());
		return response;
	}
	
	@Override
	public Response save(@RequestBody User user) {
		userRepository.saveModel(user);
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
		return userRepository;
	}

}
