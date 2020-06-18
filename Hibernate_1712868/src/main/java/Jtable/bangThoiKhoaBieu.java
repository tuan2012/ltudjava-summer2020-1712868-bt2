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
import pojo.Lopmonhoc;
import pojo.Sinhvien;

/**
 *
 * @author phama
 */
public class bangThoiKhoaBieu {
    private List<Lopmonhoc> ds = new ArrayList<>();
    public bangThoiKhoaBieu(Lopmonhoc lopMonHoc){
        ds.add(lopMonHoc);
    }
    public bangThoiKhoaBieu(Collection<Lopmonhoc> lopMonHocs){
        ds.addAll(lopMonHocs);
    }
    public void xuatTKB(DefaultTableModel dtm)
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
