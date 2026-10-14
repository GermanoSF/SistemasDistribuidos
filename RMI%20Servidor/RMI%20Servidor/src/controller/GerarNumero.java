/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pessoa;

/**
 *
 * @author laboratorio
 */
public class GerarNumero {
    
    private static char[] alfabeto = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z'
    };
   
    public static int gerar(Pessoa pessoa){
        
        //vai retornar para Germano Spall Figueira = G -> 7 + e -> 5 + ... + Spall -> 1 + Figueira -> 1
        int numero = 0;
        int i;
        
        for(int j=0; j<pessoa.getNome().length(); j++){
            for (i = 1; alfabeto[i-1]!=pessoa.getNome().toUpperCase().charAt(j); i++){}
            numero+=i;
        }
        
        for (String sobrenome : pessoa.getSobrenomes()) numero++;
        
        return numero;
        
    }
    
}
