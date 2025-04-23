package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

public class Player {

	Row currentRow;
	Cell currentCell;
	
	public Player(Row row, Cell cell){
		this.currentRow = row;
		this.currentCell = cell;
	}

	public Row getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	public Cell getCurrentCell() {
		return currentCell;
	}

	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	@Override
	public String toString() {
		return "Player [currentRow=" + currentRow + ", currentCell=" + currentCell + "]";
	}
}
