package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by RajuY on 2/26/2017.
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void print(){
        System.out.println("Your Name is "+name);
    }
    void display(){
        print();
    }
}
