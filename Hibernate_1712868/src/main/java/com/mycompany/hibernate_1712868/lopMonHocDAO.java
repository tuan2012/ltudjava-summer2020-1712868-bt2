/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Lopmonhoc;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class lopMonHocDAO {
    public static boolean themLopMonHoc(Lopmonhoc lopMH){
        try{
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(lopMH);
        tx.commit();
        session.close();
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public static boolean themListLopMH(List<Lopmonhoc>list)
    {
        try{
        for(Lopmonhoc lmh:list)
            themLopMonHoc(lmh);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}

