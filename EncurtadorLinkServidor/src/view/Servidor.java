/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import interfaces.Servicos;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author laboratorio
 */
public class Servidor {
    
    String HOST_URL = "rmi://localhost/servicos";
    
    public Servidor(){
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Servicos c = new Servicos();
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
