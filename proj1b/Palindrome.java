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
		char[] arr = word.toCharArray();
		if (arr.length <= 1) {
			return true;
		}
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[arr.length - 1 - i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
		char[] arr = word.toCharArray();
		if (arr.length <= 1) {
			return true;
		}
		for (int i = 0; i < arr.length / 2; i++) {
			if (!cc.equalChars(arr[i], arr[arr.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}
}
