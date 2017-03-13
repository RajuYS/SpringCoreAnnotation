package com.spring.core;

/**
 * Created by RajuY on 3/10/2017.
 */
public class Test {
    private String id;
    private String name;
    private int qty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Test "+id+" Row {" +"id=" + id + ", name=" + name + ", qty=" + qty +'}';
    }
}
