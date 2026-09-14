/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import model.ServidorModel;

/**
 *
 * @author laboratorio
 */
public class ServidorTCP {
    
    private static ServidorModel servidorModel;
    
    private static String dadosCliente;
    
    // Lista para armazenar os sockets de todos os clientes conectados
    private static List<Socket> clientesConectados = new ArrayList<>();
    
    private static List<ObjectOutputStream> saidas;
    private static List<ObjectInputStream> entradas;
    
    public ServidorTCP(ServidorModel servidorModel){
        
        this.servidorModel = servidorModel;
        
    }
    
    private static synchronized void registrarRemover(boolean operacao,Socket cliente) throws IOException, ClassNotFoundException{
            
        if (operacao){
            
            // Adiciona o socket do cliente à lista (sincronizado para evitar conflitos de concorrência)
            clientesConectados.add(cliente);
            
            saidas.add(new ObjectOutputStream(cliente.getOutputStream()));
            entradas.add(new ObjectInputStream(cliente.getInputStream()));

            dadosCliente = (String) entradas.getLast().readObject();
                        
            servidorModel.addClienteDados(dadosCliente);
            servidorModel.addClientes();

            // Cria uma Thread para lidar com o cliente de forma assíncrona
            new Thread(new AtendeCliente(cliente)).start();
            
        } else {
            
            
            
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        int portaServidor = 12345;
        
        try {
            
            ServerSocket servidor = new ServerSocket(portaServidor);
            System.out.println("Servidor ouvindo a porta: " + portaServidor);

            while (true) {
                // Aguarda a conexão de um novo cliente
                Socket cliente = servidor.accept();
                
                registrarRemover(true,cliente);
                
            }

        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }

    // Classe interna para gerenciar a comunicação com cada cliente individualmente
    private static class AtendeCliente implements Runnable {
        private Socket socketCliente;

        public AtendeCliente(Socket socket) {
            this.socketCliente = socket;
        }

        @Override
        public void run() {
            try {
                ObjectOutputStream saida = new ObjectOutputStream(socketCliente.getOutputStream());
                saida.flush();
                saida.writeObject();
                saida.close();
                socketCliente.close();
            } catch (IOException e) {
                System.out.println("Erro na comunicação com o cliente: " + e.getMessage());
            } finally {
                // Remove o cliente da lista quando ele desconectar
                synchronized (clientesConectados) {
                    
                    clientesConectados.remove(socketCliente);
                }
                System.out.println("Cliente desconectado. Restantes: " + clientesConectados.size());
            }
        }
    }
    
}
