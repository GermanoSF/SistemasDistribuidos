/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class ServidorModel {
    
    private volatile int clientes = 0;
    private volatile List<String> clienteDados = new ArrayList<>();
    
    public void addClienteDados(String dados){
        
        clienteDados.add(dados);
        
    }
    
    public void removeClienteDados(int posicao){
        
        clienteDados.remove(posicao);
        
    }

    public List<String> getClienteDados() {
        return clienteDados;
    }

    public void setClienteDados(List<String> clienteDados) {
        this.clienteDados = clienteDados;
    }

    public int getClientes() {
        return clientes;
    }

    public void addClientes(){
        
        clientes++;
        
    }
    
    public void removeClientes(){
        
        clientes--;
        
    }
    
}
