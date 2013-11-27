package rmi.rmi3.client;

import rmi.rmi3.server.ServerInterface;

import java.rmi.Naming;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class ClientImpl {
    public static void main(String[] args) {
        try {
            ServerInterface server = (ServerInterface) Naming.lookup("hello");
            server.hello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
