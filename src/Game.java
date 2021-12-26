/**
 * @File: Game.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Abstract data type that handles Game events and manipulates the Board.
 */

package src;

import java.util.Scanner;

public class Game {
	
	private Board board;
	private boolean inProgress;
	private boolean won;
	
	/**
	 * @brief Constructor for the Game module
	 * @details Creates a new Game object. Sets up state variables.
	 */
	public Game() {
		inProgress = true;
		won = false;
	}
	
	/**
	 * @brief Sets the Board of the game.
	 * @param b - The Board to be used
	 */
	public void setBoard(Board b) {
		board = b;
	}
	
	/**
	 * @brief Ends the game, and sets whether the user won or not.
	 * @param won - true if the user won, false if the user lost
	 */
	public void endGame(boolean won) {
		this.inProgress = false;
		this.won = won;
	}
	
	/**
	 * @return a boolean that returns true if the game is in progress, false if not.
	 */
	public boolean inProgress() {
		return inProgress;
	}
	
	/**
	 * @return Checks if the user won, after the game has ended.
	 * @throws RuntimeException if hasWon was checked while the game is currently in progress.
	 */
	public boolean hasWon() {
		if(inProgress) throw new RuntimeException("ERROR: Outcome requested while game is currently running.");
		return won;
	}
	
	/**
	 * @return Returns the Board of the game.
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * @details Moves the Board that is set in the Direction given.
	 * @param d - The Direction for the Board to move.
	 */
	public void move(Direction d) {
		board.moveBoard(d);
		if(board.checkWin()) endGame(true);
		if(board.getPossibleMoves() == 0) endGame(false);
	}
}
