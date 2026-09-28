/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gspal
 */
public class ServidorModel {
    
    private volatile List<String[]> informacoesJogadores = new ArrayList<>();

    public ServidorModel() {}

    public List<String[]> getInformacoesJogadores() {
        return informacoesJogadores;
    }

    public void setInformacoesJogadores(List<String[]> informacoesJogadores) {
        this.informacoesJogadores = informacoesJogadores;
    }

    public void addInformacoesJogadores(String[] informacoes){
        
        informacoesJogadores.add(informacoes);
        
    }
    
    public void removeInformacoesJogadores(int indice){
        
        informacoesJogadores.remove(indice);
        
    }
    
    public void alterInformacoesJogadores(int indice,String[] alteracao){
        
        informacoesJogadores.set(indice,alteracao);
        
    }
    
}
