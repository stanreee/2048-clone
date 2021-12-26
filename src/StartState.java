/**
 * @File: StartState.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that inherits the State class. Is the first state that the program is in when ran.
 */

package src;

public class StartState extends State {
	
	/**
	 * @brief Overrides the State execute() method.
	 * @details Displays the welcome message, and asks for user input. Changes the state to the GameState.
	 */
	@Override
	public void execute() {
		String answer = "";
		ti.printWelcomeMessage();
		answer = scanner.nextLine();
		if(answer.equalsIgnoreCase("start")) {
			StateManager.getInstance().setState(new GameState());
		}
	}

}
