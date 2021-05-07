package strategy1.step5_modularization;

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

		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());		
	}

	@Override
	public void shape() {
		System.out.println("StandardRobot�� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�");
		
	}
	

	
	


}










