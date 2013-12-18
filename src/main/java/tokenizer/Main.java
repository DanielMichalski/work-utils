package tokenizer;

import java.util.StringTokenizer;

/**
 * Author: Daniel
 */
public class Main {
    static String text = "1, '0', '0', '0016', '123456','','SX000000000002','************8326'," +
            "'2013.08.26,10:55:45','MasterCard','S','30730002','0016','1','3000','A','011E'," +
            "'24CF96FC5BACA61E','A0000000041010','','','654321','B13F132A0CC376B2D330F2DC4005A0EC'," +
            "'0800008000','E800','1','PLN','','0','','','','0','0'";

    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer(text, ",");

        int suma = 0;
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
            suma++;
        }

        System.out.println(suma);

    }
}
