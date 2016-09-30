package com.vcms.website.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.utils.Utils;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;

@Repository
public class CompanyStubRepository implements CompanyRepository {

	private Company company;
	
	@PostConstruct
	public void init() {
		company = Utils.createStubDbModel(new Company(), 1000);
		company.setName("Demo Company");
		company.setAddress1("st. 'Demo Street', nr. 1000");
		company.setAddress2("City, Contry");
		company.setPhone1("XXX 123 456 789");
		company.setPhone2("XXX 009 456 789");
		company.setEmail("demo.company@email.com");
		company.setContactName("Demo Contact Person");
		company.setContactPhone("XXX 001 456 789");
		company.setContactEmail("demo.company.person@email.com");
	}
	
	@Override
	public Company getCompany(long id) {
		return company;
	}

}
