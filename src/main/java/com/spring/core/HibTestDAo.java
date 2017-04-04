package com.spring.core;

import java.io.Serializable;

/**
 * Created by RajuY on 4/4/2017.
 */
public interface HibTestDAo {

    Serializable save(Test test);
    Test findById(String id);
}
