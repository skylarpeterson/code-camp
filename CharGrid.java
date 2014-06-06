// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

package assign1;

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		
		int firstRow = -1;
		int lastRow = -1;
		int firstCol = -1;
		int lastCol = -1;
		
		for(int i = 0; i < grid.length; i++){
			for(int n = 0; n < grid[i].length; n++) {
				if(grid[i][n] == ch) {
					if(firstRow < 0) firstRow = i;
					if(i > lastRow) lastRow = i;
					
					if(firstCol < 0 || n < firstCol) firstCol = n;
					if(n > lastCol) lastCol = n;
				}
			}
		}
		if(firstRow < 0) return 0;
		return (lastRow - firstRow + 1)*(lastCol - firstCol + 1); // TODO ADD YOUR CODE HERE
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int plusCount = 0;
		for(int i = 1; i < grid.length - 1; i++){
			for(int n = 1; n < grid[i].length - 1; n++){
				if(isPlus(i, n)) plusCount++;
			}
		}
		return plusCount;
	}
	
	/**
	 * Returns true if and only if the characters above, below,
	 * to the right of, and to the left of the given indices are the
	 * same character, thus forming a '+' shape in the grid.
	 * @param two coordinate points on grid
	 * @return if coordinate in grid is a +
	 */
	private boolean isPlus(int i, int n){
		char ch = grid[i][n];
		
		if(grid[i - 1][n] != ch) return false;
		else if(grid[i][n + 1] != ch) return false;
		else if(grid[i + 1][n] != ch) return false;
		else if(grid[i][n -1 ] != ch) return false;
		
		return true;
	}
}
