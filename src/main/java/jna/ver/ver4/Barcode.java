/*
package printer.ver.ver4;

import org.cups4j.PrintJob;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.event.PrintJobAttributeEvent;
import javax.print.event.PrintJobAttributeListener;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

*/
/**
 * Author: Daniel
 *//*

public class Barcode {
    private static final String PRINTER_NAME = "Receipt's jna";
    // private static final String barcodeString =  "${^XA^FO100,100^BY7^BCN,100,Y,N,N^FD123456^FS^XZ}$";
    private static final String queryString = "${^XSET,ACTIVERESPONSE,1}$";

    private static final String queryString2 = "${~T}$";

    public static void main(String[] args) {
        printData();
    }

    private static void printData() {
        try {
            PrintService printService = findPrintService();

            if (printService == null) {
                System.out.println(PRINTER_NAME + " jna not found.");
                return;
            }

            DocPrintJob job = printService.createPrintJob();
            job.addPrintJobListener(new MyPrintJobListener());
            job.addPrintJobAttributeListener(new MyPrintJobAttributeListener(), null);

            InputStream is = new ByteArrayInputStream(queryString.getBytes());
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(is, flavor, null);

            PrintJob.Builder builder = new PrintJob.Builder(is);
            PrintJob build = builder.build();

            job.print(doc, null);
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (PrintException e) {
            e.printStackTrace();
        }
    }

    private static PrintService findPrintService() {
        DocFlavor myFormat = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        PrintService[] printers = PrintServiceLookup.lookupPrintServices(myFormat, aset);
        PrintService printService = null;

        for (PrintService jna : printers) {
            if (jna.getName().equalsIgnoreCase(PRINTER_NAME)) {
                printService = jna;
            }
        }

        return printService;
    }

    static class MyPrintJobListener implements PrintJobListener {
        @Override
        public void printDataTransferCompleted(PrintJobEvent pje) {
            System.out.println("1");
        }

        @Override
        public void printJobCompleted(PrintJobEvent pje) {
            System.out.println("2");
        }

        @Override
        public void printJobFailed(PrintJobEvent pje) {
            System.out.println("3");
        }

        @Override
        public void printJobCanceled(PrintJobEvent pje) {
            System.out.println("4");
        }

        @Override
        public void printJobNoMoreEvents(PrintJobEvent pje) {
            System.out.println("5");
        }

        @Override
        public void printJobRequiresAttention(PrintJobEvent pje) {
            System.out.println("6");
        }
    }

    static class MyPrintJobAttributeListener implements PrintJobAttributeListener {
        @Override
        public void attributeUpdate(PrintJobAttributeEvent pjae) {
            System.out.println("7");
        }
    }
}
*/
