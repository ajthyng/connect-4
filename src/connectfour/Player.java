package connectfour;

/**
 * provides a player for connect4
 */
public class Player {
	protected char pieceType;
	protected String playerName;
	protected int playerNum;
	protected boolean playing;
	
	/**
	 * Default constructor
	 */
	public Player() {
		this.playerName = "Unnamed";
		this.pieceType = '*';
		this.playerNum = 0;
		this.playing = true;
	}
	
	/**
	 * 
	 * @param num Player Number, 1 or 2
	 * @param name Player's name
	 * @param piece Player's piece representation
	 */
	public Player(int num, String name, char piece) {
		this.playerNum = num;
		this.playerName = name;
		this.pieceType = piece;
		this.playing = true;
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

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	
	public void forfeit() {
		this.playing=false;
	}
	
	public boolean isPlaying() {
		return this.playing;
	}

	/**
	 * 
	 * @param game GameEngine the player is currently using
	 * @param colNumber Column the player would like to place a piece in
	 * @return
	 */
	public boolean placePiece (GameEngine game, int colNumber) {
		boolean result;
		result = game.placePiece(colNumber, this.pieceType);
		return result;
	}
}
