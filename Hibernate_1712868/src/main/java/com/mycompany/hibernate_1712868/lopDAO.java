/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Lop;
import pojo.Lopmonhoc;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class lopDAO {
    public static Lop getThongTinLop(String MaLop)
    {
        
        Session session=HibernateUtils.getSession();
        Lop lop;
        lop= (Lop) session.get(Lop.class, MaLop);
        session.close();
        return  lop;
    }

    public static Set<Sinhvien> getSetSV(String MaLop)
    {
        Lop lop=getThongTinLop(MaLop);
        Set<Sinhvien>sv= lop.getSinhviens();
        return sv;
    }
    public static Set<Lopmonhoc> getSetLopMH(String MaLop)
    {
        Lop lop=getThongTinLop(MaLop);
        Set<Lopmonhoc>LMH= lop.getLopmonhocs();
        return LMH;
    }

    public static boolean luuLop(Lop lop) {
        try{
            Session session=HibernateUtils.getSession();
            Transaction tx = session.beginTransaction();
            session.save(lop);
            tx.commit();
            session.close();
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
