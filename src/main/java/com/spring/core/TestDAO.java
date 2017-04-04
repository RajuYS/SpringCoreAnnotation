package com.spring.core;

import java.util.List;

/**
 * Created by RajuY on 3/13/2017.
 */
public interface TestDAO {
    public String getTestName(int id);
    public List<Test> getAllDetails();
    public void save(Test test);
    public void update();
    public void delete(String id);
    public String spCall(String id);
}
