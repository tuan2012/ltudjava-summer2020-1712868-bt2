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
    public static Sinhvien layThongTinSV(String MSSV)
    {
        Session session=HibernateUtils.getSession();
        Sinhvien sv=(Sinhvien) session.get(Sinhvien.class, MSSV);
        return sv;
        
    }
    public static boolean themSinhVien(Sinhvien sv){
        Session session=HibernateUtils.getSession();
        if(sinhVienDAO.layThongTinSV(sv.getMssv())!=null)
            return false;
        Transaction tx=session.beginTransaction();
        session.save(sv);
        tx.commit();
        session.close();
        return true;
    }
    public static boolean themListSinhVien(List<Sinhvien> lists){
        try{
            for(Sinhvien sv:lists)
            {
                themSinhVien(sv);

                //session.clear();
            }
        }catch(Exception e){
            return false;
        }
 
     return true;
    }
}