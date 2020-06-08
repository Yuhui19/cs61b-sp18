import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

//	@Test
//	public void testSADandADS() {
//
//	}
	
//	@Test
//	public void testAddFirst() {
//		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//		// addFirst
//		for (int i=0; i<100; i++) {
//			int random = StdRandom.uniform(100);
//			ads.addFirst(random);
//			sad.addFirst(random);
//		}
//		for (int i=0; i<100; i++) {
//			Integer actual = ads.get(i);
//			Integer expected = sad.get(i);
//			assertEquals("Oh noooo!\nThis is bad in addFirst():\n   Random number " + actual
//								 + " not equal to " + expected + "!",
//					expected, actual);
//		}
//	}
	
//	@Test
//	public void testAddLast() {
//		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//		// addLast
//		for (int i=0; i<100; i++) {
//			int random = StdRandom.uniform(100);
//			ads.addLast(random);
//			sad.addLast(random);
//		}
//		for (int i=0; i<100; i++) {
//			Integer actual = ads.get(i);
//			Integer expected = sad.get(i);
//			assertEquals("Oh noooo!\nThis is bad in addLast():\n   Random number " + actual
//								 + " not equal to " + expected + "!",
//					expected, actual);
//		}
//	}
	
//	@Test
//	public void testRemoveFirst() {
//		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
//		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
//		// removeFirst
//		for (int i=0; i<100; i++) {
//			int random = StdRandom.uniform(100);
//			ads.addFirst(random);
//			sad.addFirst(random);
//		}
//		for (int i=0; i<100; i++) {
//			Integer actual = ads.removeFirst();
//			Integer expected = sad.removeFirst();
//			assertEquals("Oh noooo!\nThis is bad in removeFirst():\n   Random number " + actual
//								 + " not equal to " + expected + "!",
//					expected, actual);
//		}
//	}
	
	@Test
	public void testRemoveLast() {
		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
		// addLast
		for (int i=0; i<100; i++) {
			int random = StdRandom.uniform(100);
			ads.addLast(random);
			sad.addLast(random);
		}
		for (int i=0; i<100; i++) {
			Integer actual = ads.removeLast();
			Integer expected = sad.removeLast();
			assertEquals("Oh noooo!\nThis is bad in removeLast():\n   Random number " + actual
								 + " not equal to " + expected + "!",
					expected, actual);
		}
	}
	
	@Test
	public void testArratDeque2() {
		ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
		StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
		int random = StdRandom.uniform(100);
		ads.addFirst(random);
		sad.addFirst(random);
		assertEquals("addFirst("+random+")", ads.get(0), sad.get(0));
		System.out.println("addFirst("+random+")");
		
		random = StdRandom.uniform(100);
		ads.addLast(random);
		sad.addLast(random);
		assertEquals("addLast("+random+")", ads.get(1), sad.get(1));
		System.out.println("addLast("+random+")");
		
		int actual = ads.removeFirst();
		int expected = ads.removeFirst();
		assertEquals("removeFirst()", actual, expected);
		System.out.println("removeFirst()");
		
		actual = ads.removeLast();
		expected = sad.removeLast();
		assertEquals("removeLast()", actual, expected);
		System.out.println("removeLast()");
	}
}
