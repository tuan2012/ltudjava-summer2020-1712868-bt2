package com.mycompany.hibernate_1712868;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Sinhvien;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phama
 */
public class sinhVienDAO {
    public static void themSinhVien(Sinhvien sv){
        Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();
        session.save(sv);
        tx.commit();
        session.close();
    }
    public static void themListSinhVien(List<Sinhvien> lists){
        /*Session session=HibernateUtils.getSession();
        Transaction tx=session.beginTransaction();*/
        for(Sinhvien sv:lists)
        {
            themSinhVien(sv);
        }
        /*tx.commit();
        session.close();*/
    }
}