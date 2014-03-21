package generics;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Integer greater = TestGenerics.greater(8, 9);
        System.out.println("greater = " + greater);

        String greater1 = TestGenerics.greater("a", "b");
        System.out.println("greater1 = " + greater1);

        Boolean greater2 = TestGenerics.greater(true, false);
        System.out.println("greater2 = " + greater2);

    }
}
