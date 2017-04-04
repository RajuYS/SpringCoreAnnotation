package com.spring.core;

import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by RajuY on 4/4/2017.
 */
@Service
@Transactional(readOnly = true)
public class HibTestService {
    final static Log logger=LogFactory.getLog(HibTestService.class);

    @Autowired
    private HibTestDAo hibTestDAo;

    public Test getTest(String id){
        logger.info("Given Test id as :"+id);
        return hibTestDAo.findById(id);
    }
    @Transactional(readOnly = false)
    public void addNewTest(Test test){
        Serializable id=hibTestDAo.save(test);
        logger.info("Id of inserted Test id :"+id);
    }

}
