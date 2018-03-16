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

	//pixycam ports
	public static int pixyAnalogPort = 1;
	public static int pixyDigitalPort = 4;
	
	//sonar ports
	public static int sonarPort = 0;
	
	//ports for potentiometer channels
	public static int tiltPotPort = 3;
	public static int liftPotPort = 2;
	
	//ports for subsystem pneumatic cylinders
	public static int climbCylinderChannel = 0;
	public static int brakeCylinderChannel1 = 3;
	public static int brakeCylinderChannel2 = 2;
	public static int closeIntakeCylinderChannel = 4;
	public static int openIntakeCylinderChannel = 1;
	
	//ports for subsystem motors
	public static int leftDriveMotorPort = 0;
	public static int rightDriveMotorPort = 1;
	public static int liftMotorPort = 3;
	public static int intakeMotor1Port = 4;
	public static int intakeMotor2Port = 5;
	public static int intakeTiltMotorPort = 6;
	
	//ports for driver station stuff
	public static int auxXboxControllerPort = 2;
	public static int xboxControllerPort = 1;
	public static int autoDialPort = 0;
	
	//ports for encoders 
	public static int leftEncoderChannelA = 0;
	public static int leftEncoderChannelB = 1;
	public static int rightEncoderChannelA = 2;
	public static int rightEncoderChannelB = 3;
	
	//Min and Max values for potentiometers
	public static double minLift = .54;
	public static double maxLift = .935;
	public static double minTilt = .6;
	public static double maxTilt = .85;
	
	//Encoder measurements
	public static final double PULSES_PER_INCH = 200.0/12;
	
	//logger destination
	public static final String logDirectory = "/home/lvuser/";
	public static final String logFileName = "log.txt";
	
	//Pot height and tilt
	public static final double switchHeight = 0.7;
	public static final double switchTilt = 0.7;
	public static final double scaleHeight = 0.93;
	public static final double scaleTilt = 0.83;
	public static final double cubeHeight = 0.55;
	public static final double cubeTilt = 0.61;
}
