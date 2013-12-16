package palindrom;

import org.junit.Assert;
import org.junit.Test;

/**
 * Author: Daniel
 */
public class PalindromTest {
    @Test
    public void testIsPalindrom() throws Exception {
        Assert.assertTrue(Palindrom.isPalindrom("kajak"));
        Assert.assertTrue(Palindrom.isPalindrom("ada"));
        Assert.assertTrue(Palindrom.isPalindrom("kakak"));
        Assert.assertTrue(Palindrom.isPalindrom("maraaram"));

        Assert.assertFalse(Palindrom.isPalindrom("abac"));
        Assert.assertFalse(Palindrom.isPalindrom(""));
        Assert.assertFalse(Palindrom.isPalindrom(null));
        Assert.assertFalse(Palindrom.isPalindrom("kararask"));
    }
}
