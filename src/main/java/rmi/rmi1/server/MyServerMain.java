package rmi.rmi1.server;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class MyServerMain {
    public static void main(String[] args) {
        try {
            MyServerImpl obj1 = new MyServerImpl();
            Context contex = new InitialContext();
            contex.bind("rmi.rmi1:MyRemoteObject", obj1);
            System.out.println("Wait");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
