package rmi.rmi2.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
