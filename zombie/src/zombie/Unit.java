package zombie;

import java.util.Random;

abstract public class Unit {
	public final int MAX_HP;
	private int hp;
	private int position;
	Random random;
	
	public Unit(int max, int hp, int position) {
		MAX_HP = max;
		this.hp = hp;
		this.position = position;
		random = new Random();
	}
	
	public int getMax() {
		return MAX_HP;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	abstract void attack(Unit unit);
}
