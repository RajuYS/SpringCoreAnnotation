package com.spring.core;

import com.spring.config.B;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by RajuY on 2/26/2017.
 */
public class Student {
    private String name;
    @Autowired
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    void print(){
        System.out.println("name"+name);
    }
    void display(){
        print();
        b.print();
    }

}
