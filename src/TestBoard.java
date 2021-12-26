package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestBoard {

	private Board board1, board2;
	private static Tile tile1, tile2, tile3, tile4;

	@Before
	public void setUp() {
		tile1 = new Tile(new Position(0, 2), 2);
		tile2 = new Tile(new Position(3, 2), 4);
		tile3 = new Tile(new Position(1, 2), 1024);
		tile4 = new Tile(new Position(1, 3), 1024);

		board1 = new Board();
		board1.clearBoard();
		board1.placeTile(tile1);
		board1.placeTile(tile2);
		board2 = new Board();
		board2.clearBoard();
		board2.placeTile(tile3);
		board2.placeTile(tile4);
	}

	@Test
	public void testMoveTile() {
		board1.moveTile(tile1, new Position(1, 2));
		assertTrue(board1.getTile(new Position(0, 2)) == null);
		assertTrue(board1.getTile(new Position(1, 2)).equals(tile1));
	}

	@Test
	public void testMoveTileGivenDirection() {
		board1.moveTileGivenDirection(tile1, Direction.down);
		assertTrue(board1.getTile(new Position(0, 3)).equals(tile1));
		board2.moveTileGivenDirection(tile3, Direction.right);
		assertTrue(board2.getTile(new Position(3, 2)).equals(tile3));
	}

	@Test
	public void testMoveBoard() {
		board1.moveBoard(Direction.right);
		assertTrue(board1.getTile(new Position(3, 2)).equals(tile2));
		assertTrue(board1.getTile(new Position(2, 2)).equals(tile1));
	}

	@Test
	public void testGetPossibleMoves() {
		assertEquals(board1.getPossibleMoves(), 6);
		assertEquals(board2.getPossibleMoves(), 7);
	}

	@After
	public void tearDown() {
		board1 = null;
		board2 = null;
	}
}