package com.spring.config;

import com.spring.core.DbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by RajuY on 3/9/2017.
 */
@Configuration
//Reading the property file
@PropertySource("classpath:dbo.properties")
public class DbPropertiesConfig {

    //Getting the values from property files and assign values to variables
    @Value("${dbo.host.url}")
    private String url;
    @Value("${dbo.port.number}")
    private String port;
    @Value("${dbo.service.name}")
    private String service;
    @Value("${dbo.user.name}")
    private String userName;
    @Value("${dbo.password}")
    private String password;

    @Bean(name = "db")
    public DbProperties getDProperties(){
        DbProperties dbProperties=new DbProperties();
        dbProperties.setUrl(url);
        dbProperties.setPort(port);
        dbProperties.setService(service);
        dbProperties.setUserName(userName);
        dbProperties.setPassword(password);
        return dbProperties;
    }



}
