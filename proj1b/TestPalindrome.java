import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new CharacterComparator() {
        @Override
        public boolean equalChars(char x, char y) {
            return x == y;
        }
    };

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    // Uncomment this class once you've created your Palindrome class.
    
    @Test
    public void testPalindrome() {
        assertTrue(palindrome.isPalindrome("refer"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("c"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("cat"));
    
        assertTrue(palindrome.isPalindrome("refer", cc));
        assertTrue(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("c", cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertFalse(palindrome.isPalindrome("cat", cc));
    }
}
