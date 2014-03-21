package algorithms;

import org.junit.Test;

/**
 * Author: Daniel
 */
public class AnagramTest {
    @Test
    public void testIsAnagram1() throws Exception {

        String text1 = "";
        String text2 = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000000; i++) {
            sb.append("a");
        }

        text1 = sb.toString();
        text2 = sb.toString();

        text2 += "g";

        long start = System.currentTimeMillis();
        boolean result = Anagram.isAnagram1(text1, text2);
        long end = System.currentTimeMillis();

        System.out.println("1. Time = " + (end - start));
        System.out.println("1. Result = " + result);
    }

    @Test
    public void testIsAnagram2() throws Exception {

        String text1 = "";
        String text2 = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000000; i++) {
            sb.append("a");
        }

        text1 = sb.toString();
        text2 = sb.toString();

        text2 += "g";

        long start = System.currentTimeMillis();
        boolean result = Anagram.isAnagram2(text1, text2);
        long end = System.currentTimeMillis();

        System.out.println("2. Time = " + (end - start));
        System.out.println("2. Result = " + result);
    }

}
