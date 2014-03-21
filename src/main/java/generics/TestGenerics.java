package generics;

/**
 * Author: Daniel
 */
public class TestGenerics {
//    public double greater(Double a, Double b) {
//        if (a.compareTo(b) > 0) {
//            return a;
//        } else {
//            return b;
//        }
//    }
//
//    public int greater(Integer a, Integer b) {
//        if (a.compareTo(b) > 0) {
//            return a;
//        } else {
//            return b;
//        }
//    }

    public static <T extends Comparable> T greater (T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }
}
