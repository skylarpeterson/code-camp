//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.
package assign1;

public class TetrisGrid {
	
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for(int row = 0; row < grid[0].length; row++){
			while(isFull(row)){
				for(int col = 0; col < grid.length; col++){
					if(row == grid[0].length - 1) grid[col][row] = false;
					else grid[col][row] = grid[col][row + 1];
				}
				shiftRows(row);
			}
		}
	}
	
	private boolean isFull(int r){
		for(int c = 0; c < grid.length; c++){
			if(!grid[c][r]) return false;
		}
		return true;
	}
	
	private void shiftRows(int startRow){
		if(startRow == grid[0].length - 1) return;
		for(int r = startRow; r < grid[0].length; r++){
			for(int c = 0; c < grid.length; c++){
				if(r == grid[0].length - 1) grid[c][r] = false;
				else grid[c][r] = grid[c][r + 1];
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
