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
    private int resultado;
    
    public ThreadOperacoes(int[] vetor, int resultado){
        
        this.vetor = vetor;
        this.resultado = resultado;
        
    }
    
    @Override
    public void run(){
        
        resultado = Operacoes.somarVetor(this.vetor,0);
        
    }
    
}
