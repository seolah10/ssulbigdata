package strategy1.step4.modularization;

// step.4 (여기는 step.3 과 동일)
// 세 로봇의 공통점을 모아서 이곳에 입력하고
// 공통점이 아닌 메소드는 추상 메소드로 입력하여 선언 후, 
// 각각의 로봇 클래스에서 override한다.

public abstract class Robot {

	public void shape() {
		System.out.println(getClass().getName()+"은 팔,다리,머리,몸통으로 이루어져 있다.");
	}
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	public abstract void actionFly();
	
	public abstract void actionMissile();
	
	public abstract void actionKnife();
}
