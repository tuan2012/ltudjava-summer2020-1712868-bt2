/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import com.mycompany.hibernate_1712868.view.Login;
import com.mycompany.hibernate_1712868.view.ThemSinhVien;
import com.mycompany.hibernate_1712868.view.XemDanhSachLop;
import com.mycompany.hibernate_1712868.view.dashBoardAdmin;
import java.util.Iterator;
import java.util.Set;
import pojo.Dangky;
import pojo.DangkyId;
import pojo.Lop;
import pojo.Lopmonhoc;
import pojo.LopmonhocId;
import pojo.Monhoc;
import pojo.Phong;
import pojo.Sinhvien;
import pojo.Taikhoan;

/**
 *
 * @author phama
 */
public class Main {
    public static void main(String[] args) {
       
       /*Sinhvien sv=new Sinhvien("1712868");
        sv.setLop(new Lop("CCT7"));
        sv.setTaikhoan(new Taikhoan("1712868","13",false));
        sinhVienDAO.themSinhVien(sv);*/
        //Login.CreateGUI();
        dashBoardAdmin.CreateGUI();
        //XemDanhSachLop.CreateGUI();
        //ThemSinhVien.CreateGUI();
        /*Dangky dk=new Dangky(new DangkyId("1742005","18HCB","CTT001"));
        dangKyDAO.ThemdK(dk);*/
//        Iterator<Dangky>dk=lopMonHocDAO.GetDangKy("18HCB","CTT001").iterator();
//        while(dk.hasNext())
//        {
//            Dangky d=dk.next();
//            System.out.print( d.getSinhvien().getMssv()+"\n");
//        }
        
        
       /* Iterator<Sinhvien> set= lopMonHocDAO.GetLop("17HCB","CTT011").iterator();
        while(set.hasNext())
        {
            Sinhvien sv=set.next();
            System.err.println(sv.getMssv()+"\n");
        }*/
        /*Lop lop=lopDAO.getThongTinLop("17HCB");
        //Lopmonhoc lmh=lopMonHocDAO.getLMH("18HCB","CTT001");
        
        Iterator<Sinhvien>set=lop.getSinhviens().iterator();//lopMonHocDAO.GetLop("17HCB","CTT001").iterator();
        while(set.hasNext())
        {
            Sinhvien sv=set.next();
            System.err.println(sv.getMssv()+"\n");
        }*/
        
        
        
        
    }
    
}
