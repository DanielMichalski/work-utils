package jna.ver.ver2;

import javax.print.*;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.standard.PrinterStateReason;
import javax.print.attribute.standard.PrinterStateReasons;
import javax.print.attribute.standard.Severity;
import javax.print.event.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.Set;

/**
 * PrintTest
 */
public class PrintTest implements PrintServiceAttributeListener, PrintJobListener, Doc, Printable, PrintJobAttributeListener {

    private static final transient String TEXT = "12345";

    public static void main(String[] args) {
        PrintTest test = new PrintTest();
        test.checkPrinters();
    }

    public void checkPrinters() {
        Thread newThread = new Thread(new Runnable() {
            public void run() {
                PrintService ps = PrinterJob.getPrinterJob().getPrintService();

                DocFlavor[] myFlavors = ps.getSupportedDocFlavors();

                ps.addPrintServiceAttributeListener(PrintTest.this);
                DocPrintJob docJob = ps.createPrintJob();
                docJob.addPrintJobAttributeListener(PrintTest.this, null);
                docJob.addPrintJobListener(PrintTest.this);
                try {
                    docJob.print(PrintTest.this, null);
                } catch (PrintException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });

        newThread.start();


    }

    public void attributeUpdate(PrintServiceAttributeEvent psae) {
        System.out.println(psae.getAttributes());
    }

    public void printDataTransferCompleted(PrintJobEvent pje) {
        System.out.println("Transfer completed");
    }

    public void printJobCompleted(PrintJobEvent pje) {
        System.out.println("Completed");
    }

    public void printJobFailed(PrintJobEvent pje) {
        System.out.println("Failed");
        PrinterStateReasons psr = pje.getPrintJob().getPrintService().getAttribute(PrinterStateReasons.class);
        if (psr != null) {
            Set<PrinterStateReason> errors = psr.printerStateReasonSet(Severity.REPORT);
            for (PrinterStateReason reason : errors)
                System.out.printf(" Reason : %s", reason.getName());
            System.out.println();
        }
    }

    public void printJobCanceled(PrintJobEvent pje) {
        System.out.println("Canceled");
    }

    public void printJobNoMoreEvents(PrintJobEvent pje) {
        System.out.println("No more events");
    }

    public void printJobRequiresAttention(PrintJobEvent pje) {
        System.out.println("Job requires attention");
        PrinterStateReasons psr = pje.getPrintJob().getPrintService().getAttribute(PrinterStateReasons.class);
        if (psr != null) {
            Set<PrinterStateReason> errors = psr.printerStateReasonSet(Severity.REPORT);
            for (PrinterStateReason reason : errors)
                System.out.printf(" Reason : %s", reason.getName());
            System.out.println();
        }
    }

    public DocFlavor getDocFlavor() {
        return DocFlavor.SERVICE_FORMATTED.PRINTABLE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Object getPrintData() throws IOException {
        return this;
    }

    public DocAttributeSet getAttributes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Reader getReaderForText() throws IOException {
        return null; //To change body of implemented methods use File | Settings | File Templates.
    }

    public InputStream getStreamForBytes() throws IOException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return pageIndex == 0 ? PAGE_EXISTS : NO_SUCH_PAGE;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void attributeUpdate(PrintJobAttributeEvent pjae) {
        System.out.println("Look out");
    }
}