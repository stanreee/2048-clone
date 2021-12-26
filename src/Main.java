package src;

public class Main {

	public static void main(String[] args) {
		StateManager.getInstance().setState(new StartState());
	}
}
