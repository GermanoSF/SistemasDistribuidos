/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Random;
import model.ThreadOperacoes;
import view.MainView;

public class MainController {
    
    public void executar() {
        Random gerador = new Random();
        int[] vetor = new int[10000];
        int[][] vetores = new int[4][2500];
        int[][] resultados = new int[5][1];
        ThreadOperacoes[] threads = new ThreadOperacoes[4];
        
        // Preenche o vetor principal com valores aleatórios de 0 a 99
        for (int i = 0; i < 10000; i++){
            vetor[i] = gerador.nextInt(100);
        }
        
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 2500; j++){
                vetores[i][j] = vetor[(i * 2500) + j];
            }
        }
        
        // Inicializa e inicia as threads
        for (int i = 0; i < 4; i++){
            threads[i] = new ThreadOperacoes(vetores[i], resultados[i]);
            threads[i].start();
        }
        
        // Aguarda o término das threads
        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Soma os resultados parciais
        resultados[4][0] = 0;
        for (int i = 0; i < 4; i++) {
            resultados[4][0] += resultados[i][0];
        }
        
        // Envia os dados para a View exibir
        MainView.exibirResultados(resultados);
    }
}
