package com.spring.config;

import com.spring.core.Education;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by RajuY on 2/26/2017.
 */
@Configuration
public class EducationConfig {

    @Bean(name="education")
    public Education getEducationInfo(){
        Education education=new Education(100);
        return education;
    }

}
