package algorytmy.substring;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        String test = "34";
        int msgSize = test.length();

        System.out.println(test.substring(msgSize-2, msgSize));


        char[] chars = {'2', 'f', 'd'};
        String s = new String(chars, 0, chars.length);
        System.out.println("s = " + s);
    }
}
