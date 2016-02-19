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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            //obtain stub for the registry
            Registry registry = LocateRegistry.getRegistry(host);
            //obtain stub for remote object
            Hello stub = (Hello) registry.lookup("Hello");
            //invoke sayHello method 
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}