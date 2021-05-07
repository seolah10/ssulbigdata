package strategy1.step4.modularization;

import strategy1.step4.component.FlyHigh;
import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyYes;

public class TestMain {

		public static void main(String[] args) {
			
			SuperRobot superRobot = new SuperRobot();
			StandardRobot standardRobot = new StandardRobot();
			LowRobot lowRobot = new LowRobot();
			
			Robot[] robots = {superRobot, standardRobot, lowRobot};
			
			for(Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			
			}
			//LowRobot을 날 수 있는 로봇으로 업그레이
			lowRobot.setFly(new FlyYes());
			
			//SuperRobot을 더 높이 나는 로봇으로 업그레이드
			superRobot.setFly(new FlyHigh());
			
			System.out.println("업그레이드 후");
			
			for(Robot robot : robots) {
				robot.shape();
				robot.actionWalk();
				robot.actionRun();
				robot.actionFly();
				robot.actionMissile();
				robot.actionKnife();
			}
		}
}














