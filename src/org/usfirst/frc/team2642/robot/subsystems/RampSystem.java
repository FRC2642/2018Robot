package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampSystem extends Subsystem {

	public DoubleSolenoid rampCylinder = new DoubleSolenoid(RobotMap.rampCylinderChannel1, RobotMap.rampCylinderChannel2);
	
	public Solenoid liftRampCylinder = new Solenoid(RobotMap.liftRampCylinderChannel);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void deployRamp() {
    	rampCylinder.set(Value.kForward);
    }
    public void resetRamp() {
    	rampCylinder.set(Value.kReverse);
    }
    
    public void liftRamp() {
    	liftRampCylinder.set(true);
    }	
}

