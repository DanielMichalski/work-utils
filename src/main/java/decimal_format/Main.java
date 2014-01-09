package decimal_format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {

        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
        DecimalFormat df = (DecimalFormat)nf;

        double a = 2.394;
        double b = 2.3;
        double c = 2;

        System.out.println("a = " + df.format(a));
        System.out.println("b = " + df.format(b));
        System.out.println("c = " + df.format(c));
    }
}
