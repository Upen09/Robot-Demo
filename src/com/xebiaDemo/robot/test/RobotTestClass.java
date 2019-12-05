package com.xebiaDemo.robot.test;

import org.junit.Test;

import com.xebiaDemo.robot.business.RobotAction;
import com.xebiaDemo.robot.model.Robot;

import junit.framework.TestCase;
public class RobotTestClass extends TestCase{
	
	protected RobotAction rAction;
	protected Robot robot1,robot2,robot3;
	protected void setUp() {
		 rAction = new RobotAction();
		 robot1 = Robot.Builder.newInstance().setChargingLevel(100).setLightColor("BLUE").build();
		 robot2 = Robot.Builder.newInstance().setChargingLevel(100).setLightColor("BLUE").build();
		 robot3 = Robot.Builder.newInstance().setChargingLevel(100).setLightColor("BLUE").build();
	}
	@Test
	public void testWalk () {
		rAction.walk(robot1, (float) 3.5);
		assertEquals((Integer)30,robot1.getChargingLevel());
	}
	
	@Test
	public void testWalkAndCarry () {
		rAction.walkAndCarry(robot2, 2, 3);
		assertEquals((Integer)36,robot2.getChargingLevel());
	}
	
	@Test
	public void testCarry () {
		rAction.carry(robot2, 12);
		assertEquals((Integer)100,robot3.getChargingLevel());
	}
}
