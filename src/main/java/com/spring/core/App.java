package com.spring.core;

import com.spring.config.AppConfig;
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
        DbProperties db = (DbProperties) context.getBean("dbProperties");
        System.out.println(db.toString());

        TestDAO testDAO= (TestDAO) context.getBean("testDAO");
        System.out.println("Test Name is : "+testDAO.getTestName(1));
        List<Test> list= testDAO.getAllDetails();
        Iterator<Test> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*Test t1=new Test();
        t1.setId("5");
        t1.setName("Karthik");
        t1.setQty(20);

        testDAO.save(t1);*/

    }
}
