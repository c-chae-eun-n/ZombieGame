package zombie;

public class Unit {
	public final int MAX_HP;
	private int hp;
	private int position;
	
	public Unit(int hp, int position) {
		MAX_HP = hp;
		this.hp = hp;
		this.position = position;
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
	
}
