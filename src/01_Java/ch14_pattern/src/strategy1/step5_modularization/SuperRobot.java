package strategy1.step5_modularization;

import strategy1.step4.component.*; // "��Ű����.*"���� ���� import�ּҵ�(?)�� �����Ѵ�.
									// �ٽ� ��ϵ� �ҷ������� ctrl+shift+o 
// SuperRobot�� �ش��ϴ� ��ǰ��(components)���� �ҷ��´�.

public class SuperRobot extends Robot {
	
	private FlyImpl fly; // ��ǰ ������ import
	private MissileImpl missile;
	private KnifeImpl knife;
	
	public SuperRobot() { // ��ǰ ����

		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}	

	@Override
	public void shape() {
		System.out.println("SuperRobot�� ��, �ٸ�, �Ӹ�, �������� �̷���� �ֽ��ϴ�");
	}
		
		
}
	
	












