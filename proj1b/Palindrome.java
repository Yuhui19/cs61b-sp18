public class Palindrome {
    
    public Deque<Character> wordToDeque(String word) {
        char[] arr = word.toCharArray();
        LinkedListDeque<Character> lld = new LinkedListDeque<>();
        for (char c : arr) {
            lld.addLast(c);
        }
        return lld;
    }
    
    public boolean isPalindrome(String word) {
        int length = word.length();
        if (length <= 1) {
            return true;
        }
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int length = word.length();
        if (length <= 1) {
            return true;
        }
        for (int i = 0; i < length / 2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
