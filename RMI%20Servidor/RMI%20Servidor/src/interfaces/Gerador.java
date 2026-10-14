/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import controller.GerarEmail;
import controller.GerarNumero;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import model.Pessoa;
/**
 *
 * @author laboratorio
 */
public class Gerador extends UnicastRemoteObject implements Gerar{
    
    public Gerador() throws RemoteException{}
    
    @Override
    public String email(Pessoa pessoa) throws RemoteException {
        
        return GerarEmail.gerar(pessoa);
        
    }

    @Override
    public int numero(Pessoa pessoa) throws RemoteException {
        
        return GerarNumero.gerar(pessoa);
        
    }   
    
}
