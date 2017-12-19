package com.armand.cms.core.website.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.armand.cms.core.persist.model.Paging;
import com.armand.cms.core.persist.repo.HistoryModelRepositoryImpl;
import com.armand.cms.core.website.model.WebsiteRepository;
import com.armand.cms.core.persist.model.Fetch;
import com.armand.cms.core.website.model.Website;

@Repository
public class WebsiteRepositoryJdbc 
		extends HistoryModelRepositoryImpl<Website> 
		implements WebsiteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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

	@Override
	public void deleteModel(long id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public Website getModel(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fetch<Website> getModels(Collection<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Fetch<Website> getModels(Collection<Long> parentIds, String parentField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fetch<Website> getAllModels() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected long countModels(String query) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Fetch<Website> getModels(Paging<Website> paging) {
		// TODO Auto-generated method stub
		return null;
	}

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

}
