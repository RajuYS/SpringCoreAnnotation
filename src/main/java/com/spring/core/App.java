package com.spring.core;

import com.spring.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        /*ApplicationContext context1=new ClassPathXmlApplicationContext("AppConfig.class");
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Student st= (Student) context.getBean("std");
        st.display();
        //System.out.println( "From Student Class"+st);
        Education ed= (Education) context.getBean("edu");
        System.out.println("From Education Class1"+ed);
        Education ed2= (Education) context.getBean("education");
        System.out.println("From Education Class2"+ed2);*/

        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        DbProperties db = (DbProperties) context.getBean("db");
        System.out.println(db.toString());


    }
}
