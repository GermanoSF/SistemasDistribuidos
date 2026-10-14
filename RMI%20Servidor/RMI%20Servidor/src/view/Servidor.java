/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import interfaces.Gerador;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author laboratorio
 */
public class Servidor {
    
    String HOST_URL = "rmi://localhost/gerar";
    
    public Servidor(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Gerador c = new Gerador();
            Naming.bind(HOST_URL, c);
            System.out.println("Servidor online e a espera de clientes...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    public static void main(String args[]) {
        new Servidor();
    }
    
}
