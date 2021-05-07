package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeLazer;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes; 

public class SuperRobot extends Robot {
			
		private FlyImpl fly; // 何前 单捞磐 import
		private MissileImpl missile;
		private KnifeImpl knife;
		
		public SuperRobot() { // 何前 积己
			fly = new FlyYes();
			missile = new MissileYes();
			knife = new KnifeLazer();
//			setFly(new FlyYes());
//			setMissile(new MissileYes());
//			setKnife(new KnifeLazer());		
		}

	@Override
	public void actionFly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionMissile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionKnife() {
		// TODO Auto-generated method stub
		
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









