package algorithms.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";
        String s3 = "3";
        String s4 = "4";
        String s5 = "5";

        List<String> list = new ArrayList<String>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Collections.shuffle(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
