package com.spring.core.impl;

import com.spring.core.TestDAO;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by RajuY on 3/13/2017.
 */

public class TestDAOImpl implements TestDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getTestName(int id) {
        String sql="select name From Test where id=?";
        String name=jdbcTemplate.queryForObject(sql,new Object[]{id},String.class);
        return name;
    }
}
