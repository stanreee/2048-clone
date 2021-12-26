/**
 * @File: StateManager.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that manages all State children. Accessed by the getInstance() function. Only one instance of StateManager is allowed.
 */

package src;

public class StateManager {

	// state variables
	private static StateManager instance = null;
	
	private State currentState;
	
	/**
	 * @brief Gets the current existing instance of StateManager. Creates one if it does not exist.
	 * @return a StateManager instance
	 */
	public static StateManager getInstance() {
		if(instance == null) instance = new StateManager();
		return instance;
	}
	
	/**
	 * @brief Exits the current state (if it is not null), then sets the current state of the StateManager, then starts the state.
	 * @param state - State to set
	 */
	public void setState(State state) {
		if(currentState != null) currentState.exit();
		currentState = state;
		currentState.start();
	}
	
	/**
	 * @brief Completely exits out of any current state being ran and exits the program.
	 */
	public void endGame() {
		if(currentState != null) currentState.exit();
		currentState = null;
		TextInterface.getInstance().printExitMessage();
	}
}
