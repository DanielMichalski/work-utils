package jna.printer.zebra;

import com.zebra.sdk.printer.PrinterStatus;

/**
 * Author: Daniel
 */
public enum PrinterStatusCode {
    PARTIAL_FORM_AT_IN_PROGRESS,
    HEAD_COLD,
    HEAD_OPEN,
    HEAD_TOO_HOT,
    PAPER_OUT,
    RIBBON_OUT,
    RECEIVE_BUFFER_FULL,
    PAUSED,
    READY_TO_PRINT,
    NOT_CONNECTED;

    public static PrinterStatusCode getStatus(PrinterStatus printerStatus) {
        if (printerStatus.isPartialFormatInProgress) return PARTIAL_FORM_AT_IN_PROGRESS;
        if (printerStatus.isHeadCold) return HEAD_COLD;
        if (printerStatus.isHeadOpen) return HEAD_OPEN;
        if (printerStatus.isHeadTooHot) return HEAD_TOO_HOT;
        if (printerStatus.isPaperOut) return PAPER_OUT;
        if (printerStatus.isRibbonOut) return RIBBON_OUT;
        if (printerStatus.isReceiveBufferFull) return RECEIVE_BUFFER_FULL;
        if (printerStatus.isPaused) return PAUSED;
        if (printerStatus.isReadyToPrint) return READY_TO_PRINT;

        return null;
    }

}
