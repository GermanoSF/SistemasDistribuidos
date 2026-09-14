/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import javax.swing.JOptionPane;
import model.ClienteModel;
import model.ServidorModel;

/**
 *
 * @author laboratorio
 */
public class ClienteTCP {
    
    private static ObjectOutputStream saida;
    private static ObjectInputStream entrada;
    private static ClienteModel cliente;
    
    public ClienteTCP(ClienteModel cliente){
        
        this.cliente = cliente;
        
    }
    
    public static void main(String[] args) throws IOException {
        
        try {
            int porta = 12345;
            Socket servidor = new Socket("localhost",porta);

            saida = new ObjectOutputStream(servidor.getOutputStream());
            entrada = new ObjectInputStream(servidor.getInputStream());

            new Thread() {
                @Override
                public void run() {
                    String fraseDoServidor;
                    try {
                        while ((fraseDoServidor = (String) entrada.readObject()) != null) {
                            System.out.println("Msg do servidor: " + fraseDoServidor);
                        }
                    } catch (IOException ex) {
                        
                    } catch (ClassNotFoundException e) {
                        
                    }

                }
            }.start();
            
            do {
                
                if (cliente.isEnviar()){
                    
                    saida.flush();
                    saida.writeObject(cliente);
                    
                }
                    
            } while (cliente.isContinuar());

            
            System.out.println("Conexão encerrada");
        }
        
        catch(HeadlessException | IOException  e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        saida.close();
        entrada.close();
        
    }
        
}
    
