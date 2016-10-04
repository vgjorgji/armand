package com.vcms.website.stub;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.vcms.utils.StubUtils;
import com.vcms.website.model.Company;
import com.vcms.website.model.CompanyRepository;

@Repository
public class CompanyStubRepository implements CompanyRepository {

	private Company company;
	
	@PostConstruct
	public void init() {
		company = StubUtils.createStubDbModel(new Company(), 1000);
		company.setName("Demo Company");
		company.setAddress1("st. 'Demo Street', nr. 1000");
		company.setAddress2("City, Contry");
		company.setPhone1("XXX 123 456 789");
		company.setPhone2("XXX 009 456 789");
		company.setEmail("demo.company@email.com");
	}
	
	@Override
	public Company getCompany(long id) {
		return company;
	}

}
