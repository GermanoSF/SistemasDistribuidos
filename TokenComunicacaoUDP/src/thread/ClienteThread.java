/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import UDP.ServerUDP;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorio
 */
public class ClienteThread extends Thread{
    
    private volatile Integer tempo;
    private volatile String token;
    private volatile String dados = null;
    
    public ClienteThread(String token){
        
        this.token = token;
        
    }
    
    public void addDados(String novosDados) {
        
        if (!(dados == null)) this.dados = this.dados + " I I " + novosDados;
        else this.dados = novosDados;
 
    }
    
    public String getToken(){
        
        return token;
        
        
    }
    
    public String getDados(){
        
        return dados;
        
    }
    
    public String getTempo(){
        
        return tempo.toString();
        
    }
    
    @Override
    public void run(){
        
        for (tempo = 0; tempo < 60; tempo++){
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClienteThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        ServerUDP.removerToken(token);
        
    }
    
    // 1. Equals comparando o atributo String (token)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        // 1. Primeiro verifica se o que passaram é uma String (o token)
        if (o instanceof String) {
            return Objects.equals(this.token, (String) o);
        }

        // 2. Se não for String, garante que é da mesma classe antes de fazer o cast
        if (getClass() != o.getClass()) return false;

        // 3. Se chegou aqui, é outra ClienteThread
        ClienteThread that = (ClienteThread) o;
        return Objects.equals(this.token, that.token);
    }

    // 2. HashCode gerado a partir da String (token)
    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
    
}
