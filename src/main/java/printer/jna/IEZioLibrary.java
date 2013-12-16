package printer.jna;

import com.sun.jna.Library;

/**
 * Author: Daniel
 */
public interface IEZioLibrary extends Library {

    public int FindFirstUSB(String usbID);

    public int OpenUSB(String usbID);

    public int sendcommand(String command);

    public int RcvBuf(char[] ret, int maxLength);
}
