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
public class AtendeCliente implements Runnable {
        private Socket socketCliente;
        private ObjectOutputStream saida;
        private ObjectInputStream entrada;
        private String dados;

        public AtendeCliente(Socket socket) {
            this.socketCliente = socket;
        }

        @Override
        public void run() {
            
            String aux;
            String[] dadosEmail = new String[2];
            
            try {
                
                saida = new ObjectOutputStream(socketCliente.getOutputStream());
                entrada = new ObjectInputStream(socketCliente.getInputStream());
                
                dados = (String) entrada.readObject();
                
                ServidorTCP.registrarRemover(true, socketCliente, dados);
                
                while (!(aux=(String)entrada.readObject()).equals("desconectar")){
                    
                    dadosEmail = aux.split(",");
                    dadosEmail[0] = dadosEmail[0].toLowerCase();
                    aux = dadosEmail[0] + dadosEmail[1] + "@gmail.com";
                    
                    saida.writeObject(aux);
                    saida.flush();
                
                }
                
                saida.close();
                entrada.close();
                
            } catch (IOException e) {
                System.out.println("Erro na comunicacao com o cliente: " + e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AtendeCliente.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                
                try {
                    ServidorTCP.registrarRemover(false,socketCliente,"");
                } catch (IOException ex) {
                    Logger.getLogger(AtendeCliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AtendeCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    if (socketCliente != null && !socketCliente.isClosed()) {
                        socketCliente.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AtendeCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
