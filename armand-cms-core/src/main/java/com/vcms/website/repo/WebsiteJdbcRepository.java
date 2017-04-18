package com.vcms.website.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@Repository
public class WebsiteJdbcRepository implements WebsiteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Website getWebsite(long websiteId) {
		return null;
	}

	@Override
	public Website getWebsite(String name) {
		return jdbcTemplate.queryForObject("select * from website where name = ?", new Object[] { name },
				new RowMapper<Website>() {

					@Override
					public Website mapRow(ResultSet rs, int rowNum) throws SQLException {
						Website website = new Website();
						website.setName(rs.getString("name"));
						return website;
					}
				});
	}

}
