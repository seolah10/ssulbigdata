package strategy1.step5_modularization;

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
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

	@Override
	public void shape() {
		System.out.println("LowRobot은 팔, 다리, 머리, 몸통으로 이루어져 있습니다");
		
	}
	


}
