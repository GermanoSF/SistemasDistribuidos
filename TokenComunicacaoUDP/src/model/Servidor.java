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
    
    private List<Integer> tokens;
    private List<Integer> tokensValidos;
    private Random random = new Random();
    private Integer numero;
    private Integer ultimoToken;
    
    public Servidor(){
        
        tokens = new ArrayList<>();
        tokensValidos = new ArrayList<>();
        
        for (int i = 0; i < 300; i++){
            
            tokensValidos.add(i+1000);
            
        }
        
    }

    public List<Integer> getTokens() {
        return tokens;
    }

    public void setTokens(List<Integer> tokens) {
        this.tokens = tokens;
    }
    
    public Integer addToken(){
        
        numero = tokensValidos.get(random.nextInt(tokensValidos.size()));
        
        tokensValidos.remove(numero);
        tokens.add(numero);
        ultimoToken = numero;
        
        return numero;
        
    }
    
    public void removeToken(Integer token){
        
        tokensValidos.add(token);
        tokens.remove(token);
        
    }
    
    public Integer uToken(){
        
        return ultimoToken;
        
    }
    
}
