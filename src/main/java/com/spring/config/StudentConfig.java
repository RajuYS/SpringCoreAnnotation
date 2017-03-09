package com.spring.config;

import com.spring.core.Education;
import com.spring.core.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by RajuY on 2/26/2017.
 */
@Configuration
public class StudentConfig {

    @Bean(name="b")
    public B getBInfo(){
        return new B();
    }
    @Bean(name = "std")
    public Student getStudentInfo(){
        Student std=new Student();
        std.setName("Raju");
        return  std;
    }

    @Bean(name = "edu")
    public Education getEducationInfo(){

        return new Education(10);
    }
}
