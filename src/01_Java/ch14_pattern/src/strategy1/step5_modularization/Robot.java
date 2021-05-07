package strategy1.step5_modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.MissileImpl;

// step.5 
// 세 로봇의 공통된 소스들을 싹 다 이 곳으로 모아 올린다. (데이터, 메소드, setter)

public abstract class Robot { // 데이터

	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;
	
	
	public abstract void shape(); // 메소드
	
	public void actionWalk() { 
		System.out.println("걸을 수 있습니다.");
	}
	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}
	public void actionFly() { // 추상메소드였던 공통점이 없는 내용들을 이렇게 변경한다.
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
