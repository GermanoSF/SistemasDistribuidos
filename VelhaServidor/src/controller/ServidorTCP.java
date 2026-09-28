/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ServidorModel;

/**
 *
 * @author gspal
 */
public class ServidorTCP implements Runnable{

    private static ServidorModel servidor; 

    public ServidorTCP(ServidorModel servidor) {
        this.servidor = servidor;
    }
    
    public static synchronized void alterarDados(int operacao,int indice,String[] informacao){
        
        switch(operacao){
            
            case 1:
                servidor.addInformacoesJogadores(informacao);
                break;
                
            case 2:
                servidor.removeInformacoesJogadores(indice);
                break;
                
            default:
                servidor.alterInformacoesJogadores(indice,informacao);
            
        }
        
    }
    
    @Override
    public void run(){
        
        int portaServidor = 12345;
        
        try {
            ServerSocket servidorSocket = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);
            
            while (true) {
                
                // Aguarda a conexão de um novo cliente1
                Socket cliente1 = servidorSocket.accept();
                
                // Aguarda a conexão de um novo cliente2
                Socket cliente2 = servidorSocket.accept();
                
                // Cria uma Thread para lidar com os 2 clientes
                new Thread(new ServidorPartida(cliente1,cliente2)).start();
                               
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
