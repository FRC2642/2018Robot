package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSystem extends Subsystem {
	//Lift motor
	Victor liftMotor = new Victor(RobotMap.liftMotorPort);

    public void initDefaultCommand() {
    }
    
    //Raises the lift
    public void raiseLift() {
    	liftMotor.set(.7);
    }
    
    //Lowers the lift
    public void lowerLift() {
    	liftMotor.set(-.7);
    }
    
    //Off
    public void stopLift() {
    	liftMotor.set(0.0);
    }
}

