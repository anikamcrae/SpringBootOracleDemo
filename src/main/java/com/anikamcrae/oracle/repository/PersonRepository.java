package com.anikamcrae.oracle.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.anikamcrae.oracle.domain.Person;

@Repository
public class PersonRepository {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public Person getPerson(Long personId) {
    	log.info("repo getPerson");	
    	
    	String sql = "SELECT * FROM person where person_id = :person_id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("person_id", personId);
    	
		return jdbc.queryForObject(sql, namedParameters, mapper);
	}
	
	
	
    private static final RowMapper<Person> mapper = new RowMapper<Person>() {
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        	return new Person(rs.getLong("PERSON_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
        }
    };		
}
