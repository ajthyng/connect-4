package connectfour;

import java.util.Scanner;

public class GameLoop {
	public static void main (String[] args) {
		//GameEngine used to play connect four
		GameEngine connectFour = new GameEngine();
		Scanner scan = new Scanner(System.in);
		
		//Possible additional players that could play
		AI cpu;
		Player pTwo;
		
		//The option the user has selected from the menu
		int option;
		
		//Initial setup outside game loop
		System.out.print("Please enter your name: ");
		String pOneName = scan.next();
		PlayerOne pOne = new PlayerOne(1, pOneName, '1');
		System.out.print("Welcome to Connect 4, " + pOne.getPlayerName() + "\n");

		//Game loop
		do {
			//Show the menu to the user
			connectFour.displayMenu();
			
			//Retrieve the user's menu selection
			option = getOption(scan);
			
			//Display rules if they have selected to display the rules.
			if (option == 3) {
				System.out.print(connectFour.getRules());
			}
			
			//Selected single player - make a CPU opponent and initiate a game
			if (option == 1) {
				cpu = new AI('C');
				connectFour.startNewGame();
				connectFour.setPlayerTurn(pOne.getPlayerNum());
				System.out.println("Playing against AI opponent.");
				playSinglePlayerGame(pOne, cpu, scan, connectFour);
			}
			
			//Selected two player, get the second player's name and start a game
			if (option == 2) {
				System.out.print("Please enter Player 2's name: ");
				pTwo = new Player (2, scan.next(), '2');
				connectFour.startNewGame();
				connectFour.setPlayerTurn(pOne.getPlayerNum());
				playTwoPlayerGame(pOne, pTwo, scan, connectFour);
			
			}
		} while(option != 4); //Exit if they select so from the menu. 
		System.out.println("Goodbye.");
		System.exit(0);
				
	}
	
	/**
	 * This method is called in order to play a two player game.
	 * @param pOne Player One - Human
	 * @param pTwo Player Two - Human
	 * @param scan Scanner object using System.in
	 * @param connectFour GameEngine to track game status
	 */
	public static void playTwoPlayerGame(Player pOne, Player pTwo, Scanner scan, GameEngine connectFour) {
		//Are the players still playing?
		boolean stillPlaying = true;
		
		
		while (stillPlaying) {
			//Make sure the board isn't full--if it is quit, and it must be a draw
			if (connectFour.checkBoardFull()) {
				stillPlaying = false;
				System.out.print("No more moves left, it's a draw!");
			}
			//Detect if the players are still playing and who's turn it is, then take that turn
			if (connectFour.getPlayerTurn() == 1 && stillPlaying) {
				stillPlaying = takeHumanTurn(pOne, pTwo, connectFour, scan);
			}
			if (connectFour.getPlayerTurn() == 2 && stillPlaying) {
				stillPlaying = takeHumanTurn(pTwo, pOne, connectFour, scan);
			}
		}
	}
	
	/**
	 * This method is called in order to play a single player game against a basic AI opponent
	 * @param pOne Player One - Human
	 * @param cpu Player Two - AI
	 * @param scan Scanner object using System.in
	 * @param connectFour GameEngine to track game status
	 */
	public static void playSinglePlayerGame(Player pOne, AI cpu, Scanner scan, GameEngine connectFour) {
		boolean stillPlaying = true;
		
		while (stillPlaying) {
			//Make sure the board isn't full--if it is quit, and it must be a draw
			if (connectFour.checkBoardFull()) {
				stillPlaying = false;
				System.out.print("No more moves left, it's a draw!");
			}
			//Detect if the players are still playing and who's turn it is, then take that turn
			if (connectFour.getPlayerTurn() == 1 && stillPlaying) {
				stillPlaying = takeHumanTurn(pOne, cpu, connectFour, scan);
			}
			if (connectFour.getPlayerTurn() == 2 && stillPlaying) {
				stillPlaying = takeCpuTurn(cpu, pOne, connectFour, scan);
			}
		}
	}
	
