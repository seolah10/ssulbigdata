package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeNo;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileNo;

//LowRobot�� �ش��ϴ� ��ǰ��(components)���� �ҷ��´�.

public class LowRobot extends Robot {

	private FlyImpl fly; // ��ǰ ������ import
	private MissileImpl missile;
	private KnifeImpl knife;

	public LowRobot() {
		fly = new FlyNo();
		missile = new MissileNo();
		knife = new KnifeNo();
	}
	
	@Override
	public void actionFly() {
		fly.fly();
		
	}

	@Override
	public void actionMissile() {
		missile.missile();
		
	}

	@Override
	public void actionKnife() {
		knife.knife();
		
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
	
	

}
