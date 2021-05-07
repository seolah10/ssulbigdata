package strategy1.step5_modularization;

import strategy1.step4.component.*; // "패키지명.*"으로 하위 import주소들(?)을 함축한다.
									// 다시 목록들 불러오려면 ctrl+shift+o 
// SuperRobot에 해당하는 부품들(components)들을 불러온다.

public class SuperRobot extends Robot {
	
	private FlyImpl fly; // 부품 데이터 import
	private MissileImpl missile;
	private KnifeImpl knife;
	
	public SuperRobot() { // 부품 생성

		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}	

	@Override
	public void shape() {
		System.out.println("SuperRobot은 팔, 다리, 머리, 몸통으로 이루어져 있습니다");
	}
		
		
}
	
	












