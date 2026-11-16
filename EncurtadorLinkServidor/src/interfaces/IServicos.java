/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.rmi.*;

/**
 *
 * @author laboratorio
 */
public interface IServicos extends Remote{
    
    public String encurtarLink(String linkComprido) throws RemoteException;
    
}
