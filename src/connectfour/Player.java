package connectfour;

public class Player {
	private char pieceType;
	private String playerName;
	
	public Player() {
		this.playerName = "Unnamed";
		this.pieceType = '*';
	}
	
	public Player(String name, char piece) {
		this.playerName = name;
		this.pieceType = piece;
	}

	public char getPieceType() {
		return pieceType;
	}

	public void setPieceType(char pieceType) {
		this.pieceType = pieceType;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void placePiece (int colNumber) {
		//Implement a method to place a piece in the column the user has selected, should pass column # to GameEngine
	}
	
	public void forfeit() {
		//Implement a method to forfeit the game immediately 
	}
}
