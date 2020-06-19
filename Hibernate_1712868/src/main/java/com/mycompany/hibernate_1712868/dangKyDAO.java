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
import pojo.DangkyId;

/**
 *
 * @author phama
 */
public class dangKyDAO {
    public static boolean xoaSinhVienDk(Dangky dk)
    {
        try{
            Session session =HibernateUtil.getSession();
            Transaction tx=session.beginTransaction();
            session.delete(dk);
            tx.commit();
            session.close(); 
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public static boolean ThemdK(Dangky dk)
    {
        try{
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        session.save(dk);
        tx.commit();
        session.close();
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public static List<Dangky> getListDK()
    {
        Session sesion=HibernateUtil.getSession();
        String hql="select dk from Dangky dk";
        Query query =sesion.createQuery(hql);
        return query.list();
    }
   public static boolean capNhatDiem(Dangky dk)
    {
        try{
        Session session=HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        session.update(dk);
        tx.commit();
        session.close();
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
   
   public static boolean CapNhatListDiem(List<Dangky> listDK)
    {
        try{
            for(Dangky dk:listDK)
                capNhatDiem(dk);
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
