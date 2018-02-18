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
	private static Joystick eStop = new Joystick(2);
	
	static Button dial1 = new JoystickButton(eStop, 9);
	static Button dial2 = new JoystickButton(eStop, 10);
	static Button dial3 = new JoystickButton(eStop, 11);
	static Button dial4 = new JoystickButton(eStop, 12);
	static Button dial5 = new JoystickButton(eStop, 13);
	static Button dial6 = new JoystickButton(eStop, 14);
	static Button dial7 = new JoystickButton(eStop, 15);
	static Button dial8 = new JoystickButton(eStop, 16);
	static Button dial9 = new JoystickButton(eStop, 17);

	
	public static Joystick geteStop() {
		return eStop;
	}
	
	public static XboxController xbox = new XboxController(RobotMap.xboxControllerPort);
	public static XboxController getxBox(){
		return xbox;
	}
	
	Button xboxA = new JoystickButton(xbox, 1);
	Button xboxB = new JoystickButton(xbox, 2);
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
	public OI() {

		auxXboxA.whenPressed(new DeployHookCommand()); 
		auxXboxX.whenPressed(new ResetHookCommand());

		auxXboxB.whenPressed(new DeployBrakeCommand());
		auxXboxY.whenPressed(new ResetBrakeCommand());
		
		xboxA.whenPressed(new DeployRampCommand());
		xboxX.whenPressed(new ResetRampCommand());
		
		xboxB.whenPressed(new RaiseRampCommand());
		xboxY.whenPressed(new LowerRampCommand());
	}
	
	//Xbox Controller on USB port 0
	
}