package hw4.game;

import java.util.ArrayList;
import java.util.Random;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	Grid grid;
	public static final int MAXIMUM = 7;
	public static final int MINIMUM = 3;
	/**
	 * this creates a random grid with the assigned parameter
	 * uses the grid to assign to the game
	 * @param x
	 */
	public Game (int x) {
		if(x <= MAXIMUM && x >= MINIMUM) {
			this.grid = createRandomGrid(x);
		}else {
			this.grid = null;
		}
	}
	/**
	 * getter for the grid that was generated
	 * @return
	 */
	public Grid getGrid() {
		return grid;
	}
	
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	/**
	 * assigns the game with a predetermined grid
	 * @param grid
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}
	/**
	 * plays the game and handles user input
	 * @param move
	 * @param player
	 * @return
	 */
	public boolean play(Movement move, Player player) {
		if(move == null| player == null| grid == null) {
			System.out.println("Either move player or grid are null");
			return false;
		}
		int currentRow = grid.getRows().indexOf(player.getCurrentRow());
		int currentCell = player.getCurrentRow().getCells().indexOf(player.getCurrentCell());
		if(currentRow == -1| currentCell == -1) {
			System.out.println("improper row on grid");
			return false;
		}
		switch(move) {
		case UP:
			//check for surroundings
			if((currentRow > 0) && (player.getCurrentCell().getUp()!= CellComponents.WALL) && (grid.getRows().get(currentRow - 1).getCells().get(currentCell).getDown()== CellComponents.APERTURE)) {
				//Note: change index of actual player not just the saved current row, next loop will forget and look to the player again
				player.setCurrentRow(grid.getRows().get(currentRow - 1));
				//PAST ERROR: you do need to change the cell because it will have new surroundings, not just a 
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCell));
				return true;
			}
			break;
		case DOWN:
			//check for surroundings
			if((currentRow < grid.getRows().size() - 1) && (player.getCurrentCell().getDown()!= CellComponents.WALL) && (grid.getRows().get(currentRow + 1).getCells().get(currentCell).getUp()== CellComponents.APERTURE)) {
				player.setCurrentRow(grid.getRows().get(currentRow + 1));
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCell));
				return true;
			}
			break;
		case LEFT:
			if((currentCell > 0) && (player.getCurrentCell().getLeft() == CellComponents.APERTURE) && (player.getCurrentRow().getCells().get(currentCell - 1).getRight() == CellComponents.APERTURE)) {
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCell - 1));
				return true;
			}
			if(player.getCurrentCell().getLeft() == CellComponents.EXIT) {
				System.out.println("You escaped the maze");
				return true;
			}
			break;
		case RIGHT:
			if((currentCell < player.getCurrentRow().getCells().size() - 1) && (player.getCurrentCell().getRight() != CellComponents.WALL) && (player.getCurrentRow().getCells().get(currentCell + 1).getLeft() == CellComponents.APERTURE)) {
				player.setCurrentCell(player.getCurrentRow().getCells().get(currentCell + 1));
				return true;
			}
			break;
		}
		
		return false;
	}
	/**
	 * creates random grid 
	 * @param x
	 * @return
	 */
	public Grid createRandomGrid(int x) {
		if(x < MINIMUM || x > MAXIMUM) {
			return null;
		}
		Random rand = new Random();
		int randomRow = rand.nextInt(x);
		System.out.println("RandomRow is:"+ randomRow);
		ArrayList<Row> rows = new ArrayList<>();
		
		for (int i = 0; i < x; i++) {
			ArrayList<Cell> cells = new ArrayList<>();
			for(int j = 0; j < x; j++) {
				CellComponents left;
				CellComponents right;
				CellComponents up;
				CellComponents down;


				if(j == 0) {//if the cell is on the left most wall
					if(i == randomRow) {
						left = CellComponents.EXIT;
						System.out.println("placed exit"+ i +","+j);
					}else {
					left = CellComponents.WALL;
					}
				}else {
					left = randomComponent();
				}
				
				if(j == (x - 1)) {//if the cell is on the right most wall
					right = CellComponents.WALL;
				}else {
					right = randomComponent();
				}
				
				if(i == 0) {
					up = CellComponents.WALL;
				}else {
					up = randomComponent();
				}
				
				if(i == (x - 1)) {
					down = CellComponents.WALL;
				}else {
					down = randomComponent();
				}

				cells.add(new Cell(left, right, up, down));
			}
			rows.add(new Row(cells));
			
		}
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < x; j++) {
				Cell current = rows.get(i).getCells().get(j);
				
				//check left and right
				if(j < (x - 1)) {
					Cell rightSide = rows.get(i).getCells().get(j+1);
					current.setRight(rightSide.getLeft());
				}
				
				//check top and bottom
				if(i < (x - 1)) {
					Cell bottom = rows.get(i + 1).getCells().get(j);
					current.setDown(bottom.getUp());
				}
			}
		}
		
		
		return new Grid(rows);
	}
	CellComponents randomComponent() {
		return Math.random() < 0.5 ? CellComponents.WALL : CellComponents.APERTURE;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
}
