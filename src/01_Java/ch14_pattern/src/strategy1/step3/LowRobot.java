package strategy1.step3;

//공통점은 Robot클래스로 모아 올리고
//여기엔 LowRobot만의 특징을 입력

public class LowRobot extends Robot {

	@Override
	public void actionFly() {
		System.out.println("날 수 없습니다.");
		
	}

	@Override
	public void actionMissile() {
		System.out.println("미사일을 쏠 수 없습니다.");
		
	}

	@Override
	public void actionKnife() {
		System.out.println("검이 없습니다.");
		
	}
	

}
