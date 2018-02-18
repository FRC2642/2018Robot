package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class RampSystem extends Subsystem {

	public Servo rampServo = new Servo(RobotMap.rampServoMotorPort);
			
	public Solenoid raiseRampCylinder = new Solenoid(RobotMap.raiseRampCylinderChannel);
	
	public RampSystem() {
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void holdRamp() {
    	rampServo.setPosition(.7);
    }  
    
    public void deployRamp() {
    	rampServo.setPosition(0);
    }
 
    public void raiseRamp() {
    	raiseRampCylinder.set(true);
    }	
    
    public void lowerRamp() {
    	raiseRampCylinder.set(false);
    }
}

