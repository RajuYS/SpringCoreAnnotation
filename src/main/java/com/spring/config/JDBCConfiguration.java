package com.spring.config;

import com.spring.core.DbProperties;
import com.spring.core.TestDAO;
import com.spring.core.impl.TestDAOImpl;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by RajuY on 3/13/2017.
 */
@Configuration
public class JDBCConfiguration {

    @Autowired
    DbProperties dbProperties;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //dataSource.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=Sample;");/*jdbc:sqlserver://localhost:*/
        dataSource.setUrl(dbProperties.getUrl()+dbProperties.getPort()+";DatabaseName="+dbProperties.getService());
        dataSource.setUsername(dbProperties.getUserName());
        dataSource.setPassword(dbProperties.getPassword());
       // Logger.INFO("Error happend while connecting");
        return dataSource;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return  jdbcTemplate;
    }

    @Bean(name = "testDAO")
    public TestDAO testDAO(){
       TestDAOImpl testDAOImpl =new TestDAOImpl();
        testDAOImpl.setJdbcTemplate(jdbcTemplate());
        return  testDAOImpl;
    }

}
