/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.hello;

/**
 *
 * @author nayanakamath
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

//interface Hello extends java.rmi.Remote
//method sayHello returns a string to the caller
public interface Hello extends Remote {
    //remote method must declare Remote Exception is its throws clause
    String sayHello() throws RemoteException;
}