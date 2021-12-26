package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestTile {

	private Tile tile1, tile2, tile3;

	@Before
	public void setUp() {
		tile1 = new Tile(new Position(1, 2), 2);
		tile2 = new Tile(new Position(3, 0), 4);
		tile3 = new Tile(new Position(0, 0), 8);
	}

	@Test
	public void testEquals() {
		assertTrue(tile1.equals(new Tile(new Position(2, 3), 2)));
		assertFalse(tile1.equals(tile2));
	}

	@Test
	public void testCombine() {
		tile1.combine(tile1);
		assertEquals(tile1.getValue(), 4);
		tile2.combine(tile3);
		assertEquals(tile2.getValue(), 4);
	}

	@After
	public void tearDown() {
		tile1 = null;
		tile2 = null;
		tile3 = null;
	}
}