/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sd.dds_servidor_confeitaria_thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Dionnes
 */
public class Dds_ManipularArquivo {
    
    
       public void Dds_escreverArq(String Dds_texto, String Dds_nomeArq, boolean Dds_manter) 
    { 
        try 
        { 
            File Dds_f = new File("c:\\"+Dds_nomeArq+".txt"); 
 
            FileWriter Dds_fw = new FileWriter(Dds_f,Dds_manter); 
            PrintWriter pw = new PrintWriter(Dds_fw); 
            pw.println(Dds_texto); 
            Dds_fw.close(); 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
    } 
    public BufferedReader Dds_lerArq(String Dds_nomeArq) 
    { 
        BufferedReader br = null; 
        try 
        { 
            File Dds_f = new File("c:\\"+Dds_nomeArq+".txt"); 
            //System.out.println(f.exists()); 
            if(Dds_f.exists()) 
            { 
                FileReader Dds_fr = new FileReader(Dds_f); 
                br = new BufferedReader(Dds_fr); 
            } 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
         
        return br; 
    }
    
}
