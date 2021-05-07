package strategy1.step4.modularization;

// step.4 (����� step.3 �� ����)
// �� �κ��� �������� ��Ƽ� �̰��� �Է��ϰ�
// �������� �ƴ� �޼ҵ�� �߻� �޼ҵ�� �Է��Ͽ� ���� ��, 
// ������ �κ� Ŭ�������� override�Ѵ�.

public abstract class Robot {

	public void shape() {
		System.out.println(getClass().getName()+"�� ��,�ٸ�,�Ӹ�,�������� �̷���� �ִ�.");
	}
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}
	public abstract void actionFly();
	
	public abstract void actionMissile();
	
	public abstract void actionKnife();
}
