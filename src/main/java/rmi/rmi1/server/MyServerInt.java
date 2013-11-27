package rmi.rmi1.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public interface MyServerInt extends Remote {
    String getDescription(String text) throws RemoteException;
}
