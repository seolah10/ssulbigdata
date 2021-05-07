package com.lec.ex08robot;

public class TestMain {
	
	public static void main(String[] args) {
		
		DanceRobot dRobot = new DanceRobot();
		SingRobot sRobot = new SingRobot();
		DrawRobot rRobot = new DrawRobot();
		RobotOrder order = new RobotOrder();
		
		order.action(dRobot);
		order.action(sRobot);
		
		Robot[] robots = {dRobot, sRobot, dRobot};
		
		for(Robot robot : robots) {
			order.action(robot);
			
		}
	}

}
