/**
 * 
 */
package com.xebiaDemo.robot.business;

import com.xebiaDemo.robot.model.Robot;
import com.xebiaDemo.robot.constant.*;

/**
 * @author UPENDER
 *
 */
public class RobotMonitor {

	/*
	 * Method to check over weight.
	 * @Param 
	 */
	public String weightCheck(Robot robot, Integer weight) {
		String statusMssg = RobotConstants.PASS;

		if (weight > 10) {
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(RobotConstants.OVERWEIGHT);
			statusMssg = RobotConstants.FAIL;
		}
		return statusMssg;

	}

	/*
	 * Method to check power status
	 */
	public String powerCheck(Robot robot, Integer chargingReq) {
		String statusMssg = RobotConstants.PASS;
		Integer avlCharging = robot.getChargingLevel();
		
		if (chargingReq > avlCharging) {
			statusMssg = RobotConstants.FAIL;
			System.out.println("Low Charging. Pls try again.");
		} else {
			Integer remainingChrging = avlCharging - chargingReq;
			robot.setChargingLevel(remainingChrging);
			if (remainingChrging < 15) {
				robot.setLightColor(RobotConstants.COLOR_RED);
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
			}
		}
		return statusMssg;
	}
}
