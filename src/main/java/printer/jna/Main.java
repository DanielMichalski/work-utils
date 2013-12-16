package printer.jna;

import com.sun.jna.Native;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        int returnVal;

        IEZioLibrary eZioLib =
                (IEZioLibrary) Native.loadLibrary("EZio64", IEZioLibrary.class);

        // FindFirstUSB
        returnVal = eZioLib.FindFirstUSB("USB001");
        System.out.println("eZioLib.FindFirstUSB('USB001'), wynik: " + returnVal);

        // OpenUSB
        returnVal = eZioLib.OpenUSB("USB001");
        System.out.println("eZioLib.OpenUSB('USB001'), wynik: " + returnVal);

        // sendcommand
        returnVal = eZioLib.sendcommand("^XSET,ACTIVERESPONSE,1");
        System.out.println("^XSET,ACTIVERESPONSE,1, wynik: " + returnVal);
    }
}
