package algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Daniel
 */
public class Anagram {
    public static boolean isAnagram1(String text1, String text2) {
        if (text1 == null || text2 == null) return false;
        if (text1.isEmpty() || text2.isEmpty()) return false;

        String text1Lower = text1.toLowerCase();
        String text2Lower = text2.toLowerCase();

        String text1WithoutSpaces = text1Lower.replaceAll(" ", "");
        String text2WithoutSpaces = text2Lower.replaceAll(" ", "");

        if (text1WithoutSpaces.length() != text2WithoutSpaces.length()) return false;

        Map<Character, Integer> map1 = addToMap(text1);
        Map<Character, Integer> map2 = addToMap(text2);

        for (Character character : map1.keySet()) {
            if (!map1.get(character).equals(map2.get(character))) {
                return false;
            }
        }

        return true;

    }

    public static boolean isAnagram2(String text1, String text2) {
        if (text1 == null || text2 == null) return false;
        if (text1.isEmpty() || text2.isEmpty()) return false;

        String text1Lower = text1.toLowerCase();
        String text2Lower = text2.toLowerCase();

        String text1WithoutSpaces = text1Lower.replaceAll(" ", "");
        String text2WithoutSpaces = text2Lower.replaceAll(" ", "");

        if (text1WithoutSpaces.length() != text2WithoutSpaces.length()) return false;

        Map<Character, Integer> map1 = addToMap(text1);

        for (int i = 0; i < text2.length(); i++) {
            if (map1.get(text2.charAt(i)) == null || map1.get(text2.charAt(i)) == 0) return false;
            map1.put(text2.charAt(i), map1.get(text2.charAt(i)) - 1);
        }

        for (Character character : map1.keySet()) {
            if (map1.get(character) != 0) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> addToMap(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (map.get(character) == null) {
                map.put(character, 0);
            }
            map.put(character, map.get(character) + 1);
        }

        return map;
    }

}
