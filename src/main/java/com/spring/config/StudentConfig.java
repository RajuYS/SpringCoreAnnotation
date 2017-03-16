package com.spring.config;

import com.spring.core.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by RajuY on 2/26/2017.
 */
@Configuration
public class StudentConfig {

    @Bean(name = "std")
    public Student getStudentInfo(){
        Student std=new Student();
        std.setName("Raju");
        return  std;
    }
}
