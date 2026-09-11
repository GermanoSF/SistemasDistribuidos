/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laboratorio
 */
public class ServidorModel {
    
    private boolean novaMensagem = false;
    private boolean novoCliente = false;
    private String mensagem;
    private String clienteDados;
        
    public ServidorModel(String clienteDados){
    
        this.clienteDados = clienteDados;
    
    }

    public String getClienteDados() {
        return clienteDados;
    }

    public void setClienteDados(String clienteDados) {
        this.clienteDados = clienteDados;
    }
    
    public boolean isNovaMensagem() {
        return novaMensagem;
    }

    public void setNovaMensagem(boolean novaMensagem) {
        this.novaMensagem = novaMensagem;
    }

    public boolean isNovoCliente() {
        return novoCliente;
    }

    public void setNovoCliente(boolean novoCliente) {
        this.novoCliente = novoCliente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
}
