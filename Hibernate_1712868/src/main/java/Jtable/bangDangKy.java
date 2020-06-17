/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import pojo.Dangky;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class bangDangKy {
     private List<Dangky> ds = new ArrayList<>();
    
    public bangDangKy(Set<Dangky> dangKys){
       ds.addAll(dangKys);
    }
    public bangDangKy(List<Dangky> dangKys){
        ds.addAll(dangKys);
    }
    public bangDangKy(Dangky dangKy){
        ds.add(dangKy);
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
}
