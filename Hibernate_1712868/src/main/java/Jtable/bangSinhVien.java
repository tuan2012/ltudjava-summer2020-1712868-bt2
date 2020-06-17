/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jtable;

import java.util.*;
import javax.swing.table.DefaultTableModel;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class bangSinhVien {
    private List<Sinhvien> ds = new ArrayList<>();
    
    public bangSinhVien(Set<Sinhvien> sinhViens){
        ds.addAll(sinhViens);
    }
    public bangSinhVien(List<Sinhvien> sinhViens){
        ds.addAll(sinhViens);
    }
    public bangSinhVien(Sinhvien sinhViens){
        ds.add(sinhViens);
    }
    public void xuatDSSinhVien(DefaultTableModel dtm)
    {
        int n=dtm.getRowCount();
        for(int i=n-1;i>=0;i--)
        {
            dtm.removeRow(i);
        }
        for(int i=0;i<ds.size();i++)
        {
            Vector vt=ds.get(i).XuatVector();
            dtm.addRow(vt);
        }
    }

    public void show() {
        System.out.println(ds);
    }
}
