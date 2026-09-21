/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import model.ServidorModel;

/**
 *
 * @author laboratorio
 */
public class ServidorTCP implements Runnable{
    
    private static ServidorModel servidorModel;
    
    // Lista para armazenar os sockets de todos os clientes conectados
    private static List<Socket> clientesConectados = new ArrayList<>();
    
    public ServidorTCP(ServidorModel servidorModel){
        
        this.servidorModel = servidorModel;
        
    }
    
    @Override
    public void run(){
        
        int portaServidor = 12345;
        
        try {
            
            ServerSocket servidor = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);

            while (true) {
                // Aguarda a conexão de um novo cliente
                Socket cliente = servidor.accept();
                
                // Cria uma Thread para lidar com o cliente de forma assíncrona
                new Thread(new AtendeCliente(cliente)).start();
                
            }

        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
        
    }
    
    public static synchronized void registrarRemover(boolean operacao, Socket cliente, String dados) throws IOException, ClassNotFoundException{
            
        if (operacao){
                    
            clientesConectados.add(cliente);
                    
            servidorModel.addClienteDados(dados);
            
            servidorModel.addClientes();
            
        } else {
            
            servidorModel.removeClientes();
            servidorModel.removeClienteDados(clientesConectados.indexOf(cliente));
            clientesConectados.remove(cliente);
            
        }
    }
    
}
