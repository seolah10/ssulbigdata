package strategy1.step1;

// ���� Ư¡: shape, walk, run
// LowRobout���� Ư¡: can't fly, no missile, no knife
public class LowRobot {
	
	public void shape() {
		System.out.println("SuperRobot�� ��, �ٸ�, �Ӹ� , �������� �̷���� �ֽ��ϴ�.");
	}

	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�.");
	}

	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�.");
	}

	public void actionFly() {
		System.out.println("�� �� �����ϴ�.");
	}

	public void actionMissile() {
		System.out.println("�̻����� �� �� �����ϴ�.");
	}
	public void actionKnife() {
		System.out.println("���� �����ϴ�.");
	}
}
