package com.mycompany.hibernate_1712868;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author phama
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
   
    private static SessionFactory BuildSessionFactory(){
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            SessionFactory sess= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            return sess;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getSession() {
        if(sessionFactory==null)sessionFactory=BuildSessionFactory();
        return sessionFactory.openSession();
    }
}
