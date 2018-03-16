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

	//public Solenoid deployRampCylinder = new Solenoid(RobotMap.deployRampCylinderChannel);
			
	//public DoubleSolenoid raiseRampCylinder = new DoubleSolenoid(RobotMap.raiseRampCylinderChannel1, RobotMap.raiseRampCylinderChannel2);
	
	public RampSystem() {
	//	deployRampCylinder.set(false);
		//raiseRampCylinder.set(Value.kReverse);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void deployRamp() {
    	//deployRampCylinder.set(true);
    }
    
    public void resetRamp() {
    	//deployRampCylinder.set(false);
    }
 
    public void raiseRamp() {
    	//raiseRampCylinder.set(Value.kForward);
    }
    
    public void lowerRamp() {
    	//raiseRampCylinder.set(Value.kReverse);
    }	
}

