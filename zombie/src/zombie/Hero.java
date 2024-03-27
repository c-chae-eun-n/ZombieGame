package zombie;

public class Hero extends Unit{
	private int power;
	private int potion;
	

	public Hero(int position, int hp, int max, int potion) {
		super(position, hp, max);
		this.potion = potion;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPotion() {
		return this.potion;
	}
	
	public void setPotion(int potion) {
		this.potion = potion;
	}
	
	@Override
	public void attack(Unit enemy) {
		if (enemy instanceof Boss) {
			Boss boss = (Boss) enemy;
			power = random.nextInt(this.getMax()) + 5;
			System.out.printf("히어로 %d의 공격력으로 공격!!\n", power); 
			if (boss.getHp() >= 0 && boss.getSecondHp() == 0) {
				boss.shield(this);
				if (power == 0) {
					System.out.printf("Boss 현재 체력 : [%d/%d]\n", boss.getHp(), boss.getMaxHp());
					return;
				}

				int temp = boss.getHp() - power;
				if (temp <= 0) {
					boss.setHp(0);
					return;
				}
				boss.setHp(boss.getHp() - power);
				System.out.printf("Boss 현재 체력 : [%d/%d]\n", boss.getHp(), boss.getMaxHp());
			} else if (boss.getHp() >= 0 && boss.getSecondHp() != 0) {
				int temp = boss.getHp() - power;
				if (temp == 0 && boss.getSecondHp() == 0) {
					boss.setHp(0);
				} else if (temp <= 0) {
					boss.setHp(boss.getSecondHp());
					boss.setSecondHp(0);
					System.out.println("Boss Chapter 2!!");
					return;
				}
				boss.setHp(boss.getHp() - power);
				System.out.println("Boss 현재 체력 : " + boss);
			}

		} else {
			power = random.nextInt(this.getMax()) + 5;
			System.out.printf("히어로 %d의 공격력으로 공격!!\n", power);
			int curHp = enemy.getHp();
			enemy.setHp(curHp - power);
			if (enemy.getHp() <= 0)
				enemy.setHp(0);
			System.out.println("좀비 현재 체력 : " + enemy);
		}

	}
	
	public void recovery() {
		if(potion == 0) {
			System.err.println("포션이 없다!!");
			return;
		}
		int curHp = this.getHp();
		int recovery = curHp + 50;
		if(recovery > 100)
			recovery = 100;
		
		this.setHp(recovery);
		potion --;
		System.out.println("히어로 회복!!\n히어로 현재 체력 : " + this);
	}
}
