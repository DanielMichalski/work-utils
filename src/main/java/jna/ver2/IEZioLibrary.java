package jna.ver2;

import com.sun.jna.Library;

/**
 * Author: Daniel
 */
public interface IEZioLibrary extends Library {

    public int openport(String port);

    public int OpenDriver(String printerDriverName);

    public int OpenUSB(String usbID);

    public int sendcommand(String command);

    public int RcvBuf(byte[] ret, int maxLength);

    public int FindFirstUSB(byte[] usbId);

    public int FindNextUSB(byte[] usbId);

    public void closeport();

    public int OpenUSB(char[] m);
}