	/**
	 * Allow a human player to take their turn
	 * @param currentPlayer Current human player taking a turn
	 * @param opponent Opponent, either AI or Human
	 * @param connectFour GameEngine tracking the status of the game
	 * @param scan Scanner object using System.in
	 * @return True if the game is still being played, false if the game is over.
	 */
	public static boolean takeHumanTurn(Player currentPlayer, Player opponent, GameEngine connectFour, Scanner scan) {
		//Show the board for the human player
		connectFour.showBoard();
		
		//Assume we are still playing be default
		boolean stillPlaying = true;
		
		//Initial selection of a column
		System.out.print(currentPlayer.getPlayerName() + ", select a column (1-7): ");
		int playerInput = getColumn(scan);
		
		//If the column is in the valid range, attempt to place a piece there
		if (playerInput > 0 && playerInput < 8) {
			
			//Make the player select a column with an empty spot 
			while (!currentPlayer.placePiece(connectFour, playerInput - 1)) {
				System.out.print("Column is full, select another: ");
				playerInput = getColumn(scan);
			}
			//Check win condition
			if (connectFour.checkWinner(currentPlayer.getPieceType())) {
				connectFour.showBoard();
				connectFour.setTotalPlays(connectFour.getTotalPlays() + 1);
				connectFour.showWinner(currentPlayer.getPlayerName());
				stillPlaying = false;
			}
			//Opponent goes next
			connectFour.setPlayerTurn(opponent.getPlayerNum());
		}
		
		//Special options, 0 is exit, -1 is forfeit, and -2 is showing the rules again
		if (playerInput == 0) {
			connectFour.setTotalPlays(connectFour.getTotalPlays() + 1);
			connectFour.showWinner(opponent.getPlayerName());
			stillPlaying = false;
		}
		if (playerInput == -1) {
			connectFour.setTotalPlays(connectFour.getTotalPlays() + 1);
			connectFour.showWinner(opponent.getPlayerName());
			stillPlaying = false;
		}
		if (playerInput == -2) {
			//Same player goes again if they just wanted to see the rules.
			System.out.print(connectFour.getRules());
			connectFour.setPlayerTurn(currentPlayer.getPlayerNum());
		}
		return stillPlaying;
	}
	
	/**
	 * This function will allow the CPU to take its turn. 
	 * @param cpu AI the game is being played against
	 * @param opponent Human opponent
	 * @param connectFour GameEngine currently tracking game progress
	 * @param scan Scanner object using System.in
	 * @return True if the players are still playing, False if the game has ended on a win condition.
	 */
	public static boolean takeCpuTurn(AI cpu, Player opponent, GameEngine connectFour, Scanner scan) {
		boolean stillPlaying = true;
		cpu.placePiece(connectFour);

		//Check if the CPU won the game.
		if (connectFour.checkWinner(cpu.getPieceType())) {
			connectFour.showBoard();
			connectFour.setTotalPlays(connectFour.getTotalPlays() + 1);
			connectFour.showWinner(cpu.getPlayerName());
			stillPlaying = false;
		}
		
		//Human goes next
		connectFour.setPlayerTurn(opponent.getPlayerNum());

		return stillPlaying;
	}
	
	/**
	 * Gets validated user input to select one of 4 menu options.
	 * @param scan Scanner object using System.in
	 * @return The option the user has selected, between 1 and 4 inclusive
	 */
	public static int getOption(Scanner scan) {
		while (!scan.hasNextInt()) {
			System.out.print("Please enter an option between 1 and 4: ");
			scan.next();
		}
		int option = scan.nextInt();
		while (option > 4 || option < 1) {
			System.out.print("Please enter an option between 1 and 4: ");
			option = getOption(scan);
		}
		return option;
	}
	
	/**
	 * This function will get user input and allow it to be either 1 through 7,'x', 'f', or 'r'
	 * 
	 * @param scan Scanner object using System.in
	 * @return Column the user has selected, between 1 and 7 inclusive
	 */
	public static int getColumn(Scanner scan) {
		while (!scan.hasNextInt()) {
			String input = scan.next();
			//Checks for special inputs
			//x = exit
			//f = forfeit
			//r = show rules
			if (input.toLowerCase().equals("x")) {
				return 0;
			}
			if (input.toLowerCase().equals("f")) {
				return -1; 
			}
			if (input.toLowerCase().equals("r")) {
				return -2;
			}
			System.out.print("Please enter a column between 1 and 7: ");
		}
		int column = scan.nextInt();
		while (column > 7 || column < 1) {
			System.out.print("Please enter a column between 1 and 7: ");
			column = getColumn(scan);
		}
		return column;
	}
}
