package com.spring.core;

import com.spring.config.AppConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    private static Log log= LogFactory.getLog(App.class.getName());
    public static void main( String[] args )
    {
        log.info("Start the execution");
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        log.info("After execution of context");
        HibTestService hibTestService= (HibTestService) context.getBean("hibService");
        log.info("After execution of getbean");
        Test t1=new Test();
        t1.setId("21");
        t1.setName("RajGaru");
        t1.setQty(100);
        log.info("Inserted Test object is :"+t1);
        hibTestService.addNewTest(t1);
        Test t2=hibTestService.getTest("2");
        log.info("Details of Test ID 2 :"+t2);
        log.info("End the execution");

    }
}
