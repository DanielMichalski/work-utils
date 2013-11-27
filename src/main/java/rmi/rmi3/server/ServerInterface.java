package rmi.rmi3.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public interface ServerInterface extends Remote {
    void hello() throws RemoteException;
}
