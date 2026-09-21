/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClienteModel;

/**
 *
 * @author laboratorio
 */
public class ClienteTCP implements Runnable{
    
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private ClienteModel cliente;
    
    public ClienteTCP(ClienteModel cliente){
        
        this.cliente = cliente;
        
    }
    
    @Override
    public void run() {
        
        int porta = 12345;
        
        try {
          
            try (Socket servidor = new Socket("localhost",porta)) {
                saida = new ObjectOutputStream(servidor.getOutputStream());
                entrada = new ObjectInputStream(servidor.getInputStream());
                
                while(cliente.getUsuario()==null){}
                
                saida.flush();
                saida.writeObject(cliente.getUsuario());
                
                cliente.setUsuario(null);
                
                do {
                    
                    if (cliente.isEnviar()){
                        
                        saida.writeObject(cliente.getNome()+","+cliente.getDataNasc());
                        saida.flush();
                        
                        cliente.setEmail((String)entrada.readObject());
                        
                        cliente.setEnviar(false);
                        
                    }
                    
                } while (cliente.isContinuar());
                
                saida.writeObject("desconectar");
                saida.flush();
                
                System.out.println("Conexão encerrada");
                saida.close();
                entrada.close();
            }
            
        } catch(HeadlessException | IOException  e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
    
