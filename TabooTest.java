// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TabooTest {

	// basic no follow tests, seeing if rules are read correctly
	@Test
	public void noFollowTest1(){
		List<String> stringList = Arrays.asList("cat", "dog", "hippo", "cat");
		Taboo<String> taboo = new Taboo<String>(stringList);
		assertEquals(1, (taboo.noFollow("cat")).size());
		assertEquals(1, (taboo.noFollow("dog")).size());
		assertEquals(1, (taboo.noFollow("hippo")).size());
		assertEquals(0, (taboo.noFollow("horse")).size());
		
		assertTrue((taboo.noFollow("cat")).contains("dog"));
		assertTrue((taboo.noFollow("dog")).contains("hippo"));
		assertTrue((taboo.noFollow("hippo")).contains("cat"));
		assertFalse((taboo.noFollow("dog")).contains("cat"));
	}
	
	// inclusion of null in rules
	@Test
	public void noFollowTest2(){
		List<String> stringList = Arrays.asList("cat", "dog", null, "hippo", "cat");
		Taboo<String> taboo = new Taboo<String>(stringList);
		assertTrue((taboo.noFollow("cat")).contains("dog"));
		assertTrue((taboo.noFollow("hippo")).contains("cat"));
		assertFalse((taboo.noFollow("dog")).contains("hippo"));
		
		List<String> stringList2 = Arrays.asList("cat", null, "parrot", "dog", null, "hippo", "cat");
		Taboo<String> taboo2 = new Taboo<String>(stringList2);
		assertTrue((taboo2.noFollow("cat")).isEmpty());
		assertTrue((taboo2.noFollow("parrot")).contains("dog"));
		assertTrue((taboo2.noFollow("hippo")).contains("cat"));
		assertFalse((taboo2.noFollow("dog")).contains("hippo"));
	}
	
	// basic reduction example with null in rules, testing strings
	@Test
	public void reduceTest1(){
		List<String> stringList = Arrays.asList("cat", "dog", null, "hippo", "cat");
		Taboo<String> taboo = new Taboo<String>(stringList);
		
		ArrayList<String> before = new ArrayList<String>();
		before.add("cat");
		before.add("dog");
		before.add("hippo");
		before.add("hippo");
		before.add("cat");
		
		ArrayList<String> after = new ArrayList<String>();
		after.add("cat");
		after.add("hippo");
		after.add("hippo");
		
		taboo.reduce(before);
		assertEquals(after, before);
	}
	
	// multiple spread out removals on Integers
	@Test
	public void reduceTest2(){
		List<Integer> stringList = Arrays.asList(1, 3, 5, 7, 9);
		Taboo<Integer> taboo = new Taboo<Integer>(stringList);
		
		ArrayList<Integer> before = new ArrayList<Integer>();
		before.add(1);
		before.add(2);
		before.add(5);
		before.add(7);
		before.add(9);
		before.add(3);
		before.add(5);
		before.add(1);
		before.add(3);
		
		ArrayList<Integer> after = new ArrayList<Integer>();
		after.add(1);
		after.add(2);
		after.add(5);
		after.add(9);
		after.add(3);
		after.add(1);
		
		taboo.reduce(before);
		assertEquals(after, before);
	}
	
	// almost complete removals, null in rules
	@Test
	public void reduceTest3(){
		List<Integer> stringList = Arrays.asList(1, 3, 5, 7, null, 9);
		Taboo<Integer> taboo = new Taboo<Integer>(stringList);
		
		ArrayList<Integer> before = new ArrayList<Integer>();
		before.add(1);
		before.add(3);
		before.add(3);
		before.add(3);
		before.add(3);
		before.add(3);
		before.add(5);
		before.add(7);
		before.add(7);
		
		ArrayList<Integer> after = new ArrayList<Integer>();
		after.add(1);
		after.add(5);
		
		taboo.reduce(before);
		assertEquals(after, before);
	}
}
