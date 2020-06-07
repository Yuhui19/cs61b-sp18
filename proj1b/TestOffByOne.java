import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    // Uncomment this class once you've created your
    // CharacterComparator interface and OffByOne class.

    @Test
    public void test() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('f', 'g'));
        assertTrue(offByOne.equalChars('L', 'M'));
        assertTrue(offByOne.equalChars('Z', 'Y'));
        assertTrue(offByOne.equalChars('@', 'A'));
        assertFalse(offByOne.equalChars('f', 'G'));
        assertFalse(offByOne.equalChars('G', 'g'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('f', 'k'));
        assertFalse(offByOne.equalChars('Z', 'z'));
        assertFalse(offByOne.equalChars('?', '!'));
        assertFalse(offByOne.equalChars('A', 'C'));
        assertFalse(offByOne.equalChars('A', '&'));
        assertFalse(offByOne.equalChars('f', '('));
    }
}
