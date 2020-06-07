public class OffByN implements CharacterComparator {
	
	int diff;
	
	@Override
	public boolean equalChars(char x, char y) {
		return Math.abs(x - y) == diff;
	}
	
	public OffByN(int N) {
		diff = N;
	}

}
