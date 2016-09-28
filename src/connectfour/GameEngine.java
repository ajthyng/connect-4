package connectfour;

public class GameEngine {
	private char[][] boardState = new char[6][7];
	private char emptySpot = '_';
	private String rules;
	private int playerTurn;
	private int playerWinner;
	private int totalPlays;
	
	public String getRules() {
		return rules;
	}


	public int getPlayerTurn() {
		return playerTurn;
	}


	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	
	public int getPlayerWinner() {
		return playerWinner;
	}


	public void setPlayerWinner(int playerWinner) {
		this.playerWinner = playerWinner;
	}


	public int getTotalPlays() {
		return totalPlays;
	}


	public void setTotalPlays(int totalPlays) {
		this.totalPlays = totalPlays;
	}

	public char[][] getBoardState() {
		return this.boardState;
	}
	
	public GameEngine() {
		this.playerTurn = 0;
		this.playerWinner = -1;
		this.totalPlays = 0;
		this.rules = "Press x to quit at any time.\nEnter a number from 0 through 7 to drop a piece.\nPress f to forfeit the game.\nPress r to display these rules at any time.";
		for (int i = 0; i < this.boardState.length; i+=1) {
			for (int j = 0; j < this.boardState[i].length; j+=1) {
				this.boardState[i][j] = this.emptySpot;
			}
		}
	}
	
	
	public boolean placePiece(int colNum, char playerPiece) {
		if ( this.boardState[0][colNum] == this.emptySpot ) {
			//We can place a piece
			
			//Loop through rows starting at 1, since we verified row 0 empty in the initial if statement
			//We're looking for the first empty spot the piece goes in now
			for ( int row = 1; row < this.boardState.length; row += 1 ) {
				//Check for occupied spots, place piece in row above occupied row
				if ( this.boardState[row][colNum] != '_') {
					this.boardState[row-1][colNum] = playerPiece;
					return true;
				} else if (row == 5) {
					//If we're on the last row and it's still empty, put the piece there.
					this.boardState[row][colNum] = playerPiece;
				}
				

			}
			
			return true;

		} else {
			//We cannot place a piece in this column at all.
			return false;
		}
	}
	
	/**
	 * Displays the game board in its current state.
	 */
	public void showBoard() {
		//String builder for outputting the board
		StringBuilder board = new StringBuilder();
		
		//Create the first line, which is just the "top" pieces of the board
		for (int i = 0; i < this.boardState[0].length; i += 1) {
			board.append(" _ ");
		}
		//Go to the next line
		board.append("\n");
		
		//Write boxes to the console for every value stored in boardState
		for (char[] row : this.boardState) {
			for (char col : row) {
				board.append("|" + col + "|");
			}
			board.append("\n");
		}
		
		//Display actual board
		System.out.print(board);
	}
	
	public void checkWinner() {
		
	}
	
	public void showWinner() {
		
	}
	
	public void endGame() {
		
	}
	
	public void startNewGame() {
		
	}
	
	public void displayMenu() {
		
	}
	
	public void checkColumn() {
		
	}
	
	public void checkRow() {
		
	}
	
	public void checkDiagonal() {
		
	}
}
