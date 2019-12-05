package com.xebiaDemo.robot;

import com.xebiaDemo.robot.business.RobotAction;
import com.xebiaDemo.robot.model.Robot;

public class RobotClient {

	public static void main(String[] args) {
		Robot robot = Robot.Builder.newInstance().setChargingLevel(100).setLightColor("BLUE").build();
		// TODO Auto-generated method stub
		RobotAction rAction = new RobotAction();
		//rAction.carry(robot, 5);
	//	rAction.walkAndCarry(robot, 10, 4);
		rAction.walk(robot, 3);
		rAction.barCodeScan(11);
	}

}
