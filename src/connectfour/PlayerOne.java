package connectfour;

public class PlayerOne extends Player {
	public PlayerOne(int num, String name, char piece) {
		super(num, name, piece);
	}
	public boolean requestExit(GameEngine game) {		
		this.forfeit();
//		boolean result;
//		result = game.endGame();
		return false;
	}
}
