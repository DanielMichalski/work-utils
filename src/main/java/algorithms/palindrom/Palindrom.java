package algorithms.palindrom;

/**
 * Author: Daniel
 */
public class Palindrom {
    public static boolean isPalindrom(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(text.length()-1-i)) {
                return false;
            }
        }

        return true;
    }
}
