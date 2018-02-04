package com.armand.cms.web.admin.controller.admin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armand.cms.core.persist.model.DbModelRepository;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.user.model.User;
import com.armand.cms.core.user.model.UserRepository;
import com.armand.cms.core.website.model.Company;
import com.armand.cms.core.website.model.CompanyRepository;
import com.armand.cms.web.admin.controller.AbstractTableController;
import com.armand.cms.web.admin.model.Controller;
import com.armand.cms.web.admin.model.PageConst;
import com.armand.cms.web.admin.model.response.Fragment;
import com.armand.cms.web.admin.model.response.Response;
import lombok.RequiredArgsConstructor;

@RestController(value = Controller.AdminCompanies)
@RequestMapping(value = PageConst.AdminCompanies)
@RequiredArgsConstructor
public class CompaniesController extends AbstractTableController<Company> {

  private final CompanyRepository companyRepository;
  private final UserRepository userRepository;

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
    Company company;
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
