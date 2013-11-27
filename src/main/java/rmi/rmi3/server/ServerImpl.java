package rmi.rmi3.server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class ServerImpl extends UnicastRemoteObject
        implements ServerInterface {

    protected ServerImpl() throws RemoteException {
    }

    @Override
    public void hello() throws RemoteException {
        System.out.println("ServerImpl.hello()");
    }

    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            Naming.bind("hello", server);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
