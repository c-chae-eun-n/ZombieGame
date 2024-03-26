package zombie;

public class Boss extends Zombie {
	private int secondHp;

	public Boss(int max, int firstHp, int position, int secondHp) {
		super(max, firstHp, position);
		this.setSecondHp(secondHp);
	}

	public int getSecondHp() {
		return this.secondHp;
	}

	public void setSecondHp(int secondHp) {
		this.secondHp = secondHp;
	}
	
}
