 

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
	public void gameEngineDiagonalWinCondition() {
		char playerOnePiece = 'X';
		char playerTwoPiece = 'Y';
		testEngine.placePiece(0, playerOnePiece);
		testEngine.placePiece(2, playerTwoPiece);
		testEngine.placePiece(2, playerTwoPiece);
		testEngine.placePiece(2, playerOnePiece);
		testEngine.placePiece(5, playerOnePiece);
		testEngine.placePiece(5, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(5, playerOnePiece);
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(4, playerOnePiece);
		testEngine.showBoard();
		assertEquals("playerOne did not win with diagonal pieces", true, testEngine.checkWinner(playerOnePiece));
	}
	
	@Test
	public void gameEngineHorizontalWinCondtion() {
		char playerOnePiece = 'X';
		testEngine.placePiece(0, playerOnePiece);
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(2, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.showBoard();
		assertEquals("playerOne did not win with horizontal pieces", true, testEngine.checkWinner(playerOnePiece));
	}
	
	@Test
	public void gameEngineVerticalWinCondition() {
		char playerOnePiece = 'X';
		char playerTwoPiece = 'Y';
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.showBoard();
		assertEquals("playerOne did not win with vertical pieces", true, testEngine.checkWinner(playerOnePiece));
	}
	
	@Test
	public void gameEngineThinksThisIsAWin() {
		char playerOnePiece = '1';
		char playerTwoPiece = 'C';
		testEngine.placePiece(0, playerOnePiece);
		testEngine.placePiece(0, playerOnePiece);
		
		testEngine.placePiece(1, playerTwoPiece);
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(1, playerTwoPiece);
		
		testEngine.placePiece(2, playerTwoPiece);
		testEngine.placePiece(2, playerTwoPiece);
		testEngine.placePiece(2, playerOnePiece);
		testEngine.placePiece(2, playerTwoPiece);
		
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerTwoPiece);
		
		testEngine.placePiece(4, playerOnePiece);
		
		testEngine.placePiece(5, playerTwoPiece);
		testEngine.placePiece(5, playerTwoPiece);
		testEngine.placePiece(5, playerOnePiece);
		
		testEngine.placePiece(6, playerOnePiece);
		testEngine.placePiece(6, playerOnePiece);
		testEngine.placePiece(6, playerOnePiece);
		testEngine.placePiece(6, playerTwoPiece);
		testEngine.placePiece(6, playerOnePiece);
		testEngine.placePiece(6, playerTwoPiece);
		
		testEngine.placePiece(6, playerOnePiece);
		testEngine.showBoard();
		assertEquals("playerOne won and should not have", false, testEngine.checkWinner(playerOnePiece));
				
	}
	@Test
	public void gameEngineVerticalandDiagonalSimultaneously() {
		char playerOnePiece = '9';
		char playerTwoPiece = ')';
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerTwoPiece);
		
		testEngine.placePiece(6, playerTwoPiece);
		testEngine.placePiece(6, playerTwoPiece);
		testEngine.placePiece(6, playerOnePiece);
		
		testEngine.placePiece(5, playerTwoPiece);
		testEngine.placePiece(5, playerTwoPiece);
		testEngine.placePiece(5, playerTwoPiece);
		testEngine.placePiece(5, playerOnePiece);
		
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerOnePiece);
		
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		testEngine.showBoard();
		assertEquals("playerOne achieving diagonal and vertical win conditions at once caused an error", true, testEngine.checkWinner(playerOnePiece));
	}
	@Test
	public void gameEngineHorizontalandDiagonalSimultaneously() {
		char playerOnePiece = '9';
		char playerTwoPiece = ')';
		testEngine.placePiece(3, playerOnePiece);
		testEngine.placePiece(3, playerOnePiece);
		
		testEngine.placePiece(2, playerOnePiece);
		testEngine.placePiece(2, playerTwoPiece);
		testEngine.placePiece(2, playerOnePiece);
		
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(1, playerTwoPiece);
		testEngine.placePiece(1, playerTwoPiece);
		testEngine.placePiece(1, playerOnePiece);
		
		testEngine.placePiece(4, playerOnePiece);
		
		testEngine.showBoard();
		assertEquals("playerOne achieving diagonal and horizontal win conditions at once caused an error", true, testEngine.checkWinner(playerOnePiece));
	}
	@Test
	public void gameEngineHorizontalandVerticalSimultaneously() {
		char playerOnePiece = '9';
		char playerTwoPiece = ')';
		
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(1, playerOnePiece);
		testEngine.placePiece(1, playerTwoPiece);
		testEngine.placePiece(1, playerOnePiece);
		
		
		testEngine.placePiece(2, playerOnePiece);
		testEngine.placePiece(2, playerOnePiece);
     	testEngine.placePiece(2, playerOnePiece);
     	
     	testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerTwoPiece);
		testEngine.placePiece(3, playerOnePiece);
		
		testEngine.placePiece(4, playerOnePiece);
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerTwoPiece);
		testEngine.placePiece(4, playerOnePiece);
     	
		
		testEngine.placePiece(2, playerOnePiece);
		
		testEngine.showBoard();
		assertEquals("playerOne achieving vertical and horizontal win conditions at once caused an error", true, testEngine.checkWinner(playerOnePiece));
	}
}































