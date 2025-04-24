/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sd.dds_servidor_confeitaria_thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Dionnes
 */
public class Dds_GerenciarConexao extends Thread{
    
    Dds_Servidor_Confeitaria_Formulario form;
     Vector funcionarios; 
    int porta; 
    ArrayList<String> lstPalavras; 

    public Dds_GerenciarConexao(Dds_Servidor_Confeitaria_Formulario form, Vector funcionarios, int porta, ArrayList<String> lstPalavras) {
        this.form = form;
        this.funcionarios = funcionarios;
        this.porta = porta;
        this.lstPalavras = lstPalavras;
    }
    
    @Override
    public void run(){
        
          funcionarios = new Vector();         
        try 
        { 
            ServerSocket ss = new ServerSocket(porta); 
             
            int contaFuncionarios = 0; 
            while(true) 
            {              
                form.getLbiSituacao().setText("Aguardando conexão!!!"); 
                Socket con = ss.accept(); 
                contaFuncionarios += 1; 
                form.getfuncionariosConectados().setText(String.valueOf(contaFuncionarios)); 
                Thread t = new Dds_GerenciarMsgFuncionario(con, form, funcionarios, lstPalavras);
            } 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
    }
}
    

    

