/**
 * @File: Direction.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Direction module that handles movement based off user input.
 */

package src;

public enum Direction {
	
	// exported types
	left(-1, 0),
	right(1, 0),
	up(0, -1),
	down(0, 1);
	
	// state variables
	private final int y, x;
	
	/**
	 * @brief Constructor for Direction
	 * @param xPos - x component of the Direction vector
	 * @param yPos - y component of the Direction vector
	 */
	Direction(int xPos, int yPos) {
		x = xPos;
		y = yPos;
	}
	
	/**
	 * @brief Gets the x-component of the Direction vector
	 * @return an Integer
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @brief Gets the y-component of the Direction vector
	 * @return an Integer
	 */
	public int getY() {
		return y;
	}
}
