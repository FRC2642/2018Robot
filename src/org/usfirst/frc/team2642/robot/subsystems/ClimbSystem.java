package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimbSystem extends Subsystem {

	public Solenoid climbHook = new Solenoid(RobotMap.climbCylinderChannel);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public void deployHook() {
    	climbHook.set(true);
    }
    
    public void resetHook() {
    	climbHook.set(false);
    }
}

