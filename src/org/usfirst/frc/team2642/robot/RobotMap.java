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

	
	//ports for potentiometer channels
	public static int tiltPotPort = 3;
	public static int liftPotPort = 4;
	
	//ports for subsystem pneumatic cylinders
	public static int climbCylinderChannel = 0;
	public static int deployRampCylinderChannel = 1;
	public static int brakeCylinderChannel1 = 3;
	public static int brakeCylinderChannel2 = 2;
	public static int intakeCylinderChannel = 4;
	
	//ports for subsystem motors
	public static int leftDriveMotorPort = 0;
	public static int rightDriveMotorPort = 1;
	public static int liftMotorPort = 3;
	public static int intakeMotor1Port = 4;
	public static int intakeMotor2Port = 5;
	public static int intakeTiltMotorPort = 6;
	
	//ports for driver station stuff
	public static int auxXboxControllerPort = 1;
	public static int xboxControllerPort = 0;
	public static int autoDialPort = 2;
	
	//ports for encoders 
	public static int leftEncoderChannelA = 0;
	public static int leftEncoderChannelB = 1;
	public static int rightEncoderChannelA = 2;
	public static int rightEncoderChannelB = 3;
	
	//Min and Max values for potentiometers
	public static double minLift = .5;
	public static double maxLift = .9;
	public static double minTilt = .5;
	public static double maxTilt = .9;
	
	//Encoder measurements
	public static final double PULSES_PER_INCH = 0;
	
	public static final String logDirectory = "/home/lvuser/";
	public static final String logFileName = "log.txt";
}
