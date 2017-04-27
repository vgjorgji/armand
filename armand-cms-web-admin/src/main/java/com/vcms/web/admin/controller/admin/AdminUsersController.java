package com.vcms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.persist.model.Paging;
import com.vcms.persist.model.PagingResult;
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
		
		PagingResult<User> paging = userRepository.getPagingModels(new Paging());
		
		response.mainTemplate().data()
				.add("paging", paging);
		return response;
	}

}