package com.armand.cms.core.website.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.armand.cms.core.website.model.Website;

@Component
public class WebsiteRowMapper implements RowMapper<Website> {

  @Override
  public Website mapRow(ResultSet rs, int i) throws SQLException {
    Website website = new Website();
    website.setName(rs.getString("name"));
    return website;
  }

}
