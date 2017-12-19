package com.armand.cms.web.admin.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.web.admin.controller.AbstractTableController;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.persist.model.Fetch;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;

@RestController(value = Controller.AdminCompanies)
@RequestMapping(value = PageConst.AdminCompanies)
public class CompaniesController extends AbstractTableController<Company> {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public Response add() {
		Company company = new Company();
		
		Fetch<User> usersFetch = userRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("company", company)
				.add("allUsers", usersFetch.getModels());
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
		
		Fetch<User> usersFetch = userRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("company", company)
				.add("allUsers", usersFetch.getModels());
		return response;
	}
	
	@Override
	public Response save(@RequestBody Company company) {
		companyRepository.saveModel(company);
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
	protected DbModelRepository<Company> getDbModelRepository() {
		return companyRepository;
	}

}
