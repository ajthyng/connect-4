package connectfour;

public class GameEngine {
	private char[][] boardState = new char[6][7];
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
				this.boardState[i][j] = '_';
			}
		}
	}
	
	
	public void placePiece() {
		
	}
	
	public void showBoard() {
		StringBuilder board = new StringBuilder();
		for (int i = 0; i < this.boardState[0].length; i += 1) {
			board.append(" _ ");
		}
		board.append("\n");
		for (char[] row : this.boardState) {
			for (char col : row) {
				board.append("|" + col + "|");
			}
			board.append("\n");
		}
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
