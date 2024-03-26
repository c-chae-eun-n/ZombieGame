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
	
	private int inputNumber(String message) {
		int number = 0;
		
		try {
			System.out.print(message + " : ");
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요.");
		}
		
		return number;
	}
	
	private void printMove() {
		System.out.println("현재 위치 : " + pos);
		System.out.println("(1) 앞으로 이동 (2) 종료");
	}
	
	private void runMenu() {
		printMove();
		int sel = inputNumber("이동하기");
		
		if(sel == 1) {
			move();
		}else if(sel == 2) {
			exit();
		}
	}
	
	private void move() {
		pos += 1;
		hero.setPosition(pos);
	}
	
	private void exit() {
		isExit = true;
	}
	
	public void run() {
		while(!isExit) {
			runMenu();
		}
	}
}
