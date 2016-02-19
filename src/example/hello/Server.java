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

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server implements Hello {
        
    public Server() {}

    //implement sayHello method
    public String sayHello() {
        return "Hello world!!!";
    }
       
    public static void main(String args[]) {
        
        try {
            //create remote object
            Server obj = new Server();
            //export remote object to receive remote method invocations
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            //bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}