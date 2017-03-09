package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by RajuY on 2/26/2017.
 */
@Configuration
@Import({StudentConfig.class,EducationConfig.class,DbPropertiesConfig.class})
public class AppConfig {

}
