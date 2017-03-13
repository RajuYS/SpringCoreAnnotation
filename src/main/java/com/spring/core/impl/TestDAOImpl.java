package com.spring.core.impl;

import com.spring.core.Test;
import com.spring.core.TestDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Test> getAllDetails() {
        String sql_Query="select * from Test ";
        List<Test> list=jdbcTemplate.query(sql_Query,new TestMapper());

        return list;
    }

    public void save(Test test) {
        String sql_Query="insert into Test() values(?,?,?)";
        jdbcTemplate.update(sql_Query,new Object[]{test.getId(),test.getName(),test.getQty()});
    }

    private class TestMapper implements RowMapper<Test>{
        public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
            Test test=new Test();
            test.setId(rs.getString("id"));
            test.setName(rs.getString(2));
            test.setQty(rs.getInt(3));
            return test;
        }

    }

}
