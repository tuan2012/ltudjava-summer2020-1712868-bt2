/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Dangky;

/**
 *
 * @author phama
 */
public class dangKyDAO {
    public static void xoaSinhVienDk(Dangky dk)
    {
        Session session =HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.delete(dk);
        tx.commit();
        session.close(); 
    }
    public static void ThemdK(Dangky dk)
    {
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(dk);
        tx.commit();
        session.close();
    }
   
}
