package com.vcms.web.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.persist.model.DbModelRepository;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.web.admin.controller.AbstractPagingController;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.Fragment;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;

@RestController(value = Controller.AdminCompanies)
@RequestMapping(value = PageConst.AdminCompanies)
public class CompaniesController extends AbstractPagingController<Company> {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		return pagingReset();
	}
	

	@Override
	public Response add() {
		Company company = new Company();
		
		List<User> users = userRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("company", company)
				.add("allUsers", users);
		return response;
	}
	
	@Override
	public Response edit(@PathVariable long modelId) {
		Company company = null;
		if (modelId < 1) {
			company = new Company();
		} else {
			company = companyRepository.getModel(modelId);
		}
		
		List<User> users = userRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("company", company)
				.add("allUsers", users);
		return response;
	}
	
	@Override
	public Response save(@RequestBody Company company) {
		companyRepository.saveModel(company);
		Response response = new Response();   // if there are errors then call edit
		response.fragmentDetails().show(false);
		response.setClickElement("table-search");
		return response;
	}

	@Override
	protected Fragment getFragment(Response response) {
		return response.fragmentMain();
	}
	
	@Override
	protected DbModelRepository<Company> getDbModelRepository() {
		return companyRepository;
	}

}