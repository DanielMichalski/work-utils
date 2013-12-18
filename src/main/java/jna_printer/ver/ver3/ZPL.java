package jna_printer.ver.ver3;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.QueuedJobCount;
import javax.print.event.PrintJobAttributeEvent;
import javax.print.event.PrintJobAttributeListener;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author: Daniel
 */
public class ZPL {
    private static final String PRINTER_NAME = "Receipt's jna_printer";
    // private static final String barcodeString =  "${^XA^FO100,100^BY7^BCN,100,Y,N,N^FD123456^FS^XZ}$";
    private static final String queryString = "${^XSET,ACTIVERESPONSE,1}$";

    private static final String queryString2 = "${^L\n" +
            "Dy2-me-dd\n" +
            "Th:m:s\n" +
            "R8,13,631,384,8,8\n" +
            "BA2,30,57,2,6,80,0,1,22-.$ /+%40\n" +
            "BA2,30,200,2,5,80,0,0,22-.$ /+%40\n" +
            "AB,400,25,1,1,0,0,Human Readable\n" +
            "AB,400,170,1,1,0,0,No Human Readable\n" +
            "AD,36,300,1,1,0,0I,Code39 with check\n" +
            "E}$";



    public static void main(String[] args) {
        checkPrinter();
    }

    private static void checkPrinter() {
        String queryString = "${^XSET,ACTIVERESPONSE,1}$";

        try {
            PrintService printService = findPrintService();

            System.out.println(printService.getAttribute(QueuedJobCount.class).getValue());

            if (printService == null) {
                System.out.println(PRINTER_NAME + " jna_printer not found.");
                return;
            }

            DocPrintJob job = printService.createPrintJob();
            job.addPrintJobListener(new MyPrintJobListener());
            job.addPrintJobAttributeListener(new MyPrintJobAttributeListener(), null);

            InputStream is = new ByteArrayInputStream(queryString2.getBytes());
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(is, flavor, null);

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

        for (PrintService printer : printers) {
            if (printer.getName().equalsIgnoreCase(PRINTER_NAME)) {
                printService = printer;
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
