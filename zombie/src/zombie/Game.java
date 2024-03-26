package zombie;

import java.util.Scanner;

public class Game {
	
	private Scanner scan = new Scanner(System.in);
	
	private int pos;
	private boolean isExit;
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	
	private Game() {
		pos = 1;
		hero = new Hero(1, 100, 20, 2);
		zombie = new Zombie(5, 50, 10);
		boss = new Boss(10, 70, 30, 150);
	}
	
	private static Game instance = new Game();
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {

	}
}
