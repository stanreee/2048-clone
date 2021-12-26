/**
 * @File: State.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Abstract class that allows the program to run continuously. Children of this class inherit the abstract execute() method, which is ran continuously
 * when the child is constructed, until the state is exited.
 */

package src;

import java.util.Scanner;

public abstract class State {
	
	// state variables -- inherited by all children
	protected TextInterface ti;
	protected Scanner scanner;
	
	// restricted to the State class
	private boolean instate;
	
	/**
	 * @brief State constructor method. Initializes state variables.
	 */
	public State() {
		ti = TextInterface.getInstance();
		scanner = new Scanner(System.in);
		instate = true;
	}
	
	/**
	 * @brief Sets the instate state variable to false, exiting out of the while loop provided in start().
	 */
	public void exit() {
		instate = false;
	}
	
	/**
	 * @details Starts the state, which causes it to run the execute() method until the exit() method is called.
	 */
	public void start() {
		do {
			execute();
		}while(instate);
	}
	
	/**
	 * @brief Abstract method inherited by State children.
	 * @details Each state child implements this method, and whatever code is put in the method is ran continuously.
	 */
	abstract public void execute();
}
