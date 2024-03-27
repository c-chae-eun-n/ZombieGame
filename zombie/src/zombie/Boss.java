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
	
	public void shield(Hero hero) {
		int rNum = random.nextInt(3);
		if(rNum == 0) {
			hero.setPower(0);
			System.out.println("보스 쉴드 발동!!");
			System.out.println("히어로 공격 실패!!");
		}
	}
	
	@Override
	public void attack(Unit hero) {
		int power = random.nextInt(this.getMax()) + 5;
		System.out.printf("보스 %d의 공격력으로 공격!\n", power);
		
		int curHp = hero.getHp();
		hero.setHp(curHp - power);
		if(hero.getHp() <= 0) {
			hero.setHp(0);
		}
		System.out.println("히어로 현재 체력 : " + hero);
	}
	
}
