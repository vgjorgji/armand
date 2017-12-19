package com.armand.cms.core.website.stub;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.armand.cms.core.persist.stub.HistoryModelRepositoryStub;
import com.armand.cms.core.website.model.Company;
import com.armand.cms.core.website.model.CompanyRepository;

@Repository
public class CompanyRepositoryStub 
		extends HistoryModelRepositoryStub<Company> 
		implements CompanyRepository {
	
	@PostConstruct
	public void init() {
		Company company = new Company();
		company.setContactUserId(1000);
		company.setName("Demo Company");
		company.setAddress1("st. 'Demo Street', nr. 1000");
		company.setAddress2("City, Contry");
		company.setPhone1("XXX 123 456 789");
		company.setPhone2("XXX 009 456 789");
		company.setEmail("demo.company@email.com");
		saveModel(company);
	}

	@Override
	protected boolean searchModel(Company model, String query) {
		String text = model.getId() 
				+ "%" + model.getAddress1()
				+ "%" + model.getAddress2()
				+ "%" + model.getEmail() 
				+ "%" + model.getName()
				+ "%" + model.getPhone1() 
				+ "%" + model.getPhone2();
		return StringUtils.contains(text, query);
	}
	
}
