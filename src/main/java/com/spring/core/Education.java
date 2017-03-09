package com.spring.core;

/**
 * Created by RajuY on 2/26/2017.
 */
public class Education {
    private int marks;

    public Education(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Education{" +
                "marks=" + marks +
                '}';
    }
}
