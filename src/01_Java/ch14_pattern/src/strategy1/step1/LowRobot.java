package strategy1.step1;

// 공통 특징: shape, walk, run
// LowRobout만의 특징: can't fly, no missile, no knife
public class LowRobot {
	
	public void shape() {
		System.out.println("SuperRobot은 팔, 다리, 머리 , 몸통으로 이루어져 있습니다.");
	}

	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}

	public void actionFly() {
		System.out.println("날 수 없습니다.");
	}

	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}
	public void actionKnife() {
		System.out.println("검이 없습니다.");
	}
}
