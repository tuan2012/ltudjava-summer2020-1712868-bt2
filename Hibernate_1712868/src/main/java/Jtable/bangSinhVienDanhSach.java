/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class bangSinhVienDanhSach {
    private List<Sinhvien> ds = new ArrayList<>();
    public bangSinhVienDanhSach(Sinhvien sinhViens){
        ds.add(sinhViens);
    }
     public bangSinhVienDanhSach(Collection<Sinhvien> sinhViens){
        ds.addAll(sinhViens);
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
            Vector vt=ds.get(i).XuatVectorDS();
            dtm.addRow(vt);
        }
    }
}
