package connectfour;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class GameEngineTests {

	GameEngine testEngine;
	
	@Before
	public void setUp() {
		testEngine = new GameEngine();
	}
	
	@Test
	public void ensuresGameEngineIsInitialzied() {
		assertEquals("player winner is not set on a new GameEngine", -1, testEngine.getPlayerWinner());
	}
	
	@Test
	public void gameEngineBoardStateIsBlank() {
		char[][] board = testEngine.getBoardState();
		testEngine.showBoard();
		for (char[] row : board) {
			for (char col : row) {
				assertEquals("board is not initialized with underscore", '_', col);
			}
		}
	}
}