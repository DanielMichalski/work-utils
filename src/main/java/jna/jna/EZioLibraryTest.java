package jna.jna;

import com.sun.jna.Native;

/**
 * Author: Daniel
 */
public class EZioLibraryTest {
    private IEZioLibrary eZioLib;

    public EZioLibraryTest() {
        loadNativeLibrary();

        byte[] firstUsb = findFirstUsb();
        String firstUsbId = new String(firstUsb).trim();
        openUSB(firstUsbId);
        sendActiveResponseCommand();
        sendCheckCommand();
        closePort();

        System.out.println();

        byte[] secondUsb = findNextUsb();
        String secondUsbId = new String(secondUsb).trim();
        openUSB(secondUsbId);
        sendActiveResponseCommand();
        sendCheckCommand();
        closePort();
    }


    private void loadNativeLibrary() {
        eZioLib = (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);
    }


    private void openPort() {
        int returnVal = eZioLib.openport("6");
        System.out.println("openport() --> " + returnVal);
    }


    private void openUSB(String usbPort) {
        System.out.println("usbId = " + usbPort);
        int returnedVal = eZioLib.OpenUSB(usbPort);
        System.out.println("eZioLib.OpenUSB(), returnedVal: " + returnedVal);
    }


    private void openDriver(String printerDriverName) {
        int returnedVal = eZioLib.OpenDriver(printerDriverName);
        System.out.println("openDriver() --> " + returnedVal);
    }


    private byte[] findFirstUsb() {
        byte[] array = new byte[32];
        int returnedVal = eZioLib.FindFirstUSB(array);
        System.out.println("findFirstUsb() --> " + returnedVal);

        for (byte anArray : array) {
            System.out.print(anArray + " ");
        }

        System.out.println();

        return array;

    }

    private byte[] findNextUsb() {
        byte[] array = new byte[32];
        int returnedVal = eZioLib.FindNextUSB(array);
        System.out.println("findNextUsb() --> " + returnedVal);

        for (byte anArray : array) {
            System.out.print(anArray + " ");
        }

        System.out.println();

        return array;
    }

    private void sendImmediateResponse() {
        int returnedVal = eZioLib.sendcommand("^XSET,IMMEDIATE,1");
        System.out.println("^XSET,IMMEDIATE,1 returned val -->  " + returnedVal);
    }


    private void sendActiveResponseCommand() {
        int returnedVal = eZioLib.sendcommand("^XSET,ACTIVERESPONSE,1");
        System.out.println("^XSET,ACTIVERESPONSE,1 returned val -->  " + returnedVal);
//        byte[] ret = new byte[100];

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        int msgSize = eZioLib.RcvBuf(ret, ret.length);

        /*byte[] ret = new byte[64];
        int buffSize;
        while ((buffSize = eZioLib.RcvBuf(ret, ret.length)) <= 0);*/
    }


    private void sendCheckCommand() {
        byte[] ret = new byte[100];
        int returnedVal = eZioLib.sendcommand("~S,CHECK");

        int msgSize = 0;
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

        System.out.println("msgSize = " + msgSize);
        System.out.println("~S,CHECK returned val -->  " + returnedVal);
        System.out.println("~S,CHECK returned String --> " + new String(ret));
    }


    private void closePort() {
        eZioLib.closeport();
    }


    public static void main(String[] args) throws Exception {
        new EZioLibraryTest();
    }
}