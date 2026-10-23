/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author laboratorio
 */
public class Servidor {
    
    private List<String> tokens;
    private List<Integer> sockets;
    private List<Integer> numeros;
    private Random random = new Random();
    private Integer numero;
    
    public Servidor(){
        
        tokens = new ArrayList<>();
        sockets = new ArrayList<>();
        
        numeros = new ArrayList<>();
        for (int i = 0; i < 300; i++){
            
            numeros.add(i+1000);
            
        }
        
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }
    
    public void addToken(String token){
        
        tokens.add(token);
        
    }
    
    public void removeToken(String token){
        
        tokens.remove(token);
        
    }

    public List<Integer> getSockets() {
        return sockets;
    }

    public void setSockets(List<Integer> sockets) {
        this.sockets = sockets;
    }
    
    public Integer addSocket(){
        
        numero = numeros.get(random.nextInt(numeros.size()));
        
        numeros.remove(numero);
        sockets.add(numero);
        
        return numero;
        
    }
    
    public void removeSocket(Integer socket){
        
        numeros.add(socket);
        sockets.remove(socket);
        
    }
    
}
