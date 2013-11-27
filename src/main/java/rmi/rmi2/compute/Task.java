package rmi.rmi2.compute;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public interface Task<T> {
    T execute();
}
