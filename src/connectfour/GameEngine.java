package connectfour;

public class GameEngine {
	private char[][] boardState = new char[6][7];
	final private char EMPTY_SPOT = '_';
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
	
	/**
	 * Default constructor
	 */
	public GameEngine() {
		this.playerTurn = 0;
		this.playerWinner = -1;
		this.totalPlays = 0;
		this.rules = "The objective is to connect 4 of your pieces vertically, horizontally, or diagonally on the game board.\nPress x to quit during the game.\n"
				   + "Enter a number from 1 through 7 to drop a piece.\nPress f to forfeit the game.\nPress r to display these rules during the game.\n\n";
		this.initializeBoard();
	}
	
	/**
	 * Initialize the board with the EMPTY_SPOT character.
	 */
	private void initializeBoard() {
		for (int i = 0; i < this.boardState.length; i+=1) {
			for (int j = 0; j < this.boardState[i].length; j+=1) {
				this.boardState[i][j] = this.EMPTY_SPOT;
			}
		}
	}
	
	/**
	 * Place a piece in the selected column
	 * @param colNum The column number to drop the piece in: must be 0 through 6.
	 * @param playerPiece Character representing player's piece
	 * @return False if the column is full, true if the piece was placed successfully
	 */
	public boolean placePiece(int colNum, char playerPiece) {
		if ( this.boardState[0][colNum] == this.EMPTY_SPOT ) {
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
	 * 
	 * @return True if the board has no more moves available, false if an open spot exists.
	 */
	public boolean checkBoardFull() {
		
		boolean boardIsFull = true;
		for ( int col = 0; col < this.boardState[0].length; col += 1 ) {
			if (this.boardState[0][col] == this.EMPTY_SPOT) {
				boardIsFull = false;
			}
		}
		return boardIsFull;
	}
	
	/**
	 * Displays the game board in its current state.
	 */
	public void showBoard() {
		//String builder for outputting the board
		StringBuilder board = new StringBuilder();
		
		//Create the first line, showing column numbers
		for (int i = 0; i < this.boardState[0].length; i += 1) {
			board.append(" " + (i + 1) + " ");
		}
		
		board.append("\n");
		
		//Create the next line, which is just the "top" pieces of the board
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
	
	/**
	 * Method to check whether the given player's piece satisfies a win condition.
	 * @param piece Player piece to check win condition
	 * @return True if the player's piece meets winning conditions, false otherwise
	 */
	public boolean checkWinner(char piece) {
		boolean result;
		// check column
		if (checkColumn(piece))
			result=true;
		else if (checkRow(piece))
			result=true;
		else if (checkDiagonal(piece))
			result = true;
		else
			result=false;
		
		return result;
		
	}
	
	public void showWinner(String playerName) {
		System.out.println(playerName + " is the winner!!\n");
	}
	
	public void endGame(String playerName) {
		System.out.println(playerName + " has forfeited.");
	}
	
	public void startNewGame() {
		this.initializeBoard();
		this.playerTurn = 0;
		this.playerWinner = -1;
	}
	
	public void displayMenu() {
		System.out.println("1 - New Single Player Game");
		System.out.println("2 - New Two Player Game");
		System.out.println("3 - View Rules");
		System.out.println("4 - Exit Game");
		System.out.print("Select an option: ");
	}
	
	private boolean checkColumn(char piece) {
		boolean result;
		int inARow=0;
		// Check each column for 4 of the specified character in a row
		int col=0;
		while (inARow < 4 && col<boardState[0].length){
			int row=0;
			while (inARow < 4 && row < boardState.length){
				if (boardState[row][col] == piece){
					inARow++;
				}
				else if (boardState[row][col] != piece){
					inARow=0;
				}
				row++;
			}
			col++;
		}
		if (inARow == 4)
			result = true;
		else
			result = false;
		return result;
	}
	
	private boolean checkRow(char piece) {
		boolean result;
		int inARow=0;
		// Check each row for 4 of the specified character in a row
		int row=0;
		while (inARow<4 && row<boardState.length){
			int col=0;
			while (inARow < 4 && col < boardState[row].length){
				if (boardState[row][col] == piece){
					inARow++;
				}
				else if (boardState[row][col] != piece){
					inARow=0;
				}
				col++;
			}
			row++;
		}
		if (inARow == 4)
			result = true;
		else
			result = false;
		return result;
		
	}
	
	private boolean checkDiagonal(char piece) {
		boolean result;
		int inARow=0;
		int row,col;
		// there are only 12 possible diagonals that could contain at least
		// 4 in a row. First check the 6 that start on the bottom left and
		// move up and right.
		// List the possible start locations by row, column pair.
		int[][] firstStarts = new int[][]{{3,0},{4,0},{5,0},{5,1},{5,2},{5,3}};
		int i=0;
		while (inARow <4 && i<firstStarts.length){ // Stop if we find 4 in a row.
			row = firstStarts[i][0];
			col = firstStarts[i][1];
			//System.out.printf("Checking row: %d and col: %d\n", row,col);
			while (inARow <4 && row >= 0 && col < boardState[0].length){
				//System.out.println("Current piece is: "+boardState[row][col]);
				if (boardState[row][col] == piece){
					inARow++;
				}
				else if (boardState[row][col] != piece){
					inARow=0;
				}
				// move right and up
				//System.out.println("in a row: " + inARow);
				col++; row--;
			}
			i++;
		}		
		if (inARow == 4)
			result = true;
		else{
			// Check start on bottom right possible starts and move up and left
			// List possible start locations by row, column pair.
			int[][] secondStarts = new int[][]{{3,6},{4,6},{5,6},{5,5},{5,4},{5,3}};
			i=0;
			while (inARow <4 && i<secondStarts.length){ // Stop if we find 4 in a row
				row = secondStarts[i][0];
				col = secondStarts[i][1];
				while (inARow <4 && row >=0 && col >=0){
					if (boardState[row][col] == piece){
						inARow++;
					}
					else if (boardState[row][col] != piece){
						inARow=0;
					}
					// move left and up
					col--; row--;
				}
				i++;
			}	
		}
		if (inARow == 4)
			result = true;
		else
			result = false;
		return result;
	}
}
