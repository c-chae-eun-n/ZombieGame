package zombie;

public class Hero extends Unit{
	private int power;
	private int potion;
	

	public Hero(int position, int hp, int max, int potion) {
		super(position, hp, max);
		this.potion = potion;
	}
	
	public int getPotion() {
		return this.potion;
	}
	
	public void setPotion(int potion) {
		this.potion = potion;
	}
	
	@Override
	public void attack(Unit enemy) {
		if(enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			
			power = random.nextInt(super.getMax()) + 5;
			
		}
		
	}
}
