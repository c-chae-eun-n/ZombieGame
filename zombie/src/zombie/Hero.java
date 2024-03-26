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
//			Boss boss = (Boss) enemy;
//			
//			power = random.nextInt(this.getMax()) + 5;
			
		}else {
			power = random.nextInt(this.getMax()) + 5;
			System.out.printf("히어로 %d의 공격력으로 공격!!\n", power);
			int curHp = enemy.getHp();
			enemy.setHp(curHp - power);
			if(enemy.getHp() <= 0)
				enemy.setHp(0);
			System.out.println("좀비 현재 체력 : " + enemy);
		}
		
	}
	
	
}
