package com.mycompany.hibernate_1712868;


import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Dangky;
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
        Session session=HibernateUtil.getSession();
        Sinhvien sv=(Sinhvien) session.get(Sinhvien.class, MSSV);
        return sv;
        
    }
    public static boolean themSinhVien(Sinhvien sv){
        Session session=HibernateUtil.getSession();
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
    public static Set<Dangky> laySetDangKy(String MSSV)
    {
        Sinhvien sv=layThongTinSV(MSSV);
        return sv.getDangkies();
    }
}