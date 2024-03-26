package zombie;

public class Hero extends Unit{
	private int power;
	private int potion;
	

	public Hero(int max, int hp, int position, int potion) {
		super(max, hp, position);
		this.potion = potion;
	}
	
	@Override
	public void attack(Unit enemy) {
		
		
	}
}
