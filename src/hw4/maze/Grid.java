package hw4.maze;

import java.util.ArrayList;
//import hw4.maze.CellComponents;

import hw4.player.Player;

public class Grid {

	ArrayList<Row> rows = new ArrayList<>();
	/**
	 * constructor for Grid that creates an array of rows
	 * @param rows
	 */
	public Grid(ArrayList<Row> rows) {
		this.rows = rows;
	}
	public ArrayList<Row> getRows() {
		return rows;
	}
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}
	public void printGrid(Player player, Grid grid) {
		for(int i = 0; i < rows.size() ; i++) {//rows
			for(int j = 0; j < rows.get(i).getCells().size(); j++) {//cells
				Player current = new Player(grid.getRows().get(i), grid.getRows().get(i).getCells().get(j));
				//check left
				if(current.getCurrentCell().getLeft() == CellComponents.EXIT) {
					System.out.print("  E  ");
				}
				else if(current.getCurrentRow().equals(player.getCurrentRow()) && current.getCurrentCell().equals(player.getCurrentCell())) {
					System.out.print("  P  ");
				}
				else {
					System.out.print("  A  ");
				}
			
				
			}
			System.out.println("\n");
		}
	}
	
}
