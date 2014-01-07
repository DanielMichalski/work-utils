package jna.ver2;

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

            eZioLib.closeport();

            if (returnedVal == 1) {
                System.out.println("Connected printer via USB: " + usbId);
            } else {
                System.out.println("Disconnected printer via USB: " + usbId);
            }
        }
    }

    private void loadNativeLibrary() {
        try {
            eZioLib = (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);
        } catch (UnsatisfiedLinkError e) {
            System.err.println(e);
        }

    }
}