package hw4;
import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Cell;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Main {

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

	        // Create a new Game with a 5x5 grid
	        Game game = new Game(4);
	        Grid grid = game.getGrid();

	        // Place the player at the bottom-right corner
	        Row startingRow = grid.getRows().get(3);
	        Cell startingCell = startingRow.getCells().get(3);
	        Player player = new Player(startingRow, startingCell);

	        System.out.println("Welcome to the Maze Game!");
	        System.out.println("You are trying to escape through the EXIT on the left side of the grid.");

	        boolean gameRunning = true;

	        while (gameRunning) {
	            System.out.println("\nCurrent Position: ");
	            grid.printGrid(player,grid);
	            System.out.println("Enter move (UP, DOWN, LEFT, RIGHT): ");

	            String input = scanner.nextLine().trim().toUpperCase();

	            try {
	                Movement move = Movement.valueOf(input);
	                boolean moved = game.play(move, player);

	                if (!moved) {
	                    System.out.println("You can't move in that direction!");
	                } else if (player.getCurrentCell().getLeft() == hw4.maze.CellComponents.EXIT) {
	                    System.out.println("🎉 You escaped the maze! Game over.");
	                    gameRunning = false;
	                }

	            } catch (IllegalArgumentException e) {
	                System.out.println("Invalid input. Please enter UP, DOWN, LEFT, or RIGHT.");
	            }
	        }

	        scanner.close();
			}

}
