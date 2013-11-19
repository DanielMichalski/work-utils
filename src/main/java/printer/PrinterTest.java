package printer;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.Attribute;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.*;

/**
 * Author: Daniel
 * Date: 19.11.13.
 */
public class PrinterTest {
    static String PRINTER_NAME = "Xerox Phaser 6280DN";

    public static void main(String[] args) {
        boolean available = isPrinterAvailable(PRINTER_NAME);
        String text = String.format("Print %s available? %b", PRINTER_NAME, available);
        System.out.println(text);

        System.out.println();

        checkPrinterAttribs(PRINTER_NAME);
    }

    /**
     * Metoda sprawdza czy drukarka o podanej nazwie jest dostępna
     * @param printerName nazwa sprawdzanej drukarki
     * @return true jeśli drukarka jest dostępna, false w przeciwnym wypadku
     */
    public static boolean isPrinterAvailable(String printerName) {
        DocFlavor myFormat = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        PrintService[] printers = PrintServiceLookup.lookupPrintServices(myFormat, aset);

        for (PrintService printService : printers) {
            if (printService.getName().equals(printerName)) {
                Attribute attribute =
                        printService.getAttribute(PrinterIsAcceptingJobs.class);

                if (attribute.toString().equals("accepting-jobs")) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void checkPrinterAttribs(String printerName) {
        DocFlavor myFormat = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

        PrintService[] printers = PrintServiceLookup.lookupPrintServices(myFormat, aset);

        for (PrintService printService : printers) {
            AttributeSet att = printService.getAttributes();

            for (Attribute a : att.toArray()) {
                String attributeName;
                String attributeValue;
                attributeName = a.getName();
                attributeValue = att.get(a.getClass()).toString();
                System.out.println(attributeName + " : " + attributeValue);
            }
        }
    }
}
