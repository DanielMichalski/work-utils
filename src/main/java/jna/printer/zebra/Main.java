//package jna.printer.zebra;
//
//import com.zebra.sdk.comm.*;
//import com.zebra.sdk.printer.*;
//
///**
// * Author: Daniel
// */
//public class Main {
//
//    public static final String PRINTER_NAME = "Small labels printer";
//
//    public static void main(String[] args) throws Exception {
//        PrinterStatusCode printerStatusCode = getStatus(PRINTER_NAME);
//
//        System.out.println("Status: " + printerStatusCode);
//    }
//
//    public static PrinterStatusCode getStatus(String printerName) {
//        PrinterStatusCode printerStatusCode = null;
//
//        try {
//            Connection connection = new DriverPrinterConnection(printerName, 0, 0);
//            connection.open();
//
//            ZebraPrinter printer = ZebraPrinterFactory.getInstance(connection);
//
//            PrinterStatus printerStatus = printer.getCurrentStatus();
//            printerStatusCode = PrinterStatusCode.getStatus(printerStatus);
//
//            showMoreInfo(printer);
//
//            connection.close();
//        } catch (Exception e) {
//            printerStatusCode = PrinterStatusCode.NOT_CONNECTED;
//        }
//
//        return printerStatusCode;
//    }
//
//    private static void showMoreInfo(ZebraPrinter printer) throws ConnectionException {
//        PrinterStatus printerStatus;ZebraPrinterLinkOs linkOsPrinter = ZebraPrinterFactory.createLinkOsPrinter(printer);
//
//        printerStatus = (linkOsPrinter != null) ? linkOsPrinter.getCurrentStatus() : printer.getCurrentStatus();
//
//        String[] printerStatusString = new PrinterStatusMessages(printerStatus).getStatusMessage();
//        String[] printerStatusPrefix = getPrinterStatusPrefix(printerStatus);
//
//        final StringBuilder sb = new StringBuilder();
//
//        for (String s : printerStatusPrefix) {
//            sb.append(s + "\r\n");
//        }
//        for (String s : printerStatusString) {
//            sb.append(s + "\r\n");
//        }
//
//        System.out.println(sb.toString());
//    }
//
//    private static String[] getPrinterStatusPrefix(PrinterStatus printerStatus) {
//        boolean ready = printerStatus != null ? printerStatus.isReadyToPrint : false;
//        String readyString = "Printer " + (ready ? "ready" : "not ready");
//        String labelsInBatch = "Labels in batch: " + String.valueOf(printerStatus.labelsRemainingInBatch);
//        String labelsInRecvBuffer = "Labels in buffer: " + String.valueOf(printerStatus.numberOfFormatsInReceiveBuffer);
//        return new String[] { readyString, labelsInBatch, labelsInRecvBuffer };
//    }
//}
