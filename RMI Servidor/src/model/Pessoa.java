/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laboratorio
 */
public class Pessoa {
    
    private String nome;
    private String[] sobrenomes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getSobrenomes() {
        return sobrenomes;
    }
    
    public String getSobrenomesString(){
        
        String sobrenomesS = "";
        
        for (String sobrenome : sobrenomes){
            
            sobrenomesS = sobrenomesS + sobrenome;
            
        }
        
        return sobrenomesS;
        
    }

    public void setSobrenomes(String[] sobrenomes) {
        this.sobrenomes = sobrenomes;
    }
    
}
