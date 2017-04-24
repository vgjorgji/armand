package com.vcms.website.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.persist.stub.HistoryModelRepositoryStub;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;

@Repository
public class CompanyRepositoryStub 
		extends HistoryModelRepositoryStub<Company> 
		implements CompanyRepository {
	
	@PostConstruct
	public void init() {
		Company company = new Company();
		company.setName("Demo Company");
		company.setAddress1("st. 'Demo Street', nr. 1000");
		company.setAddress2("City, Contry");
		company.setPhone1("XXX 123 456 789");
		company.setPhone2("XXX 009 456 789");
		company.setEmail("demo.company@email.com");
		saveModel(company);
	}
	
	@Override
	protected void merge(Company current, Company model) {
		model.setContactUser(current.getContactUser());
	}
	
}
