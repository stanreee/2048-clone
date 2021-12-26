/**
 * @File: GameState.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that keeps track of x and y positions. Constrains the x and y positions in between 0 and 3. 
 */

package src;

public class Position {

	// state variables
	private int x, y;
	
	/**
	 * @brief Constructor for the Position abstract data type.
	 * @param xPos - x position
	 * @param yPos - y position
	 */
	public Position(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
		constrainXPos();
		constrainYPos();
	}
	
	/**
	 * @return the x-position as an integer.
	 */
	public int getX() { return x; }
	
	/**
	 * @return the y-position as an integer.
	 */
	public int getY() { return y; }
	
	/**
	 * @brief Shifts the x-coordinate, maintaining the state invariant.
	 * @param xPos - amount to shift the x-coordinate by.
	 */
	public void addX(int xPos) { 
		this.x += xPos; 
		constrainXPos();
	}
	
	/**
	 * @brief Shifts the y-coordinate, maintaining the state invariant.
	 * @param yPos - amount to shift the y-coordinate by.
	 */
	public void addY(int yPos) { 
		this.y += yPos; 
		constrainYPos();
	}
	
	/**
	 * @brief Checks if two Position objects are equal by ensuring the coordinates are the same.
	 * @param p - Position to compare
	 * @return boolean - true if both Position objects are equal.
	 */
	public boolean equals(Position p) {
		return p.getX() == getX() && p.getY() == getY();
	}
	
	private void constrainXPos() {
		if(x < 0) x = 0;
		if(x > 3) x = 3;
	}
	
	private void constrainYPos() {
		if(y < 0) y = 0;
		if(y > 3) y = 3;
	}
	
	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}
}
