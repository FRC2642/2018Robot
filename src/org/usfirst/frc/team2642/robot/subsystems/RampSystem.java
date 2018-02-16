package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampSystem extends Subsystem {

	DoubleSolenoid leftRampCylinder = new DoubleSolenoid
			(RobotMap.leftRampCylinderChannel1, RobotMap.leftRampCylinderChannel2);
	DoubleSolenoid rightRampCylinder = new DoubleSolenoid
			(RobotMap.rightRampCylinderChannel1, RobotMap.rightRampCylinderChannel2);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void deployRamp() {
    	leftRampCylinder.set(Value.kForward);
    	rightRampCylinder.set(Value.kForward);
    }
    public void resetRamp() {
    	leftRampCylinder.set(Value.kReverse);
    	rightRampCylinder.set(Value.kReverse);
    }
}

