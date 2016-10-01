package connectfour;

public class GameEngine {
	private int[][] boardState;
	private String rules;
	private int playerTurn;
	private int playerWinner;
	private int totalPlays;
	
	public boolean placePiece(int column, char piecetype) {
		//placeholder for validation purposes
		checkColumn(column);
		checkDiagonal(column);
		return true;
		
	}
	
	//displays the board. 0's are unused spaces. 1's are pieces from player 1. 2's are pieces from player 2.
	public void showBoard() {
		for(int i = 0; i < boardState.length; i++) {
			for (int j = 0; j < boardstate[i].length; j++) {
				System.out.print(boardstate[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//returns true if there's a winner. returns false if there's not
	public void checkWinner() {
		if(playerWinner == 0) {
			return false;
		}
		return true;
	}
	
	//displays the winner
	public void showWinner() {
		if(playerWinner == 1) {
			System.out.println("Player 1 is the winner");
		} else if(playerWinner == 2) {
			System.out.println("Player 2 is the winner");
		} else {
			System.out.println("There is no winner");
		}
	}
	
	public boolean endGame() {
		//placeholder for validation purposes
		return true;
		
	}
	
	public void startNewGame() {
		
	}
	
	public void displayMenu() {
		
	}
	
	//check the column the piece was inserted
	//if there are 4 pieces from the same player next to each other then set playerWinner to that number
	public void checkColumn(int column) {
		int counter = 1;
		int lastPiece = 0;
		//check each row of the column
		for(int i = 0; i < 6; i++) {
			//if counter == 4, then set playerWinner to lastPiece
			if(counter == 4) {
				playerWinner = lastPiece;
				break;
			}
			//if the current piece is from the same player as the last piece, then increment counter by 1
			if(boardState[i][column] == lastPiece) {
				counter++;
			} else { //if not, then reset counter to 1, and set lastPiece to the player number that placed it 
				counter = 1;
				lastPiece = boardState[i][column];
			}
		}
	}
	
	public void checkRow() {
		
	}
	
	//
	public void checkDiagonal(int column) {
		
	}
}
