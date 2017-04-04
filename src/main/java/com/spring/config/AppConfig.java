package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by RajuY on 2/26/2017.
 */
@Configuration

@Import({HibernateConfig.class})
public class AppConfig {

}
