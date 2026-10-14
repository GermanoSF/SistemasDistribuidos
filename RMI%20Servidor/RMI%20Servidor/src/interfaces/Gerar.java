/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import model.Pessoa;
import java.rmi.*;

/**
 *
 * @author laboratorio
 */
public interface Gerar extends Remote{
    
    public String email(Pessoa pessoa) throws RemoteException;
    public int numero(Pessoa pessoa) throws RemoteException;
    
}
