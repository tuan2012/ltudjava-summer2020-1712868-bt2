/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Dangky;
import pojo.Lop;
import pojo.Lopmonhoc;
import pojo.LopmonhocId;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class lopMonHocDAO {
    public static boolean themLopMonHoc(Lopmonhoc lopMH){
        try{
        Session session=HibernateUtil.getSession();
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
    public static Lopmonhoc getLMH(String MaLop, String MaMon)
    {
        Session session=HibernateUtil.getSession();
        //Transaction tx=session.beginTransaction();
        Lopmonhoc lmh=(Lopmonhoc) session.get(Lopmonhoc.class,new LopmonhocId(MaLop,MaMon));
        return lmh;
    }
    public static Set<Sinhvien> GetLop(String MaLop, String MaMon)
    {
        Lopmonhoc lopmh=getLMH(MaLop, MaMon);
        Lop lop=lopmh.getLop();
        Set<Sinhvien>set=lop.getSinhviens();
        return set;
    }
    public static Set<Dangky> GetDangKy(String MaLop, String MaMon)
    {
        Lopmonhoc lopmh=getLMH(MaLop, MaMon);
        Set<Dangky> dks=lopmh.getDangkies();
        return dks;
    }
}

