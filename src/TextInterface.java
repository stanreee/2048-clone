/**
 * @File: TextInterface.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Provides text messages to the terminal. Accessed by the getInstance() function. Only one instance of TextInterface is allowed.
 */

package src;

public class TextInterface {

	// state variables
	private static TextInterface instance = null;
	
	private String lineBreak = "--------------------------------";
	
	/**
	 * @brief Returns the current instance of TextInterface. Creates a new one if it does not exist.
	 * @return an instance of TextInterface
	 */
	public static TextInterface getInstance() {
		if(instance == null) instance = new TextInterface();
		return instance;
	}
	
	/**
	 * @brief Prints out the lose message of the game.
	 * @param score - Score the player achieved
	 */
	public void printLoseMessage(int score) {
		System.out.println(lineBreak);
		System.out.println("You lost! Your score was: " + score + ". Type 'n' for new game, type 'e' to exit");
		System.out.println(lineBreak);
	}
	
	/**
	 * @brief Prints out the win message of the game.
	 * @param score - Score the player achieved
	 */
	public void printWinMessage(int score) {
		System.out.println(lineBreak);
		System.out.println("You won! Your score was: " + score + ". Type 'n' for new game, type 'e' to exit");
		System.out.println(lineBreak);
	}
	
	/**
	 * @brief Prints out the welcome message when the player first starts the game.
	 */
	public void printWelcomeMessage() {
		System.out.println(lineBreak);
		System.out.println("Welcome to 2048! The goal of the game is to combine randomly spawned tiles until you reach the 2048 tile.");
		System.out.println("To move tiles, type the directions 'left', 'right', 'up', and 'down'.");
		System.out.println("You lose if you run out of possible moves.");
		System.out.println("Type 'start' to begin!");
		System.out.println(lineBreak);
	}
	
	/**
	 * @brief Prints out the exit message when the player exits the game.
	 */
	public void printExitMessage() {
		System.out.println(lineBreak);
		System.out.println("Thanks for playing!");
		System.out.println(lineBreak);
	}
}
