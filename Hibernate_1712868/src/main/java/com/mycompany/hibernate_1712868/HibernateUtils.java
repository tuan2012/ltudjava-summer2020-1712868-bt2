package com.mycompany.hibernate_1712868;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.id.Configurable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phama
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory=null;
    private static SessionFactory getSesstionFactory()
    {
        SessionFactory sessionF=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        return sessionF;
    }
    public static Session getSession()
    {
        if(sessionFactory==null) sessionFactory=getSesstionFactory();
        return sessionFactory.openSession();
    }
}
