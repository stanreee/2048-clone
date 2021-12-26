package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGame {

	private Game game1, game2;
	private final static Board board1 = new Board();
	private final static Board board2 = new Board();

	@Before
	public void setUp() {
		game1 = new Game();
		game1.setBoard(board1);
		game2 = new Game();
		game2.setBoard(board2);
	}

	@Test
	public void testEndGame() {
		game1.endGame(true);
		game2.endGame(false);
		assertTrue(game1.hasWon());
		assertFalse(game2.hasWon());
	}

	@Test (expected=RuntimeException.class)
	public void testHasWonException() {
		game1.hasWon();
		game2.hasWon();
	}

	@After
	public void tearDown() {
		game1 = null;
		game2 = null;
	}
}