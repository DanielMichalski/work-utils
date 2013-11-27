package ver3;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 * Author: Daniel
 */
public class ZPL {

    public static final String PRINTER_NAME = "Godex DT2";

    public static void main(String[] args) {
        try {
            DocFlavor myFormat = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();

            PrintService[] printers = PrintServiceLookup.lookupPrintServices(myFormat, aset);

            PrintService printService = null;

            for (PrintService printer : printers) {
                if (printer.getName().equals(PRINTER_NAME)) {
                    printService = printer;
                }
            }

            if (printService == null) {
                System.out.println(PRINTER_NAME + " printer not found.");
                return;
            }

            DocPrintJob job = printService.createPrintJob();
            String s = "^XSET,ACTIVERESPONSE,1";

            byte[] by = s.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(by, flavor, null);
            job.print(doc, null);

        } catch (PrintException e) {
            e.printStackTrace();
        }
    }
}
