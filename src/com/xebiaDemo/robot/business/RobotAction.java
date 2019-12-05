package com.xebiaDemo.robot.business;

import com.xebiaDemo.robot.constant.RobotConstants;
import com.xebiaDemo.robot.model.Robot;
/**
 * Class defines various robot actions.
 * @author UPENDER
 *
 */
public class RobotAction {
		
	public void walk (Robot robot, float distance)
	{
		Integer chargingRequired = (int) (distance * 100/5);
		RobotMonitor rMonitor = new RobotMonitor();
		String pwrCheck = rMonitor.powerCheck(robot, chargingRequired);
		if (pwrCheck.equals(RobotConstants.PASS)) {
			System.out.println("Robot walked " +distance+ "kms. Remaing Charging "+robot.getChargingLevel()+".");
		}
		System.out.println("Charging indicator is "+robot.getLightColor());
	}

	
	public void walkAndCarry (Robot robot, Integer weight, float distance)
	{
		RobotMonitor rMonitor = new RobotMonitor();
		String wghtCheck = rMonitor.weightCheck(robot, weight);
		if (wghtCheck.equals(RobotConstants.PASS)) {
			Integer chargingRequired = (int) ((distance * 100/5) + (2 * weight));
			String pwrCheck = rMonitor.powerCheck(robot, chargingRequired);
			if (pwrCheck.equals(RobotConstants.PASS)) {
				System.out.println("Robot walked " +distance+ "kms with "+weight+ "kg weight. Remaing Charging "+robot.getChargingLevel()+".");
			}
			System.out.println("Charging indicator is "+robot.getLightColor());
		}
	}
	
	public void carry (Robot robot, Integer weight)
	{
		RobotMonitor rMonitor = new RobotMonitor();
		String wghtCheck = rMonitor.weightCheck(robot, weight);
		if (wghtCheck.equals(RobotConstants.PASS)) {
			Integer chargingRequired = 2 * weight;
			String pwrCheck = rMonitor.powerCheck(robot, chargingRequired);
			if (pwrCheck.equals(RobotConstants.PASS)) {
				System.out.println("Robot walked with "+weight+ "kg weight. Remaing Charging "+robot.getChargingLevel()+".");
			}
			System.out.println("Charging indicator is "+robot.getLightColor());
		}
		
	}
	
	/*
	 * Scanning bar code
	 */
	public void barCodeScan ( Integer barCode)
	{
		//Api result assumption
		String apiString = (barCode % 2 == 0) ? RobotConstants.PASS : RobotConstants.FAIL;
		if (apiString.equals(RobotConstants.PASS))
		  System.out.println("The price is $xx.xx");
		else {
			System.out.println("Scan Failure");
		}
	}
}
