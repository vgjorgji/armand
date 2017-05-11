package com.vcms.web.admin.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vcms.conf.cms.CmsPackage;
import com.vcms.conf.cms.Font;
import com.vcms.conf.cms.ModernColor;
import com.vcms.conf.cms.Style;
import com.vcms.localization.model.Language;
import com.vcms.persist.model.DbModelRepository;
import com.vcms.user.model.PowerGroup;
import com.vcms.user.model.User;
import com.vcms.user.model.UserRepository;
import com.vcms.user.model.WebsiteUser;
import com.vcms.user.model.WebsiteUserRepository;
import com.vcms.web.admin.controller.AbstractPagingController;
import com.vcms.web.admin.model.Controller;
import com.vcms.web.admin.model.PageConst;
import com.vcms.web.admin.model.Response;
import com.vcms.web.admin.model.Fragment;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;
import com.vcms.website.model.WebsiteStatus;
import com.vcms.website.model.WebsiteView;
import com.vcms.website.model.WebsiteViewRepository;
import com.vcms.website.model.WebsiteViewType;

@RestController(value = Controller.AdminWebsites)
@RequestMapping(value = PageConst.AdminWebsites)
public class WebsitesController extends AbstractPagingController<Website> {
	
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WebsiteViewRepository websiteViewRepository;
	
	@Autowired
	private WebsiteUserRepository websiteUserRepository;
	
	
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public Response load() {
		return pagingReset();
	}

	@Override
	public Response add() {
		Website website = new Website();
		
		List<Company> allCompanies = companyRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("website", website)
				.add("allCompanies", allCompanies)
				.add("cmsPackages", CmsPackage.values())
				.add("allLanguages", Language.values())
				.add("statuses", WebsiteStatus.values());
		return response;
	}
	
	@Override
	public Response edit(@PathVariable long modelId) {
		Website website = null;
		if (modelId < 1) {
			website = new Website();
		} else {
			website = websiteRepository.getModel(modelId);
		}
		
		List<Company> allCompanies = companyRepository.getAllModels();
		
		Response response = new Response();
		response.fragmentDetails().data()
				.add("website", website)
				.add("allCompanies", allCompanies)
				.add("cmsPackages", CmsPackage.values())
				.add("allLanguages", Language.values())
				.add("statuses", WebsiteStatus.values());
		return response;
	}
	
	@Override
	public Response save(@RequestBody Website website) {
		boolean newWebsite = website.getId() == 0;
		websiteRepository.saveModel(website);
		
		// for new websites, link the masters with the website as Roots
		if (newWebsite) {
			List<User> masters = userRepository.getMasterUsers();
			for (User master : masters) {
				WebsiteUser websiteUser = new WebsiteUser();
				websiteUser.setUserId(master.getId());
				websiteUser.setWebsiteId(website.getId());
				websiteUser.setPowerGroup(PowerGroup.Roots);
				websiteUser.setLanguage(master.getLanguage());
				websiteUserRepository.saveModel(websiteUser);
			}
			for (WebsiteViewType viewType : WebsiteViewType.values()) {
				WebsiteView websiteView = new WebsiteView();
				websiteView.setViewType(viewType);
				websiteView.setWebsiteId(website.getId());
				websiteView.setStyle(Style.Default);
				websiteView.setColor(ModernColor.Default);
				websiteView.setSelectColor(ModernColor.Default);
				websiteView.setFont(Font.Default);
				websiteViewRepository.saveModel(websiteView);
			}
		}
		
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
	protected DbModelRepository<Website> getDbModelRepository() {
		return websiteRepository;
	}

}