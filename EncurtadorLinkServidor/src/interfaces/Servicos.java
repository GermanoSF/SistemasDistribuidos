/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import controller.EncurtarLink;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author laboratorio
 */
public class Servicos extends UnicastRemoteObject implements IServicos{
    
    public Servicos() throws RemoteException{}
    
    @Override
    public String encurtarLink(String linkComprido) throws RemoteException{
        
        return EncurtarLink.encurtar(linkComprido);
        
    }
    
}
