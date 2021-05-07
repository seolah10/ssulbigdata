package strategy1.step5_modularization;

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
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

	@Override
	public void shape() {
		System.out.println("LowRobot�� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�");
		
	}
	


}
