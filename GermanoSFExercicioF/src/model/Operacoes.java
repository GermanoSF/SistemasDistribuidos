/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author laboratorio
 */
public class Operacoes {
    
    public static int somarVetor (int[] vetor, int resultado){
        
        for (int numero : vetor){
            
            resultado += numero;
            
        }
        
        return resultado;
        
    }
    
}
