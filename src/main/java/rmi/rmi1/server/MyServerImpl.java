package rmi.rmi1.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    public MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDescription(String text) throws RemoteException {
        System.out.println("MyServerImpl.getDescription: " + text);
        return "getDescription: " + text;
    }
}
