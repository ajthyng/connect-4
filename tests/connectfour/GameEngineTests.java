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
		for (char[] row : board) {
			for (char col : row) {
				assertEquals("board is not initialized with underscore", '_', col);
			}
		}
	}
	
	@Test
	public void gameEngineBoardStateIsDrawn() {
		testEngine.showBoard();
		testEngine.placePiece(0, 'X');
		testEngine.placePiece(2, 'Y');
		testEngine.placePiece(2, 'Y');
		testEngine.placePiece(2, 'X');
		testEngine.placePiece(5, 'X');
		testEngine.placePiece(5, 'X');
		testEngine.placePiece(3, 'X');
		testEngine.placePiece(3, 'Y');
		testEngine.placePiece(3, 'Y');
		testEngine.placePiece(3, 'X');
		testEngine.placePiece(5, 'X');
		testEngine.placePiece(1, 'X');
		testEngine.placePiece(1, 'X');
		testEngine.placePiece(4, 'X');
		testEngine.showBoard();
		System.out.println(testEngine.checkColumn('X'));
		System.out.println(testEngine.checkRow('X'));
		System.out.println(testEngine.checkDiagonal('X'));
		System.out.println(testEngine.checkWinner('X'));
	}
}
