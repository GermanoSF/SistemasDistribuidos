/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gspal
 */
public class ServidorPartida implements Runnable{
    
    private Socket cliente1;
    private Socket cliente2;
    private ObjectOutputStream[] saida = new ObjectOutputStream[2];
    private ObjectInputStream[] entrada = new ObjectInputStream[2];
    private int[] informacoesPartida;

    public ServidorPartida(Socket cliente1, Socket cliente2) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        informacoesPartida = new int[]{0,0,0,0,0,0,0,0,0};
    }
    
    @Override
    public void run(){
        
        try {
            saida[0] = (ObjectOutputStream) cliente1.getOutputStream();
            saida[1] = (ObjectOutputStream) cliente2.getOutputStream();
            entrada[0] = (ObjectInputStream) cliente1.getInputStream();
            entrada[1] = (ObjectInputStream) cliente2.getInputStream();
            
            String[] usuarios = new String[2];
            
            usuarios[0] = (String) entrada[0].readObject();
            usuarios[1] = (String) entrada[1].readObject();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorPartida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
