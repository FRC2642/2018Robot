package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeTiltSystem extends Subsystem {
	//Motor to tilt intake arm
	Victor intakeTiltMotor = new Victor(RobotMap.intakeTiltMotorPort);
	
    public void initDefaultCommand() {
    }
    
    //Tilt the intake 
    public void tilt(double speed) {
    	intakeTiltMotor.set(speed);
    }
    
    //Off
    public void stopTilt() {
    	intakeTiltMotor.set(0.0);
    }
}