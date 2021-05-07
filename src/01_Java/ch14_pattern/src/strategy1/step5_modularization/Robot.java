package strategy1.step5_modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.MissileImpl;

// step.5 
// �� �κ��� ����� �ҽ����� �� �� �� ������ ��� �ø���. (������, �޼ҵ�, setter)

public abstract class Robot { // ������

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	
	public abstract void shape(); // �޼ҵ�
	
	public void actionWalk() { 
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public void actionFly() { // �߻�޼ҵ忴�� �������� ���� ������� �̷��� �����Ѵ�.
			fly.fly();
	}
	public void actionMissile() {
			missile.missile(); 
	}
	public void actionKnife()  {
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
