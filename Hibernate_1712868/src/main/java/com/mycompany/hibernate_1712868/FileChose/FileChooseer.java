/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868.FileChose;


import com.mycompany.hibernate_1712868.dangKyDAO;
import com.mycompany.hibernate_1712868.lopDAO;
import com.mycompany.hibernate_1712868.lopMonHocDAO;
import com.mycompany.hibernate_1712868.sinhVienDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
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
public class FileChooseer {
    private static File Readfile()
    {
        File file=null;
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            // invoke the showsOpenDialog function to show the save dialog 
        int r = jFileChooser.showOpenDialog(null); 

        // if the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) 
        { 
           file=jFileChooser.getSelectedFile();
        } 
        // if the user cancelled the operation 
        else
            System.err.println("Exit ");
        return file;                          
    }
    public static boolean ReadFileCSVTKB()
    {
        File file=Readfile();
        List<Lopmonhoc> listLMH=new ArrayList<>();
        Set<Dangky>dangKies=new HashSet<>();
        String fileName=file.getName();
        fileName=fileName.substring(0,fileName.lastIndexOf('.'));
       
        try {
            Scanner scaner=new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")));
            String ssr=scaner.nextLine();
            System.err.println(ssr);
            while(scaner.hasNext())
            {
                dangKies.clear();
                Lopmonhoc lMH=new Lopmonhoc();
                ssr=scaner.nextLine();
                System.err.println(ssr);
                String []str=ssr.split(",");
                lMH.setId(new LopmonhocId(fileName, str[1]));
                Lop lop=lopDAO.getThongTinLop(fileName);
                lMH.setLop(lop);
                Monhoc mh=new Monhoc(str[1], str[2]);
                lMH.setMonhoc(mh);
                lMH.setPhong(new Phong(str[3],str[3]));
                Iterator<Sinhvien>set=lop.getSinhviens().iterator();//lopMonHocDAO.GetLop("17HCB","CTT001").iterator();
                while(set.hasNext())
                {
                    Sinhvien sv=set.next();
                    Dangky dk=new Dangky();
                    dk.setId(new DangkyId(sv.getMssv(),fileName,str[1]));
                    dangKies.add(dk);
                }
                lMH.setDangkies(dangKies);
                lopMonHocDAO.themLopMonHoc(lMH);
               
                listLMH.add(lMH);

            }
            
           //opMonHocDAO.themListLopMH(listLMH);
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        } catch (IOException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
       return true;  
    }
    
    private static String getFileNameIgnoreExtension(File file){
        String fileName = file.getName();
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
    public static List<Sinhvien> importSinhVien(){
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = jFileChooser.showOpenDialog(null);
         //Set<Sinhvien> sinhViens = new HashSet<>();
         List<Sinhvien> sinhViens=new ArrayList<>();
        if (r == JFileChooser.APPROVE_OPTION) 
        { 
            File file = jFileChooser.getSelectedFile();
            // set the label to the path of the selected file 
            //Lop lop = new Lop(getFileNameIgnoreExtension(file), getFileNameIgnoreExtension(file));

            try {
                Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8")));

                sc.nextLine();
               
                while(sc.hasNext()){
                    String str = sc.nextLine();
                    String arr[] = str.split(",");
                    Sinhvien sv = new Sinhvien();
                    sv.setMssv(arr[1]);
                    sv.setHoTen(arr[2]);
                    sv.setGioiTinh(arr[3]);
                    sv.setCmnd(arr[4]);
                    sv.setTaikhoan(new Taikhoan(arr[1], arr[1], false));
                    sv.setLop(new Lop(getFileNameIgnoreExtension(file),getFileNameIgnoreExtension(file)));
                    sinhViens.add(sv);
                }
               // lop.setSinhviens(sinhViens);
//                System.out.println(sinhViens);
                //lopDAO.luuLop(lop);
                sinhVienDAO.themListSinhVien(sinhViens);

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
            return sinhViens;
        } 
        // if the user cancelled the operation 
        else{
            return null;
        }
    }
    private static String[] getNamePointFile(File file)
    {
        String fileName=file.getName();
        fileName=fileName.substring(0, fileName.lastIndexOf("."));
        
        String []nameArr=fileName.split("-");
        return nameArr;
    }
    public static boolean readCSVPoint() 
    {
        File file=Readfile();
        String[] fileName=getNamePointFile(file);
        List<Dangky> listDK=new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8")));
            sc.nextLine();
            while(sc.hasNext())
            {
                String str=sc.nextLine();
                System.out.println(str+"\n");
                String []arrString=str.split(",");
                Dangky dk=new Dangky();
                dk.setId(new DangkyId(arrString[1],fileName[0],fileName[1]));
                dk.setDiemGk(Float.parseFloat(arrString[3]));
                dk.setDiemCk(Float.parseFloat(arrString[4]));
                dk.setDiemKhac(Float.parseFloat(arrString[5]));
                dk.setDiemTong(Float.parseFloat(arrString[6]));
                listDK.add(dk);
            }
            dangKyDAO.CapNhatListDiem(listDK);
        } catch (FileNotFoundException ex) {            
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
         
    }
    
   /* private static List<Sinhvien> ReadFileCSVSV(File file)  {
         List<Sinhvien> listSV=new ArrayList<>();
         String fileName=file.getName();
         fileName=fileName.substring(0,fileName.lastIndexOf('.'));
        try {
            
            Scanner scaner=new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")));
            String ssr=scaner.nextLine();
            System.err.println(ssr);
            while(scaner.hasNext())
            {
                ssr=scaner.nextLine();
                String []str=ssr.split(",");
                Sinhvien sv=new Sinhvien();
                sv.setMssv(str[1]);
                sv.setHoTen(str[2]);
                sv.setGioiTinh(str[3]);
                sv.setCmnd(str[4]);
                sv.setLop(lopDAO.getThongTinLop(fileName));
                Taikhoan tk=new Taikhoan(str[1],str[1],false);
                sv.setTaikhoan(tk);
                
                listSV.add(sv);

            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return listSV;
    }*/
}