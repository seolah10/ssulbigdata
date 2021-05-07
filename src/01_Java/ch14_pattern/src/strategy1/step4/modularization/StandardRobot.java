package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeWood;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;

//StandardRobot�� �ش��ϴ� ��ǰ��(components)���� �ҷ��´�.

public class StandardRobot extends Robot {

	private FlyImpl fly; // ��ǰ ������ import
	private MissileImpl missile;
	private KnifeImpl knife;
	
	public StandardRobot() { // ��ǰ ����
		fly = new FlyNo();
		missile = new MissileYes();
		knife = new KnifeWood();
//		setFly(new FlyYes());
//		setMissile(new MissileYes());
//		setKnife(new KnifeLazer());		
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










