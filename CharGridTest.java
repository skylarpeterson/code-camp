// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	// charArea tests
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
		assertEquals(1, cg.charArea('x'));
		assertEquals(0, cg.charArea('h'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
	}
	
	// countPlus tests
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char [][] {
				{' ', 'a', ' '},
				{'a', 'a', 'a'},
				{' ', 'a', ' '}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid = new char [][] {
				{' ', 'a', ' ', ' '},
				{'a', 'a', 'a', ' '},
				{' ', 'a', 'a', 'a'},
				{' ', ' ', 'a', ' '}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(2, cg.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid = new char [][] {
				{' ', 'a', 'a', ' '},
				{'a', 'a', ' ', ' '},
				{' ', 'a', 'a', 'a'},
				{' ', ' ', 'a', ' '}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		char[][] grid = new char [][] {
				{' ', 'a', ' ', ' '},
				{'a', 'a', 'b', ' '},
				{' ', 'a', 'a', 'a'},
				{' ', ' ', 'a', ' '}
		};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(0, cg.countPlus());
	}
	
}
