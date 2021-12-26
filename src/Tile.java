/**
 * @File: Tile.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that models 2048 tiles.
 */

package src;

public class Tile {
	
	// state variables
	private int value;
	private Position position;
	
	/**
	 * @brief Constructor for Tile.
	 * @param p - Position to place the tile in on the Board.
	 * @param val - integer value of the Tile.
	 */
	public Tile(Position p, int val) {
		value = val;
		position = p;
	}
	
	/**
	 * @return integer value of the tile
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * @brief Sets the value of the Tile.
	 * @param v - integer value of the Tile
	 */
	public void setValue(int v) {
		value = v;
	}
	
	/**
	 * @brief Checks whether two Tiles are equal to each other based off their value.
	 * @param tile - Tile to compare
	 * @return true if the two tiles are equal.
	 */
	public boolean equals(Tile tile) {
		return value == tile.getValue();
	}
	
	/**
	 * @brief Combines a tile with another tile if they are the same value.
	 * @param t - Tile to combine
	 */
	public void combine(Tile t) {
		if(this.equals(t)) value *= 2;
	}
	
	/**
	 * @return the Position of the Tile
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * @brief Sets the Position of the Tile.
	 * @param newPos - the new Position for the Tile
	 */
	public void setPosition(Position newPos) {
		position = newPos;
	}
}
