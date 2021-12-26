/**
 * @File: LoseState.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that inherits the State class. Used when the game ends and the player won.
 */

package src;

public class WinState extends State{

	// state variables
	private int score;
	
	/**
	 * @brief Constructor for WinState
	 * @details Runs the State constructor, then initializes the state variables.
	 * @param score - The score the user has gotten after the game has ended
	 */
	public WinState(int score) {
		super();
		this.score = score;
	}
	
	/**
	 * @brief Overrides the State execute() method.
	 * @details Displays the win message text to the terminal, then asks for user input.
	 */
	@Override
	public void execute() {
		ti.printWinMessage(score);
		
		String answer = "";
		System.out.println("Choose an option");
		answer = scanner.next();
		
		if(answer.equalsIgnoreCase("n")) {
			StateManager.getInstance().setState(new GameState());
		}
		
		if(answer.equalsIgnoreCase("e")) {
			StateManager.getInstance().endGame();
		}
	}

}
