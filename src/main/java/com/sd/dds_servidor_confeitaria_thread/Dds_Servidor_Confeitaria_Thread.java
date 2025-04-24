/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sd.dds_servidor_confeitaria_thread;

import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author Dionnes
 */
public class Dds_Servidor_Confeitaria_Thread extends Thread {

    public static void main(String[] args) {
       produtos = new Vector();
    }
    private static Vector produtos;
    private Socket conexao;
    
}
