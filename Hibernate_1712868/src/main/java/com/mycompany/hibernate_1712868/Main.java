/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868;

import com.mycompany.hibernate_1712868.view.Login;
import com.mycompany.hibernate_1712868.view.dashBoardAdmin;
import pojo.Lop;
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
    }
    
}
