package connectfour;

public class PlayerOne extends Player {
	public boolean requestExit(GameEngine game) {
		this.forfeit();
		boolean result;
		result= game.endGame();
		return result;
	}
}
