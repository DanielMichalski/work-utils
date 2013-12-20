package jna.jna;

import com.sun.jna.Native;

/**
 * Author: Daniel
 */
public class CheckConnectedPrintersTest {
    private IEZioLibrary eZioLib;

    public static void main(String[] args) {
        new CheckConnectedPrintersTest();
    }

    public CheckConnectedPrintersTest() {
        checkConnectedPrinters();
    }

    private void checkConnectedPrinters() {
        loadNativeLibrary();

        for (int i = 0; i < 3; i++) {
            String usbId;
            byte[] array = new byte[32];
            int returnedVal;

            if (i == 0) {
                returnedVal = eZioLib.FindFirstUSB(array);
                usbId = new String(array).trim();
            } else {
                returnedVal = eZioLib.FindNextUSB(array);
                usbId = new String(array).trim();
            }

            if (returnedVal == 1) {
                System.out.println("Connected printer: " + usbId);
            }
        }

        eZioLib.closeport();
    }

    private void loadNativeLibrary() {
        try {
            eZioLib = (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);
        } catch (UnsatisfiedLinkError e) {
            System.err.println(e);
        }

    }
}