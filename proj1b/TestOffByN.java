import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    OffByN offBy5 = new OffByN(5);
    
    // Your tests go here.
    // Uncomment this class once you've created your
    // CharacterComparator interface and OffByOne class.
    
    @Test
    public void test() {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertTrue(offBy5.equalChars('f', 'k'));
        assertTrue(offBy5.equalChars('L', 'Q'));
        
        assertFalse(offBy5.equalChars('a', 'a'));
        assertFalse(offBy5.equalChars('a', 'A'));
        assertFalse(offBy5.equalChars('f', 'm'));
        assertFalse(offBy5.equalChars('Z', 'z'));
    }
}
