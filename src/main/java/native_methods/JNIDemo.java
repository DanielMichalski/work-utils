package native_methods;

/**
 * Author: Daniel
 */
public class JNIDemo {
    static {
        System.loadLibrary("jnidemo");
    }

    public native int calculateStringLength(String text);

    public static void main(String[] args) {
        String text = "testowy tekst";

        JNIDemo jniDemo = new JNIDemo();
        int length = jniDemo.calculateStringLength(text);

        String tekst = String.format("Length of tekst: '%s' is %d", text, length);
        System.out.println(tekst);
    }
}
