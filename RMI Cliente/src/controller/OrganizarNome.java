/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author laboratorio
 */
public class OrganizarNome {
    
    public static String[] separarNomes(String nomesS){
        
        String[] nomesSeparados;
        String aux = "";
        
        for (int i=1;i<nomesS.length();i++){
            
            if (nomesS.charAt(i)==' '&&nomesS.charAt(i-1)!=' '&&nomesS.charAt(i-1)!=','){
                
                aux = nomesS.substring(0,i)+","+nomesS.substring(i+1,nomesS.length());
                
            }
            
        }
        
        aux = aux.trim();
        
        if (aux.charAt(aux.length()-1)==','){
            
            aux = aux.substring(0,aux.length()-2);
            
        }
        
        nomesSeparados = aux.split(",");
        
        for (int i=0;i<nomesSeparados.length;i++){
            
            nomesSeparados[i] = nomesSeparados[i].trim();
            
        }  
        
        return nomesSeparados;
        
    }
                
}
