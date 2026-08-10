/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

public class MainView {
    public static void exibirResultados(int[][] resultados) {
        for (int i = 0; i < 4; i++) {
            System.out.println("Resultado da parte " + (i + 1) + ": " + resultados[i][0]);
        }
        System.out.println("\nSoma Total: " + resultados[4][0]);
    }
}
