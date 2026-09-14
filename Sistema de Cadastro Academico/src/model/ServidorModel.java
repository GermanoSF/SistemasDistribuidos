/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author laboratorio
 */
public class ServidorModel {
    
    private int clientes = 0;
    private String mensagem;
    private List<String> clienteDados;
    
    public void addClienteDados(String dados){
        
        clienteDados.add(dados);
        
    }

    public List<String> getClienteDados() {
        return clienteDados;
    }

    public void setClienteDados(List<String> clienteDados) {
        this.clienteDados = clienteDados;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getClientes() {
        return clientes;
    }

    public void addClientes(){
        
        clientes++;
        
    }
    
}
