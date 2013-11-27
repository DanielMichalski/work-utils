package rmi.rmi1.client;

import rmi.rmi1.server.MyServerInt;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.RMISecurityManager;

/**
 * Author: Daniel
 * Date: 20.11.13.
 */
public class MyClientMain {
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        String url = "rmi.rmi1://localhost/";

        try {
            Context context = new InitialContext();
            MyServerInt myRemoteObject = (MyServerInt) context.lookup(url + "MyRemoteObject");
            myRemoteObject.getDescription("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
