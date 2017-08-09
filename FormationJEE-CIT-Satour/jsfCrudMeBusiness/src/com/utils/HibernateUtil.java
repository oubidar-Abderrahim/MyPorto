package com.utils;

import java.net.URL;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Logger log = Logger.getLogger(HibernateUtil.class);
    
    private static SessionFactory buildSessionFactory() {
        try {
        //	URL myurl = Thread.currentThread().getContextClassLoader().getResource("hibernate.cfg.xml");
            return new Configuration()
            		.configure()
                    .buildSessionFactory();
        
        //	return new Configuration().configure(myurl).buildSessionFactory();
        } catch (Throwable ex) {
//        	log.debug("Initial SessionFactory creation failed." + ex);
        	log.error(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
