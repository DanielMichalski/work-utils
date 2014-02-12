package jna.printer.ver2;

import com.sun.jna.Native;

/**
 * Author: Daniel
 */
public class CheckStatus {
    private IEZioLibrary eZioLib;

    public CheckStatus() {
        byte[] byteArray = new byte[100];
        int msgSize;

        loadNativeLibrary();

       // eZioLib.openport("6");
        byte[] usbId = new byte[100];
        eZioLib.FindFirstUSB(usbId);
        eZioLib.OpenUSB(usbId);
        eZioLib.sendcommand("^XSET,ACTIVERESPONSE,1");
        eZioLib.sendcommand("~S,CHECK");

        for (int i = 0; i < 5; i++) {
            msgSize = eZioLib.RcvBuf(byteArray, byteArray.length);
            if (msgSize > 0) {
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(new String(byteArray));
        eZioLib.closeport();
    }

    public static void main(String[] args) {
        new CheckStatus();
    }

    private void loadNativeLibrary() {
        try {
            eZioLib = (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);
        } catch (UnsatisfiedLinkError e) {
            System.err.println(e);
        }

    }
}
