/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2642.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//ports for subsystem motors
	public static int leftDriveMotorPort = 0;
	public static int rightDriveMotorPort = 1;
	public static int climbHookMotorPort = 2; //may not be needed
	public static int liftMotorPort = 3;
	public static int intakeInMotorPort = 4;
	public static int intakeOutMotorPort = 5;
	public static int intakeTiltMotorPort = 6;
	//ports for driver station stuff
	public static int auxXboxControllerPort = 1;
	public static int xboxControllerPort = 0;
}
