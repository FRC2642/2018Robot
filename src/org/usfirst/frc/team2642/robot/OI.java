/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
	/*
	Left stick = drive 0.6, turn 0.6		Regular Drive
	Left trigger = drive 1.0, turn 0.6		High Speed Drive
	Right trigger = drive 1.0, turn 1.0		High Speed Turn	 
	
	Right stick = intake tilt up and down
	 */
	Button xboxLeftBumper = new JoystickButton(xbox, 5);  //lift down
	Button xboxRightBumper = new JoystickButton(xbox, 6); //lift up
	
	Button xboxA = new JoystickButton(xbox, 1); 	//intake in
	Button xboxX = new JoystickButton(xbox, 3);		//intake out
	
	
		
	public static Joystick auxillery = new Joystick(RobotMap.auxilleryControlsPort);
	
}
