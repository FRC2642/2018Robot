/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2642.robot;

import org.usfirst.frc.team2642.robot.commands.brake.DeployBrakeCommand;
import org.usfirst.frc.team2642.robot.commands.brake.ResetBrakeCommand;
import org.usfirst.frc.team2642.robot.commands.climb.DeployHookCommand;
import org.usfirst.frc.team2642.robot.commands.climb.ResetHookCommand;
import org.usfirst.frc.team2642.robot.commands.ramp.DeployRampCommand;
import org.usfirst.frc.team2642.robot.commands.ramp.LowerRampCommand;
import org.usfirst.frc.team2642.robot.commands.ramp.RaiseRampCommand;
import org.usfirst.frc.team2642.robot.commands.ramp.ResetRampCommand;

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
	
	public Button xboxA = new JoystickButton(xbox, 1);
	public Button xboxB = new JoystickButton(xbox, 2);
	Button xboxX = new JoystickButton(xbox, 3);
	Button xboxY = new JoystickButton(xbox, 4);
	
	/*
	Left stick = drive 0.6, turn 0.6		Regular Drive
	Left trigger = drive 1.0, turn 0.6		High Speed Drive
	Right trigger = drive 1.0, turn 1.0		High Speed Turn	
	 */	
		
	public static XboxController auxXbox = new XboxController(RobotMap.auxXboxControllerPort);
	
	Button auxXboxA = new JoystickButton(auxXbox, 1);
	Button auxXboxB = new JoystickButton(auxXbox, 2);
	Button auxXboxX = new JoystickButton(auxXbox, 3);
	Button auxXboxY = new JoystickButton(auxXbox, 4);
	/*
	Left stick = tilt up and down 
	
	Right stick = lift up and down 
	
	Left trigger = intake in
	Right trigger = intake out (eject)
	*/
	
	public static Joystick autoDial = new Joystick(RobotMap.autoDialPort);
	
	//left dial
	public static Button dial1 = new JoystickButton(autoDial, 1);
	public static Button dial2 = new JoystickButton(autoDial, 2);
	public static Button dial3 = new JoystickButton(autoDial, 3);
	
	//right dial
	public static Button dial4 = new JoystickButton(autoDial, 4);
	public static Button dial5 = new JoystickButton(autoDial, 5);
	public static Button dial6 = new JoystickButton(autoDial, 6);
	
	public OI() {

		auxXboxA.whenPressed(new DeployHookCommand()); 
		auxXboxX.whenPressed(new ResetHookCommand());

		auxXboxB.whenPressed(new DeployBrakeCommand());
		auxXboxY.whenPressed(new ResetBrakeCommand());
		
		//xboxA.whenPressed(new IntakeCommand());
		//xboxB.whenPressed(new ResetRampCommand());
		
		xboxX.whenPressed(new RaiseRampCommand());
		xboxY.whenPressed(new LowerRampCommand());
	}
}
