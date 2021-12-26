/**
 * @File: GameState.java
 * @Author: Stanley Chan - chans67
 * @Date: April 11th, 2021
 * @Description: Module that inherits the State class. Serves as the basis for the controller of the MVC design.
 */

package src;

public class GameState extends State{
	
	// state variables
	private Game game;
	
	/**
	 * @brief Constructor for the GameState.
	 * @details Runs the State constructor, then initializes the state variables, setting up the Game object.
	 */
	public GameState() {
		super();
		initializeGame();
	}
	
	/**
	 * @brief Overrides the State execute() method.
	 * @details Serves as the basis for the game's controller. Takes in user input and uses that to update the Game object. Continues until the game is no longer in progress, in which
	 * it sets the current state of the StateManager to the WinState or LoseState accordingly.
	 */
	@Override
	public void execute() {
		game.getBoard().print();
		String s = scanner.next();
		try {
			Direction dir = Direction.valueOf(s);
			game.move(dir);
		}catch(IllegalArgumentException e) {
			if(s.equalsIgnoreCase("exit")) {
				StateManager.getInstance().endGame();
				return;
			}
			System.out.println("Invalid direction '" + s + "'!");
		}
		
		if(!game.inProgress()) {
			if(game.hasWon()) StateManager.getInstance().setState(new WinState(game.getBoard().getScore()));
			else StateManager.getInstance().setState(new LoseState(game.getBoard().getScore()));
		}
	}
	
	private void initializeGame() {
		game = new Game();
		game.setBoard(new Board());
		System.out.println("To exit the current game, type 'exit'.");
	}
}
