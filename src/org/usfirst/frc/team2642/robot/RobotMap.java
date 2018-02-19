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
	//ports for sonar channels
	//public static int sonarPingPort = 2;
	//public static int sonarEchoPort = 2; 
	
	//ports for potentiometer channels
	public static int tiltPotPort = 0;
	public static int liftPotPort = 1;
	
	//ports for subsystem pneumatic cylinders
	public static int climbCylinderChannel = 0;
	public static int deployRampCylinderChannel = 1;
	public static int brakeCylinderChannel1 = 2;
	public static int brakeCylinderChannel2 = 3;
	public static int raiseRampCylinderChannel = 4;
	
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
	
	//ports for encoders 
	public static int leftEncoderChannelA = 0;
	public static int leftEncoderChannelB = 1;
	public static int rightEncoderChannelA = 2;
	public static int rightEncoderChannelB = 3;
	
	//Encoder measurements
	public static final double PULSES_PER_INCH = 0;
}
