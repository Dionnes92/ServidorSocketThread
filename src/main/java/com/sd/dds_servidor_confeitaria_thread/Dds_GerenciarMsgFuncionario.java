/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sd.dds_servidor_confeitaria_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Dionnes
 */
public class Dds_GerenciarMsgFuncionario extends Thread {

    Socket Dds_conexao;
    Dds_Servidor_Confeitaria_Formulario Dds_form;
    Vector Dds_funcionarios;
    String Dds_nomeFuncionario;
    ArrayList<String> Dds_lstPalavras;

    public Dds_GerenciarMsgFuncionario(Socket Dds_conexao, Dds_Servidor_Confeitaria_Formulario Dds_form, Vector funcionarios, ArrayList<String> lstPalavras) {
        this.Dds_conexao = Dds_conexao;
        this.Dds_form = Dds_form;
        this.Dds_funcionarios = Dds_funcionarios;
        this.Dds_lstPalavras = Dds_lstPalavras;
    }

    @Override
    public void run() {
        try {
           
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(Dds_conexao.getInputStream()));
            PrintStream saida = new PrintStream(Dds_conexao.getOutputStream());

            Dds_nomeFuncionario = entrada.readLine();

            if (Dds_nomeFuncionario == null) {
                return;
            }

            Dds_funcionarios.add(saida);

            String linha = entrada.readLine();

            while (linha != null && !(linha.trim().equals(""))) {
                Dds_enviarParaTodos(saida, " falou: ", linha);
                linha = entrada.readLine();
            }

            Dds_enviarParaTodos(saida, " saiu ", " do chat");
            Dds_funcionarios.remove(saida);
            Dds_conexao.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Dds_enviarParaTodos(PrintStream Dds_saida, String Dds_acao, String Dds_linha) {
        Dds_ManipularArquivo Dds_ma = new Dds_ManipularArquivo();
        Enumeration e = Dds_funcionarios.elements();

        if (Dds_lstPalavras != null) {
            for (String palavra : Dds_lstPalavras) {
                if (Dds_linha.toLowerCase().contains(palavra.toLowerCase())) {
                    Dds_ma.Dds_escreverArq(Dds_nomeFuncionario + Dds_acao + Dds_linha, "ListaMensagens", true);

                }
            }
        }

       // Dds_form.getcampoMensagens().setText(Dds_form.getcampoMensagens().getText() + "\n" + Dds_nomeFuncionario
              //  + Dds_acao + Dds_linha);

        while (e.hasMoreElements()) {
            PrintStream Dds_chat = (PrintStream) e.nextElement();

            Dds_chat.println(Dds_nomeFuncionario + Dds_acao + Dds_linha);
        }
    }

}
