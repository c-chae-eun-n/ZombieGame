package zombie;

public class Boss extends Zombie {
	private int shield;

	public Boss(int max, int hp, int position, int shield) {
		super(max, hp, position);
		this.shield = shield;
	}
	
}
