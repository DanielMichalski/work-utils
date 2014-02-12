package jna.printer.ver2;

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
        loadNativeLibrary();

        //checkConnectedPrinters();
        checkPrinterStatus();
    }

    private void checkConnectedPrinters() {
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

    public void checkPrinterStatus() {
        int HOW_MANY_INSTALLED_PRINTERS = 3;

        for (int i = 0; i < HOW_MANY_INSTALLED_PRINTERS; i++) {
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

                    eZioLib.sendcommand("^XSET,ACTIVERESPONSE,1");
                    String printerStatusCode = sendCheckCommand(eZioLib);

                    System.out.println("printerStatusCode = " + printerStatusCode);;

                    eZioLib.closeport();
                    return;
                } else {
                    eZioLib.closeport();
                    System.out.println(String.format("Printer %s is not connected", usbId));
                }

            eZioLib.closeport();
        }
    }


    private String sendCheckCommand(IEZioLibrary eZioLib) {
        byte[] ret = new byte[100];
        int msgSize;
        eZioLib.sendcommand("~S,CHECK");

        for (int i = 0; i < 10; i++) {
            msgSize = eZioLib.RcvBuf(ret, ret.length);
            if (msgSize > 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String returnedString = new String(ret);

        if (returnedString.length() >= 2) {
            returnedString = returnedString.substring(returnedString.length() - 2, returnedString.length());
        }

        return returnedString;
    }

    private void loadNativeLibrary() {
        try {
            eZioLib = (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);
        } catch (UnsatisfiedLinkError e) {
            System.err.println(e);
        }

    }
}