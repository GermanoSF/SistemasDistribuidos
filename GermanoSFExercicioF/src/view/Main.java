/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Random;

/**
 *
 * @author laboratorio
 */
public class Main {
    
    static Random gerador = new Random();
    static int[] vetor = new int[10000];
    static int[][] vetores = new int[4][2500];
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10000; i++){
            
            vetor[i] = gerador.nextInt();
            
        }
        
        for (int i = 0; i < 4; i++){
            for (int j = i; j < (2500*(i+1)); j++){

                vetores[i][j] = gerador.nextInt();

            }
        }
        
        
        
    }
    
}
