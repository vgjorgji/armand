package com.vcms.website.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.vcms.persist.repo.HistoryModelRepositoryImpl;
import com.vcms.website.model.Website;
import com.vcms.website.model.WebsiteRepository;

@Repository
public class WebsiteRepositoryJdbc 
		extends HistoryModelRepositoryImpl<Website> 
		implements WebsiteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Website getModel(String name) {
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

	@Override
	public Website getModel(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Website> getModels(Collection<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setNewModelId(Website model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void insertModel(Website model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateModel(Website current, Website model) {
		// TODO Auto-generated method stub
		
	}

}
