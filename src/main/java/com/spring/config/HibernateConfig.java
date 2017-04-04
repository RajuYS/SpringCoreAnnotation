package com.spring.config;

import com.spring.core.HibTestDAo;
import com.spring.core.HibTestService;
import com.spring.core.impl.HibTestDAoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.activation.DataSource;
import java.util.Properties;

/**
 * Created by RajuY on 4/4/2017.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:dbo.properties"})
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("dbo.driver"));
        dataSource.setUrl(env.getRequiredProperty("dbo.host.url")+
                        env.getRequiredProperty("dbo.port.number")+
                        ";DatabaseName="+
                        env.getRequiredProperty("dbo.service.name"));
        dataSource.setUsername(env.getRequiredProperty("dbo.user.name"));
        dataSource.setPassword(env.getRequiredProperty("dbo.password"));
        return  dataSource;
    }

    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean getSessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan(new String[]{"com.spring.core"});
        sessionFactoryBean.setHibernateProperties(getHibernateProperties());
        return  sessionFactoryBean;
    }

    public Properties getHibernateProperties(){
        Properties properties=new Properties();
        properties.put(AvailableSettings.DIALECT,env.getRequiredProperty("hibernate.dialect"));
        properties.put(AvailableSettings.SHOW_SQL,env.getRequiredProperty("hibernate.show_sql"));
        properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,env.getRequiredProperty("hibernate.current.session.context.class"));
        return properties;
    }

    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

    @Bean(name="hibTestDAo")
    public HibTestDAo hibTestDAo(){
        return new HibTestDAoImpl();
    }

    @Bean(name="hibService")
    public HibTestService getHibTestService(){
        return new HibTestService();
    }

}
