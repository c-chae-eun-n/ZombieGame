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
	void attack(Unit hero) {
		super.attack(hero);
	}
	
}
