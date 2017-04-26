package com.vcms.web.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;

@RestController
@RequestMapping(value = PageConst.AdminUsers)
public class AdminUsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		Response response = new Response();
		
		List<User> users = userRepository.getAllModels();
		
		response.mainTemplate().data()
				.add("users", users);
		return response;
	}

}