package hw4.maze;

public class Cell {
	
	boolean isExit = false;
	CellComponents up;
	CellComponents down;
	CellComponents left;
	CellComponents right;
	
	/**
	 * Cell constructor that assigns the left, right, top and bottom of the cell
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down){
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public CellComponents getUp() {
		return up;
	}

	public void setUp(CellComponents up) {
		this.up = up;
	}

	public CellComponents getDown() {
		return down;
	}

	public void setDown(CellComponents down) {
		this.down = down;
	}

	public CellComponents getLeft() {
		return left;
	}

	public void setLeft(CellComponents left) {
		this.left = left;
	}

	public CellComponents getRight() {
		return right;
	}

	public void setRight(CellComponents right) {
		this.right = right;
	}
}
