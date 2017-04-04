package com.spring.core.impl;

import com.spring.core.HibTestDAo;
import com.spring.core.Test;
import javassist.tools.reflect.Sample;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by RajuY on 4/4/2017.
 */
@Repository
public class HibTestDAoImpl implements HibTestDAo{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return  this.sessionFactory.getCurrentSession();
    }

    public Serializable save(Test test) {
        return getSession().save(test);
    }

    public Test findById(String id) {

        return getSession().get(Test.class,id);
    }
}
