/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laboratorio
 */
public class ThreadOperacoes extends Thread{
    
    private int[] vetor;
    private int[] resultado = new int[1];
    
    public ThreadOperacoes(int[] vetor, int[] resultado){
        
        this.vetor = vetor;
        this.resultado = resultado;
        
    }
    
    @Override
    public void run(){
        
        this.resultado[0] = Operacoes.somarVetor(this.vetor,0);
        
    }
    
}
