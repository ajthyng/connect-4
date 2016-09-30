package connectfour;

import java.util.*;

/**
 * provides a player for connect4
 */
public class Player {
	protected char pieceType;
	protected String playerName;
	protected int playerNum;
	protected boolean playing;
	protected Stack<Integer> history = new Stack<Integer>();
	
	
	public Player() {
		this.playerName = "Unnamed";
		this.pieceType = '*';
		this.playerNum = 0;
		this.playing = true;
	}
	
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
	
	public boolean placePiece (GameEngine game, int colNumber) {
		history.add(colNumber);
		boolean result;
		result = game.placePiece(colNumber, pieceType);
		return result;
	}
	
	//public void undoLastMove(){
	//	history.pop();
	//}
}
