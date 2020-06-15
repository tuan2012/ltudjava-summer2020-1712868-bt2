/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate_1712868.FileChose;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import pojo.Lop;
import pojo.Sinhvien;
import pojo.Taikhoan;

/**
 *
 * @author phama
 */
public class FileChooseer {
    public static List<Sinhvien> Readfile()
    {
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        List<Sinhvien>Lists=new ArrayList<>();
  
            // invoke the showsOpenDialog function to show the save dialog 
            int r = jFileChooser.showOpenDialog(null); 
          
            // if the user selects a file 
            if (r == JFileChooser.APPROVE_OPTION) 
            { 
                File file=jFileChooser.getSelectedFile();
   
                // set the label to the path of the selected file 
                Lists=ReadFileCSV(file);
            } 
            // if the user cancelled the operation 
            else
                System.err.println("Exit ");
            
            return Lists;
                     
    }

    private static List<Sinhvien> ReadFileCSV(File file)  {
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
                sv.setLop(new Lop(fileName,fileName));
                sv.setTaikhoan(new Taikhoan(str[1],str[1],false));
                listSV.add(sv);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileChooseer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return listSV;
    }
}
