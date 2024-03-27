package zombie;

public class Zombie extends Unit {
	private int power;
	
	public Zombie(int position, int hp, int max) {
		super(position, hp, max);
	}
	
	@Override
	public void attack(Unit hero) {
		power = random.nextInt(this.getMax()) + 5;
		System.out.printf("좀비 %d의 공격력으로 공격!\n", power);
		
		int curHp = hero.getHp();
		hero.setHp(curHp - power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		System.out.println("히어로 현재 체력 : " + hero);
	}
	
}
