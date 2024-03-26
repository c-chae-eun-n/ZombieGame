package zombie;

import java.util.Random;

abstract public class Unit {
	public final int MAX_HP;
	private int position;
	private int hp;
	private int max;
	Random random;
	
	public Unit(int position, int hp, int max) {
		this.position = position;
		MAX_HP = hp;
		this.hp = hp;
		this.max = max;
		random = new Random();
	}
	
	public int getMAX_HP() {
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
	
	public int getMax() {
		return this.max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	abstract void attack(Unit unit);
	
	@Override
	public String toString() {
		return String.format("[%d/%d]", this.hp, MAX_HP);
	}
}
