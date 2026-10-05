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
public class GerarEmail {
    
    public static String gerar(Pessoa pessoa){
        
        return (pessoa.getNome()+pessoa.getSobrenomesString()+"@gmail.com");
        
    }
    
}
