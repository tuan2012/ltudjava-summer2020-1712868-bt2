///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Jtable;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author phama
// */
//public class Show {
//    public static void Show(JTable NameTable,List list,String []names,Temp temp)
//    {
//        
//        
//        DefaultTableModel dsModel=new DefaultTableModel(null,names);
//        NameTable.setModel(dsModel);
//        NameTable.setFocusable(true);
//        
//        temp bsv = new Temp(list);
//        //bsv.show();
//        bsv.xuatDSSinhVien(dsModel);
//    }
// class Temp<T extends Collection>
// {
//    private  T list;
//
//    public Temp() {}
//    public  Temp(List temp)
//    {
//        list.addAll(temp);
//    }
//   
// }
//}
