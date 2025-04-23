package hw4.maze;

import java.util.ArrayList;

public class Grid {

	ArrayList<Row> rows = new ArrayList<>();
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	public ArrayList<Row> getRows() {
		return rows;
	}
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	
}
