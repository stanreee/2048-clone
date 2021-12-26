package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestPosition {

	private Position position1, position2, position3;

	@Before
	public void setUp() {
		position1 = new Position(1, 3);
		position2 = new Position(2, 4);
		position3 = new Position(-2, 1);
	}

	@Test
	public void testInvariantAssurance() {
		assertEquals(position2.getY(), 3);
		assertEquals(position3.getX(), 0);
	}

	@Test
	public void testAdd() {
		position1.addX(4);
		assertEquals(position1.getX(), 3);
		position2.addY(-1);
		assertEquals(position2.getY(), 2);
	}

	@Test
	public void testEquals() {
		assertFalse(position1.equals(position2));
		assertTrue(position1.equals(new Position(1, 3)));
	}

	@After
	public void tearDown() {
		position1 = null;
		position2 = null;
		position3 = null;
	}
}