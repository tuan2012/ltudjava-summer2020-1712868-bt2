/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import pojo.Taikhoan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author phama
 */
public class taiKhoanDAO {
    public static List<Taikhoan> listTK()
    {
        List<Taikhoan> list=null;
        Session session= HibernateUtils.getSession();
        String hql="select tk from Taikhoan tk";
        Query query1= session.createQuery(hql);
        list=query1.list();
        session.close();
        return list;
    }
    public static Taikhoan getTK(String tenDangNhap)
    {
        Session session= HibernateUtils.getSession();
        Taikhoan tk = (Taikhoan) session.get(Taikhoan.class,tenDangNhap);

        session.close();
        return tk;
    }
}
