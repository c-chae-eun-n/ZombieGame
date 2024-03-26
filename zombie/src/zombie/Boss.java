package zombie;

public class Boss extends Zombie {
	private int secondHp;

	public Boss(int position, int firstHp, int max, int secondHp) {
		super(position, firstHp, max);
		this.secondHp = secondHp;
	}

	public int getSecondHp() {
		return this.secondHp;
	}

	public void setSecondHp(int secondHp) {
		this.secondHp = secondHp;
	}
	
}
