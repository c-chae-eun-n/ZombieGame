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
		hero = new Hero(1, 100, 20, 10);
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
			
			if(hero.getPosition() == 5) {
				attackByZombie();
			}
			else if(hero.getPosition() == 10) {
				attackByBoss();
			}
		}else if(sel == 2) {
			exit();
		}
	}
	
	private void move() {
		pos += 1;
		hero.setPosition(pos);
	}
	
	private void attackByZombie() {
		System.out.println("좀비를 만났다! 공격 모드로 전환!");
		while(true) {
			System.out.printf("(1) 공격하기 (2) 포션(보유량 : %d개)\n", hero.getPotion());
			int sel = inputNumber("선택");
			if(sel == 1) {
				zombie.attack(hero);
				hero.attack(zombie);
				if(isHeroDead()) {
					break;
				}
				if(isZombieDead()) {
					break;
				}
			}
			else if(sel == 2) {
				hero.recovery();
			}
		}
	}
	
	private void attackByBoss() {
		System.out.println("보스를 만났다! 공격 모드로 전환!");
		while(true) {
			System.out.printf("(1) 공격하기 (2) 포션(보유량 : %d개)\n", hero.getPotion());
			int sel = inputNumber("선택");
			if(sel == 1) {
				boss.attack(hero);
				hero.attack(boss);
				if(isHeroDead()) {
					break;
				}
				if(isBossDead()) {
					break;
				}
			}
			else if(sel == 2) {
				hero.recovery();
			}
		}
	}
	
	private boolean isHeroDead() {
		if(hero.getHp() == 0) {
			System.err.println("사망...");
			isExit = true;
			return true;
		}
		return false;
	}
	
	private boolean isZombieDead() {
		if(zombie.getHp() == 0) {
			System.out.println("좀비를 무찔렀다 -!!");
			zombie.drop(hero);
			return true;
		}
		return false;
	}
	
	private boolean isBossDead() {
		if(boss.getHp() == 0 && boss.getSecondHp() == 0) {
			System.out.println("보스를 무찔렀다 -!!");
			System.out.println("GAME CLEAR~~!!");
			isExit = true;
			return true;
		}
		return false;
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
