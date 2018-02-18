package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class RampSystem extends Subsystem {

	public Solenoid deployRampCylinder = new Solenoid(RobotMap.deployRampCylinderChannel);
			
	public Solenoid raiseRampCylinder = new Solenoid(RobotMap.raiseRampCylinderChannel);
	
	public RampSystem() {
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void deployRamp() {
    	deployRampCylinder.set(true);
    }
 
    public void raiseRamp() {
    	raiseRampCylinder.set(true);
    }	
}

