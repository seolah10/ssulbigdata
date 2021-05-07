package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeNo;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileNo;

//LowRobot에 해당하는 부품들(components)들을 불러온다.

public class LowRobot extends Robot {

	private FlyImpl fly; // 부품 데이터 import
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
