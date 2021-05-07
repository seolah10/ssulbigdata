package com.lec.ex08robot;

public class RobotOrder {

	public void action(Robot robot) { 
		
		if(robot instanceof DrawRobot) {
			DanceRobot drobot = (DanceRobot)robot;
			drobot.dance();
		}
		else if(robot instanceof SingRobot) {
			//((SingRobot)robot).sing();
			SingRobot sRobot = (SingRobot)robot;
			sRobot.sing();
		}
		else if (robot instanceof DrawRobot) {
			//((DrawRobot)robot).draw();
			DrawRobot rRobot = (DrawRobot)robot;
			rRobot.draw();
		}
	

}

}
