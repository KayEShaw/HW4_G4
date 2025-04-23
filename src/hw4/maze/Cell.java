package hw4.maze;

public class Cell {
	
	CellComponents up;
	CellComponents down;
	CellComponents left;
	CellComponents right;
	
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
